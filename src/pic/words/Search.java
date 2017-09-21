package pic.words;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Activity implements OnClickListener,TextWatcher{

	Button search;
	String s,n;
	String d[]=new String[100];
	TextView v;
	private AutoCompleteTextView auto;
	private static String[] autoItems=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		autoItems=getResources().getStringArray(R.array.textwatcherlist);

		search =(Button)findViewById(R.id.search);
		auto=(AutoCompleteTextView)findViewById(R.id.edit);
		auto.addTextChangedListener(this);
		auto.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,autoItems));
		search.setOnClickListener(this);
	}

	public void onClick(View arg0) {

		// TODO Auto-generated method stub
		//char ch; 
		s =auto.getText().toString();
		n=s.toUpperCase().trim();
		v=(TextView)findViewById(R.id.textVi1);

		if((n.length())<=3)
		{
			Intent j=new Intent(this,Error.class);
			startActivity(j);
		}else
		{
			Bundle b = new Bundle();
			b.putString("hello",n);
			Intent i=new Intent(this,disp.class);
			i.putExtras(b);
			startActivity(i);
		}

	}

	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(),"changed1",Toast.LENGTH_SHORT).show();

	}

	public void beforeTextChanged(CharSequence s, int start, int count,
								  int after) {
		// TODO Auto-generated method stub

	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub


	}
}
