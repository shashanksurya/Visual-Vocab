package pic.words;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.RemoteViews;



public class PictionaryWidget extends AppWidgetProvider 
{
	
	char c;
	int fl,gfl;
	String fileNames[];
	
	//shuffling stuff :)
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
	
	//We are shuffling files for a selected character here using randon and determine a proper word for rest of code
	private void randon() {
			gfl=shuffle(fl);
						}
	
	
	//This stores all the filenames in an array and calculates the total number of files
	private void list(Context context) {
		// TODO Auto-generated method stub
		
		 try {
				fileNames=context.getAssets().list(c+File.separator+"TEXT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		fl=fileNames.length;
	}
	
	
	//Image code
	public Bitmap image(Context context,char cm,String sm){
		InputStream is = null;
		
		//String getimagename=sm.substring(0,sm.length()-4);
    	try {
  		  is = context.getAssets().open(cm+File.separator+"IMAGE"+File.separator+sm+".JPG");
  		}catch(Exception e){}
  		Bitmap imge=BitmapFactory.decodeStream(is);
		if(imge==null)
			Log.w("Failed at image loading","failed");
  		return imge;
	}
	
	//Meaning code
	public String meaning(Context context,char cm,String sm)
	{
		//String n=fileNames[gfl].toString();
				try{
					
					InputStream is=context.getAssets().open(cm+File.separator+"TEXT"+File.separator+sm+".TXT");
				 int size = is.available();				
				 byte[] buffer = new byte[size];
				 is.read(buffer);
				 is.close();						
				  return new String(buffer);
				 }
				catch(Exception e){
					return "oops";
				}
				
		
	}
	
	//This determines the character on random basis and stores in globar variable c
private void rando()  
{
	int b= shuffle(26);
		b+=65;
      c=(char)b;
}

	//DONOT MODIFY THIS!!
	 public void onUpdate(Context context, AppWidgetManager appWidgetManager,
		      int[] appWidgetIds) {

		 final String ACTION_CLICK = "ACTION_CLICK";
		 
		    // Get all ids
		    ComponentName thisWidget = new ComponentName(context,
		        PictionaryWidget.class);
		    int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
		    for (int widgetId : allWidgetIds) {
		      // Generating random data
		      
		    	rando();
		    	list(context);
		    	randon();
		    	String word=fileNames[gfl].toString();
		    	
		    	String getridoftxt=word;
		    	getridoftxt=getridoftxt.substring(0,getridoftxt.length()-4);
		    	//String word="ABASH";
		    	//c='A';
		    	
		    	
		    	
		    	
		      RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
		          R.layout.pictionarywidget);
		      Log.w("WidgetExample", word);
		      // Set the text
		      remoteViews.setTextViewText(R.id.Wword, getridoftxt);
		      remoteViews.setImageViewBitmap(R.id.Wimage, image(context,c,getridoftxt));
		      remoteViews.setTextViewText(R.id.Wmeaning,meaning(context,c,getridoftxt));
		      // Register an onClickListener
		      Intent intent = new Intent(context, PictionaryWidget.class);

		      intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
		      intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

		      PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
		          0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		      remoteViews.setOnClickPendingIntent(R.id.Wimage, pendingIntent);
		      remoteViews.setOnClickPendingIntent(R.id.Wmeaning, pendingIntent);
		      remoteViews.setOnClickPendingIntent(R.id.Wword, pendingIntent);
		      appWidgetManager.updateAppWidget(widgetId, remoteViews);
		    }
		  }
}
