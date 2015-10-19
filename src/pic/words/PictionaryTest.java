package pic.words;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import junit.framework.Test;




public class PictionaryTest extends Activity{
		TextView tv_number,question;
		ImageView hinter,iv;
		String fileNames[];
		String wordlist[]=new String[10];
		int answerlist[]=new int[10];
		int alphabets[]=new int[26];
		String options[]=new String[3];
		ProgressDialog progressBar;
		 int progressBarStatus = 0;
		 Handler progressBarHandler = new Handler();
		char c;
		int fl,gfl,ques_no=1,alphadecider=0,correct=0,incorrect=0,unattmpt=0,wordsize=0;
		Button next;
		RadioButton r1,r2,r3,r4,selected;
		RadioGroup gr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.pictionarytest);
		  tv_number=(TextView)findViewById(R.id.number);
		  
		     r1=(RadioButton)findViewById(R.id.opt1);
		     r2=(RadioButton)findViewById(R.id.opt2);
		     r3=(RadioButton)findViewById(R.id.opt3);
		     r4=(RadioButton)findViewById(R.id.opt4);
		    hinter=(ImageView)findViewById(R.id.hintimage);
		    iv=(ImageView)findViewById(R.id.hintimage2);
		     next=(Button)findViewById(R.id.anext);
		     gr=(RadioGroup) findViewById(R.id.radiopt);
		  
		
		setAlphabets(); 
		generator(this);
		//wordGenerator();//words are generated now for the tests
			
		
		   question=(TextView)findViewById(R.id.question);
	  questionGenerator();
	  //Log.w("1","1");
	     
	     next.setOnClickListener(new View.OnClickListener() {//********NEED TO WRITE*****
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				ques_no++;
				if(ques_no>=11)
				{				
					if(ques_no==11){
					String word=wordlist[9];
					 if((r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()))

				     {
					int selectedId=0;
					selectedId=gr.getCheckedRadioButtonId();
					selected=(RadioButton)findViewById(selectedId);
				     //Log.w((String) selected.getText(),word);
			         if(selected.getText().equals(word)){
			        	 answerlist[9]=1;//CORRECT ANSWER IS 1
			        	 correct++;}
			          else{
			        	 incorrect++;
			        	 answerlist[9]=0;//INCORRECT ANSWER IS 0
			          }
				     }
				     else {
			        	 unattmpt++;
			        	 answerlist[9]=3;//UNATTEMPTED ANSWER IS 3
				     }
					}
					
					
					
				Intent t= new Intent(getBaseContext(),TestResult.class);
			Bundle b=new Bundle();
				b.putInt("c", correct);
				b.putInt("i",incorrect);
				b.putInt("u",unattmpt);
				b.putIntArray("anslist",answerlist);
				b.putStringArray("wordlist",wordlist);
				t.putExtras(b);
				startActivity(t);
				return;
					
				}
				String word=wordlist[ques_no-2];
				//Log.w("word",word);
				//check whether its correct or not or unattempted
				
				
			     if((r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()))

			     {
				int selectedId=0;
				selectedId=gr.getCheckedRadioButtonId();
		        
				selected=(RadioButton)findViewById(selectedId);
			     //Log.w((String) selected.getText(),word);
		         if(selected.getText().equals(word)){
		        	 answerlist[ques_no-2]=1;//CORRECT ANSWER IS 1
		        	 correct++;}
		          else{
		        	 incorrect++;
		        	 answerlist[ques_no-2]=0;//INCORRECT ANSWER IS 0
		          }
			     }
			     else {
		        	 unattmpt++;
		        	 answerlist[ques_no-2]=3;//UNATTEMPTED ANSWER IS 3
			     }
				if(ques_no==10)
				{
					
					next.setText("Submit");
					
				}
				if(ques_no<=10)
				questionGenerator();
				InputStream is = null;
				
			
		        
				
				//set the image back to black(HINT) and clear checked options
				try {
				  is = getAssets().open("blackdot.jpg");
				}catch(Exception e){}
				Bitmap imge=BitmapFactory.decodeStream(is);
				iv.setImageBitmap(imge);
				((RadioGroup) findViewById(R.id.radiopt)).clearCheck();

			}
		});
	     hinter.setOnClickListener(new View.OnClickListener() {
	    		public void onClick(View v) {
	    			image(wordlist[(ques_no-1)]);
	    			
	    			

	    		}
	     });
	     
	 }
	
	public void generator(Context context)
	{
		progressBar = new ProgressDialog(context);
		progressBar.setCancelable(true);
		progressBar.setMessage("Generating Test...Please wait!");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();

		//reset progress bar status
		progressBarStatus = 0;

		//reset filesize
		wordsize = 0;
		new Thread(new Runnable() {
			  public void run() {
				while (wordsize < 10) {

				  // process some tasks
				  progressBarStatus = (wordGenerator())*10;

				  // your computer is too fast, sleep 1 second
				

				  // Update the progress bar
				  progressBarHandler.post(new Runnable() {
					public void run() {
					  progressBar.setProgress(progressBarStatus);
					}
				  });
				
				}

				// ok, file is downloaded,
				if (wordsize >= 10) {

					// sleep 2 seconds, so that you can see the 100%
				

					// close the progress bar dialog
					progressBar.dismiss();
				}
			  }
		       }).start();
		
	}

		//setting the question,options,etc...EVERYTHING HAPPENS HERE
	private void questionGenerator() {
		// TODO Auto-generated method stub
		if(ques_no==1)
		{
			try {
				
				Thread.sleep(650);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tv_number.setText("Question"+ques_no);
		text(wordlist[(ques_no-1)]);
		
		//SETTING THE OPTIONS
		int answersetter=shuffle(4);//gives a random position to place the option
	
		optionGenerator(wordlist[(ques_no-1)]);
		if(options[0].equals(null)||options[1].equals(null)||options[0].equals("")||options[0].equals(" ")){
			optionGenerator(wordlist[(ques_no-1)]);
			}
		if(answersetter==1||answersetter==0)
		{
			r1.setText(wordlist[ques_no-1]);
		    r2.setText(options[0]);
		    r3.setText(options[1]);
		    r4.setText(options[2]);
		}
		  
		if(answersetter==2)
		{
			r1.setText(options[0]); 
			r2.setText(wordlist[ques_no-1]);
		    r3.setText(options[1]);
		    r4.setText(options[2]);
		}
		
		if(answersetter==3)
		{
			r1.setText(options[1]);
			r2.setText(options[0]);
			r3.setText(wordlist[ques_no-1]);
		    r4.setText(options[2]);
		}
		
		if(answersetter==4)
		{
			r1.setText(options[2]);
		    r2.setText(options[0]);
		    r3.setText(options[1]);
		    r4.setText(wordlist[ques_no-1]);
		}
	}

	public int shuffle(int length) {
		// TODO Auto-generated method stub
		SecureRandom rgen = new SecureRandom();  
		int[] cards = new int[length];  
		
		for (int i=0; i<cards.length; i++) {
		    cards[i] = i;
		} //filling the array with values...not shuffling
		
		for (int i=0; i<cards.length-1; i++) { //FIRST SHUFFLING..PRODUCING SAME VALUES REPEATEDLY
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
			
		}
		return cards[rgen.nextInt(cards.length)];
		
		/*for (int i=0; i<cards.length-1; i++) { //DUAL SHUFFLING TO AVOID REPEATED VALUES
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
		globvar=temp;
		break;
		}
		return globvar;*/
	}

	public void setAlphabets() {
		// TODO Auto-generated method stub
		SecureRandom rgen = new SecureRandom();  
		int[] cards = new int[26];  
		for (int i=0; i<cards.length; i++) {
		    cards[i] = i;
		} //filling the array with values...not shuffling
		
		for (int i=0; i<cards.length-1; i++) { //FIRST SHUFFLING..PRODUCING SAME VALUES REPEATEDLY
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
			
		}
		alphabets=cards;
		cards=null;
		/*for (int i=0; i<cards.length-1; i++) { //DUAL SHUFFLING TO AVOID REPEATED VALUES
		    int randomPosition = rgen.nextInt(cards.length);
		    int temp = cards[i];
		    cards[i] = cards[randomPosition];
		    cards[randomPosition] = temp;
		globvar=temp;
		break;
		}
		return globvar;*/
	}
	private void image(String word) {
		// TODO Auto-generated method stub
		  
		InputStream is = null;
		
		
		try {
		  is = getAssets().open((word.substring(0,1))+File.separator+"IMAGE"+File.separator+word+".JPG");
		}catch(Exception e){}
		Bitmap imge=BitmapFactory.decodeStream(is);
		iv.setImageBitmap(imge);
	//	nv.setText(n);
		
		
		
	}

	private void randon() {
		// TODO Auto-generated method stub
		
		SecureRandom rgen = new SecureRandom();  
		gfl=rgen.nextInt(fl);
		//gfl=shuffle(fl);
		
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
	
	
	
	

	
	private void text(String word) {
		// TODO Auto-generated method stub
			
try{
			
			InputStream is=getAssets().open((word.substring(0,1))+File.separator+"TEXT"+File.separator+word+".TXT");
		 int size = is.available();				
		 byte[] buffer = new byte[size];
		 is.read(buffer);
		 is.close();						
		  question.setText(new String(buffer));
		  //Log.w("called",word);
		 //String m;
		// int k=(n.length()-4);
		 //m=n.substring(0,k);
		 // aname.setText(m);
		}catch(Exception e){}
		}

	private void rando()  
	
	{
		// TODO Auto-generated method stub
       int b;
		b=alphabets[alphadecider];
		alphadecider++;
		if(alphadecider==25)
			alphadecider=0;
		b+=65;
	    c=(char)b;
}
	
	//Using for generating words for the test
		private int wordGenerator()
		{
			
			
			    rando();
				list();
				randon();
				String word=fileNames[gfl].toString();
				int k=(word.length())-4;
				wordlist[wordsize]=word.substring(0,k);
								
				//Log.w(wordlist[wordsize],wordlist[wordsize]);
				wordsize++;
			return wordsize;
					
			
			
			//duplicateChecker(wordlist);
			
		}

	//checks and removes duplicates in the wordgenerator method, just pass the array
	private void duplicateChecker(String[] list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.length;i++)
		{
			for(int j=i+1;j<list.length;j++)
			{
				while( list[i].equals(list[j]) )
				{
					rando();
					list();
					randon();
					String word=fileNames[gfl].toString();
					int k=(word.length())-4;
					list[i]=word.substring(0,k);
					}
					
			}
			
		}
	}//end of duplicateChecker
	
	private void optionGenerator(String question)
	{
		
		for(int i=0;i<3;i++)
		{
			rando();
			list();
			randon();
			String word=fileNames[gfl].toString();
			int k=(word.length())-4;
			options[i]=word.substring(0,k);
			while(options[i].equals(question))
			{
				rando();
				list();
				randon();
				String word2=fileNames[gfl].toString();
				int k2=(word2.length())-4;
				options[i]=word2.substring(0,k2);
				Log.w("dupoption",question);
			}	
		}
		duplicateChecker(options);
		
	}
	

}
