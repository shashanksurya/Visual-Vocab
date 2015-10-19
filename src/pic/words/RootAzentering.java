package pic.words;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import pic.words.SimpleGestureFilter.SimpleGestureListener;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import pic.words.SimpleGestureFilter.SimpleGestureListener;
public class RootAzentering extends Activity implements OnClickListener,OnInitListener,SimpleGestureListener
{
	 private SimpleGestureFilter detector;
       // Button anext,aback;
        TextView amea,aname;
        ImageView aimg;
        String s,voicetitle = new String();
        int i,j=0;
     boolean check=false;
     private ImageButton speak;
     private TextToSpeech speech;
    	String fileNames[];
        
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.az);
		detector = new SimpleGestureFilter(this,this);
		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		initialise();
		//anext.setWidth(width/2);
		//aback.setWidth(width/2);
		next();
		try {
			fileNames=getAssets().list("assetsroot"+File.separator+s+File.separator+"TEXT");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(fileNames.length!=0)
		i=fileNames.length;
		opentext();
		openimage();
		////aback.setOnClickListener(this);
		//anext.setOnClickListener(this);
		speak.setOnClickListener(this);
	}

	
	
	
	
	
	
	private void openimage() {
		// TODO Auto-generated method stub
		
		
		InputStream is = null;
		String m=fileNames[j].toString();
		int k=(m.length())-4;
		String n=m.substring(0,k);
		try {
		  is = getAssets().open("assetsroot"+File.separator+s+File.separator+"IMAGE"+File.separator+n+".JPG");
		}catch(Exception e){}
		Bitmap imge=BitmapFactory.decodeStream(is);
		aimg.setImageBitmap(imge);
		aname.setText(n);
		voicetitle=n;
	}
		
	







	private void opentext() {
		// TODO Auto-generated method stub
		
		String n=fileNames[j].toString();
try{
			
			InputStream is=getAssets().open("assetsroot"+File.separator+s+File.separator+"TEXT"+File.separator+n);
		 int size = is.available();				
		 byte[] buffer = new byte[size];
		 is.read(buffer);
		 is.close();						
		  amea.setText(new String(buffer));
		 //String m;
		// int k=(n.length()-4);
		 //m=n.substring(0,k);
		 // aname.setText(m);
		}catch(Exception e){}
		
		
		
	}







	private void next() {
		// TODO Auto-generated method stub
		Bundle got= new Bundle();
		got=getIntent().getExtras();
		s=got.getString("hello");
		
	}

	
	
	
	
	
	
	
	
	
	private void initialise() {
		//anext=(Button)findViewById(R.id.anext);
		//aback=(Button)findViewById(R.id.aback);
		amea=(TextView)findViewById(R.id.amea);
		aname=(TextView)findViewById(R.id.aname);
		aimg=(ImageView)findViewById(R.id.aimage);
		speak=(ImageButton)findViewById(R.id.voicetitle);
		 speech=new TextToSpeech(this, this);
		// TODO Auto-generated method stub
		
	}

	
	public void onClick(View arg) {
		// TODO Auto-generated method stub
		/*if(j==0)
		{
		 aback.setBackgroundColor(Color.BLACK);
		}
		else
		{
			if(j==(i-1))
			{
				anext.setBackgroundColor(Color.BLACK);
			}
		}*/
		
		switch(arg.getId())
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
		Log.e("TTS", "“Initilization Failed!");
	}

	else

	{
	speak.setEnabled(true);
	speak();
	}

	}

	else

	{
	Log.e("TTS", "“Initilization Failed!");
	}

	}

	public void onDestroy() {
		// Don’t forget to shutdown tts!
		if (speech != null) {
		speech.stop();
		speech.shutdown();
		}
		super.onDestroy();
		}
	
	private void speak()
	{

	String text =voicetitle;// voicetitle.toString();
      if(check==true)
	speech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}






	public void onSwipe(int direction) {
		// TODO Auto-generated method stub
		String str = "";
	      
	      switch (direction) {
	      
	      case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
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
	      
	          
			
			
			
	      case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
	      if(j<i)
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

	      
	      
	      
	  
	                                                     break;
	      /*case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
	                                                     break;
	      case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
	                                                     break;*/
	      
	      }
	      
		
	}







	public void onDoubleTap() {
		// TODO Auto-generated method stub
		
	}

	
	
	 public boolean dispatchTouchEvent(MotionEvent me){
	        // Call onTouchEvent of SimpleGestureFilter class
	         this.detector.onTouchEvent(me);
	       return super.dispatchTouchEvent(me);
	    }
	
	
	
	
	
}