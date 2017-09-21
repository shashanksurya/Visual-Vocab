package pic.words;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import pic.words.SimpleGestureFilter.SimpleGestureListener;
public class DisplayingWord extends Activity implements SimpleGestureListener{
	public SimpleGestureFilter detector;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	static String s = new String();
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	static String fileNames[];
	static int i,j=0;
	static String voicetitle=null;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		detector = new SimpleGestureFilter(this,this);
		mTitle = mDrawerTitle = getTitle();
		next();
		try {
			fileNames=getAssets().list(s+File.separator+"TEXT");
			i=fileNames.length;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//to remove .txt from the drawers list
		for(j=0;j<fileNames.length;j++)
		{


			int k=(fileNames[j].length())-4;
			fileNames[j]=fileNames[j].substring(0,k);

		}

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawerlistitem, fileNames));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(
				this,                  /* host Activity */
				mDrawerLayout,         /* DrawerLayout object */
				R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
				R.string.drawer_open,  /* "open drawer" description for accessibility */
				R.string.drawer_close  /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	    
	 /*  public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.main, menu);
	        return super.onCreateOptionsMenu(menu);
	    }

	    /* Called whenever we call invalidateOptionsMenu() */
	    
	  /*public boolean onPrepareOptionsMenu(Menu menu) {
	        // If the nav drawer is open, hide action items related to the content view
	        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
	        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
	        return super.onPrepareOptionsMenu(menu);
	    }*/




	private void next() {
		// TODO Auto-generated method stub
		Bundle got= new Bundle();
		got=getIntent().getExtras();
		s=got.getString("hello");

	}

	//open drawer list
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action buttons
		switch(item.getItemId()) {
			case R.id.action_websearch:
				Toast.makeText(this," R.string.app_not_available", Toast.LENGTH_LONG).show();

				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


	/* The click listner for ListView in the navigation drawer */
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments
		Fragment fragment = new PlanetFragment();
		Bundle args = new Bundle();
		args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		fragment.setArguments(args);

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		//delete here
		String actiontitle=fileNames[position].toString();

		setTitle(actiontitle);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}



















	/**
	 * Fragment that appears in the "content_frame", shows a planet
	 */
	public static class PlanetFragment extends Fragment implements OnClickListener,TextToSpeech.OnInitListener {


		public static final String ARG_PLANET_NUMBER = "planet_number";
		View rootView;
		//Button anext,aback;
		TextView amea,aname;
		private ImageButton speak;
		ImageView aimg;
		String planet;
		private TextToSpeech speech;
		Boolean check=false;
		public PlanetFragment() {

			// Empty constructor required for fragment subclasses
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState) {



			rootView = inflater.inflate(R.layout.az, container, false);
			j= getArguments().getInt(ARG_PLANET_NUMBER);


			DisplayMetrics metrics = this.getResources().getDisplayMetrics();
			int width = metrics.widthPixels;
			int height = metrics.heightPixels;

			//anext=((Button)rootView.findViewById(R.id.aback));
			//anext.setOnClickListener(this);
			// aback=((Button)rootView.findViewById(R.id.anext));
			// aback.setOnClickListener(this);
			speech=new TextToSpeech(rootView.getContext(), this);
			speak=(ImageButton)rootView.findViewById(R.id.voicetitle);
			speak.setOnClickListener(this);
			// anext.setWidth(width/2);
			//aback.setWidth(width/2);
			opentext();
			openimage();
             	      /*      int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
	                            "drawable", getActivity().getPackageName());
	            ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
	            getActivity().setTitle(planet);*/
			return rootView;
		}





		private void openimage() {
			// TODO Auto-generated method stub


			InputStream is = null;
			String m=fileNames[j].toString();
				/*int k=(m.length())-4;
				String n=m.substring(0,k);*/
			try {
				is = rootView.getContext().getAssets().open(s+File.separator+"IMAGE"+File.separator+m+".JPG");
			}catch(Exception e){}
			Bitmap imge=BitmapFactory.decodeStream(is);
			((ImageView)rootView.findViewById(R.id.aimage)).setImageBitmap(imge);

			((TextView)rootView.findViewById(R.id.aname)).setText(m);
			//aimg.setImageBitmap(imge);
			//aname.setText(n);
			voicetitle=m;

		}



		private void opentext() {
			// TODO Auto-generated method stub

			String n=fileNames[j].toString();
			try{

				InputStream is=rootView.getContext().getAssets().open(s+File.separator+"TEXT"+File.separator+n+".TXT");
				int size = is.available();
				byte[] buffer = new byte[size];
				is.read(buffer);
				is.close();
				//amea.setText(new String(buffer));
				String settingMeaning=new String(buffer);
				((TextView)rootView.findViewById(R.id.amea)).setText(settingMeaning);

				//String m;
				// int k=(n.length()-4);
				//m=n.substring(0,k);
				// aname.setText(m);
			}catch(Exception e){}



		}

		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
				case R.id.voicetitle:check=true;
					speak();
					break;
				
				
				
				/*case R.id.aback:	
									if(j==0){
									j=i-1;
									openimage();
									opentext();
									}
									else{
											j--;
									openimage();
									opentext();
									}
									
								
									break;
				case R.id.anext:if(j<i)
									{
					                   
									
										j++;
										if(j==i)
										{
											j=0;
										}
										openimage();
										opentext();
										
									}
								else
								{
									j=0;
									openimage();
									opentext();
								}
			
				                  
									break;*/

			}

		}

		public void onInit(int status)

		{

			if (status == TextToSpeech.SUCCESS)

			{

				int result = speech.setLanguage(Locale.US);

				if (result == TextToSpeech.LANG_MISSING_DATA
						|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
					Log.e("TTS", "�Initilization Failed!");
				}

				else

				{
					speak.setEnabled(true);
					speak();
				}

			}

			else

			{
				Log.e("TTS", "�Initilization Failed!");
			}

		}

		public void onDestroy() {
			// Don�t forget to shutdown tts!
			if (speech != null) {
				speech.stop();
				speech.shutdown();
			}
			super.onDestroy();
		}

		private void speak()
		{

			String text = voicetitle.toString();
			if(check==true)
				speech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		}




	}




	public boolean dispatchTouchEvent(MotionEvent me){
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
	public void onSwipe(int direction) {
		String str = "";
























		switch (direction) {

			case SimpleGestureFilter.SWIPE_LEFT : str = "Swipe Right";
				if(j<i)
				{


					j++;
					if(j==i)
					{
						j=0;
					}

				}
				else
				{
					j=0;
				}

				callingFragment();
				break;











			case SimpleGestureFilter.SWIPE_RIGHT :  str = "Swipe Left";

				if(j==0){
					j=i-1;

				}
				else{
					j--;

				}
			/* Fragment fragment1 = new PlanetFragment();
		        Bundle args1 = new Bundle();
		        args1.putInt(PlanetFragment.ARG_PLANET_NUMBER,j);
		        fragment1.setArguments(args1);

		        FragmentManager fragmentManager1 = getFragmentManager();
		        fragmentManager1.beginTransaction().replace(R.id.content_frame, fragment1).commit();

		        // update selected item and title, then close the drawer
		        mDrawerList.setItemChecked(j, true);
		        //delete here
		        String actiontitle1=fileNames[j].toString();
		        
				setTitle(actiontitle1);*/
				callingFragment();
				break;


		}

		//Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	public void callingFragment()
	{
		Fragment fragment = new PlanetFragment();
		Bundle args = new Bundle();
		args.putInt(PlanetFragment.ARG_PLANET_NUMBER,j);
		fragment.setArguments(args);

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(j, true);
		//delete here
		String actiontitle=fileNames[j].toString();

		setTitle(actiontitle);
	}


	public void onDoubleTap() {
		// TODO Auto-generated method stub

	}
}