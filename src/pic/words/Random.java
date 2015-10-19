package pic.words;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Locale;


public class Random extends Activity implements OnClickListener,OnInitListener{
		TextView tv,nv;
		ImageView iv;
		String voicetitle,fileNames[];
		char c;
		int fl,gfl;
		Button b;
	     private TextToSpeech tts;
	     private ImageButton btnSpeak;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	     setContentView(R.layout.splash);
	     tts = new TextToSpeech(this, this);
	     tv=(TextView)findViewById(R.id.amea);
	     iv=(ImageView)findViewById(R.id.aimage);
	     nv=(TextView)findViewById(R.id.aname);
	     b=(Button)findViewById(R.id.anext);
	    btnSpeak=(ImageButton)findViewById(R.id.voicetitle);
	     
	    btnSpeak.setOnClickListener(new OnClickListener() {
			 
            public void onClick(View arg0) {
                                //Method yet to be defined
                 speakOut();
            }});
	     rando();//for alphabets
	    
	     list();
	       randon();//for list values
	     text(); 
	     image();
	     b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				rando();
			     list();
			     randon();    
			     text(); 
			     image();
				
			}
		});
	 
	     
	     
	     
	     
	     
	}
	
	
	
	public void onInit(int status) {
        // TODO Auto-generated method stub
          //TTS is successfully initialized
        if (status == TextToSpeech.SUCCESS) {
                       //Setting speech language
            int result = tts.setLanguage(Locale.US);
           //If your device doesn't support language you set above
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                           //Cook simple toast message with message
                Toast.makeText(this, "Language not supported", Toast.LENGTH_LONG).show();
                Log.e("TTS", "Language is not supported");
            }
                 //Enable the button - It was disabled in main.xml (Go back and Check it)
                        else {
                btnSpeak.setEnabled(true);
            }
            //TTS is not initialized properly
        } else {
                    Toast.makeText(this, "TTS Initilization Failed", Toast.LENGTH_LONG).show();
            Log.e("TTS", "Initilization Failed");
        }
    }



	public void onDestroy() {
        // Don't forget to shutdown!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
	
	
	private void speakOut() {
        //Get the text typed
       String text =voicetitle.toString();
        //If no text is typed, tts will read out 'You haven't typed text'
        //else it reads out the text you typed
       if (text.length() == 0) {
           tts.speak("You haven't typed text", TextToSpeech.QUEUE_FLUSH, null);
       } else {
           tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
       }

   }

	public int shuffle(int length) {
		// TODO Auto-generated method stub
		SecureRandom rgen = new SecureRandom();  
		int[] cards = new int[length];  
		int globvar=0;
		for (int i=0; i<cards.length; i++) {
		    cards[i] = i;
		} //filling the array with values...not shuffling
		
		for (int i=0; i<cards.length-1; i++) { //FIRST SHUFFLING..PRODUCING SAME VALUES REPEATEDLY
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
				}
		
		for (int i=0; i<cards.length-1; i++) { //DUAL SHUFFLING TO AVOID REPEATED VALUES
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
		globvar=temp;
		break;
		}
		return globvar;
	}

	private void image() {
		// TODO Auto-generated method stub
		
		InputStream is = null;
		String m=fileNames[gfl].toString();
		int k=(m.length())-4;
		String n=m.substring(0,k);
		try {
		  is = getAssets().open(c+File.separator+"IMAGE"+File.separator+n+".JPG");
		}catch(Exception e){}
		Bitmap imge=BitmapFactory.decodeStream(is);
		iv.setImageBitmap(imge);
		nv.setText(n);
		voicetitle=n;
		
		
		
	}

	private void randon() {
		// TODO Auto-generated method stub
		
		

		gfl=shuffle(fl);
		
	}

	
	
	
	private void list() {
		// TODO Auto-generated method stub
		
		 try {
				fileNames=getAssets().list(c+File.separator+"TEXT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		fl=fileNames.length;
	}
	
	
	
	

	
	private void text() {
		// TODO Auto-generated method stub
		String n=fileNames[gfl].toString();
		
		
		
try{
			
			InputStream is=getAssets().open(c+File.separator+"TEXT"+File.separator+n);
		 int size = is.available();				
		 byte[] buffer = new byte[size];
		 is.read(buffer);
		 is.close();						
		  tv.setText(new String(buffer));
		 //String m;
		// int k=(n.length()-4);
		 //m=n.substring(0,k);
		 // aname.setText(m);
		}catch(Exception e){}
		}

	private void rando()  
	
	{
		// TODO Auto-generated method stub

		int b= shuffle(26);

		
		b+=65;
	      c=(char)b;
   
	
	
}



	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
