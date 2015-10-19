package pic.words;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PictionaryActivity extends Activity implements OnClickListener
{
    
	  ImageButton az,rando,exit,find,test,fb,tweet,root,share;
	  
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        initialise();
       
        
       
    }




	private void initialise() {
		// TODO Auto-generated method stub
		test=(ImageButton)findViewById(R.id.imageButton4);
		az=(ImageButton)findViewById(R.id.imageButton1);
		rando=(ImageButton)findViewById(R.id.imageButton2);
		exit=(ImageButton)findViewById(R.id.imageButton5);
		find=(ImageButton)findViewById(R.id.imageButton3);
		fb=(ImageButton)findViewById(R.id.facebook);
		tweet=(ImageButton)findViewById(R.id.tweet);
		root=(ImageButton)findViewById(R.id.rootbutton);
	    share=(ImageButton)findViewById(R.id.share);
	       find.setOnClickListener(this);
	       az.setOnClickListener(this);
	       rando.setOnClickListener(this);
	       exit.setOnClickListener(this);
	       test.setOnClickListener(this);
	       fb.setOnClickListener(this);
	       tweet.setOnClickListener(this);
	       root.setOnClickListener(this);
	       share.setOnClickListener(this);
	}
 
	public static Intent getOpenFacebookIntent(Context context) {

	    try {
	        context.getPackageManager()
	                .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
	        return new Intent(Intent.ACTION_VIEW,
	                Uri.parse("fb://profile/460000027367560")); //Trys to make intent with FB's URI
	    } catch (Exception e) {
	        return new Intent(Intent.ACTION_VIEW,
	                Uri.parse("http://www.facebook.com/pages/Dot-Tech/460000027367560?ref=hl")); //catches and opens a url to the desired page
	    }
	}
	
	
	
	public void onClick(View v) {
		 
		  switch(v.getId())
		  {
		  case R.id.rootbutton:Intent root=new Intent(this,RootClass.class);
		  						startActivity(root);
			                         break;
			  
			  
			  
		  case R.id.imageButton1:		Intent z=new Intent(this,Atoz.class);
		  					
			  				startActivity(z);
			  				break;
		
			  			
		  case R.id.imageButton2:Intent r=new Intent(this,Random.class);
										startActivity(r);
						  			  				break;
	  			
	  			
	  			
		  case R.id.imageButton4: Intent t= new Intent(this,PictionaryTest.class);
			
		 
			  
			
		           /*try{
		        	   
		           
			 
			      Thread.sleep(1000);
		           }
		           
		           catch(InterruptedException e){}*/
		           startActivity(t);         
		        	
			
			  		
			  				break;
	  			
	  			
	  			
		  case R.id.imageButton3:  Intent i= new Intent(this,Search.class);
		  					startActivity(i);
			  				break;
			  				
			  				
		  case R.id.imageButton5:System.exit(0);
		  														break;
			 
		  case R.id.facebook:
			  Context c=getApplicationContext();
			   Intent f = getOpenFacebookIntent(c); 
			  startActivity(f);
			break;
			
		  case R.id.share:    
			  
			  
			  Intent ii=new Intent(android.content.Intent.ACTION_SEND);
			  ii.setType("text/plain");
			  ii.putExtra(android.content.Intent.EXTRA_SUBJECT,"Hi download this free app PICTIONARY(VOCAB BUILDER)\n");
			  ii.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.words.pictionaryfree");
			  startActivity(Intent.createChooser(ii,"Share via"));
			  break;
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
		  case R.id.tweet:
			  try {
				  Intent intent = new Intent(Intent.ACTION_VIEW,
				      Uri.parse("twitter://user?user_id=624490754"));
				  startActivity(intent);

				  }catch (Exception e) {
				      startActivity(new Intent(Intent.ACTION_VIEW,
				           Uri.parse("https://twitter.com/DotTech2"))); 
				  } 
			break;
		  }
		  
		
		// TODO Auto-generated method stub
		
	}
}