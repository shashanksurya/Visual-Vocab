package pic.words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;



public class TestResult extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	   setContentView(R.layout.testresult);
	 ListView lv= (ListView)findViewById(R.id.listview);
	    Bundle bundle = getIntent().getExtras();
  String[] wordlist=bundle.getStringArray("wordlist");         
  int[] answerlist=bundle.getIntArray("anslist");  
      TextView tv=(TextView)findViewById(R.id.result);
     tv.setText("You got "+Integer.toString(bundle.getInt("c"))+" out of 10 and "+Integer.toString(bundle.getInt("u"))+" are unattempted!");
   // create the grid item mapping
      String[] from = new String[] { "col_1", "col_2"};
      int[] to = new int[] { R.id.item1, R.id.item2};
   // prepare the list of all records
      List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
      for(int i = 0; i < 10; i++){
      	HashMap<String, String> map = new HashMap<String, String>();
      	map.put("col_1", wordlist[ i]);
      	if(answerlist[ i]==0)
      	      	map.put("col_2", "WRONG");
      	if(answerlist[ i]==1)
  	      	map.put("col_2", "CORRECT");
      	if(answerlist[ i]==3)
  	      	map.put("col_2", "UNATTEMPTED");
      //	map.put("col_3", "col_3_item_" + i);
      	fillMaps.add(map);
      }
      // fill in the grid_item layout
      SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.grid_list, from, to);
      lv.setAdapter(adapter);
      
      
	}
	
}
