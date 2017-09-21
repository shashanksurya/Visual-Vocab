package pic.words;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.awt.*;

public class disp extends Activity  {
	String s,v;
	char ch;
	ImageView img;
	TextView name,mea;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture);
		initialise();
		search();
	}
	private void search() {
		// TODO Auto-generated method stub
		Bundle got= new Bundle();
		got=getIntent().getExtras();
		s=got.getString("hello");
		v=s.substring(0,((s.length())-4));
		ch=s.charAt(0);
		text();
		image();

	}
	private void image() {
		// TODO Auto-generated method stub
		InputStream is = null;
		try {
			is = getAssets().open(ch+File.separator+"IMAGE"+File.separator+s+".JPG");
		}catch(Exception e){}
		Bitmap imge=BitmapFactory.decodeStream(is);
		img.setImageBitmap(imge);

	}

	private void text() {

		// TODO Auto-generated method stub

		try{

			InputStream is=getAssets().open(ch+File.separator+"TEXT"+File.separator+s+".TXT");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			mea.setText(new String(buffer));
			name.setText(s);
		}catch(Exception e){}
	}

	private void initialise() {

		name=(TextView)findViewById(R.id.name);
		mea=(TextView)findViewById(R.id.mea);
		img=(ImageView)findViewById(R.id.image);

		// TODO Auto-generated method stub

	}

	// TODO Auto-generated method stub

}
