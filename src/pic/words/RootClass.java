package pic.words;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class RootClass extends Activity implements OnClickListener{




	ImageButton A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,r,S,T,U,V,W,X,Y,Z;
	String s= new String();
	Bundle b = new Bundle();
	Intent i;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alpha);
		initialize();
		A.setOnClickListener(this);
		B.setOnClickListener(this);
		C.setOnClickListener(this);
		D.setOnClickListener(this);
		E.setOnClickListener(this);
		F.setOnClickListener(this);
		G.setOnClickListener(this);
		H.setOnClickListener(this);
		I.setOnClickListener(this);
		J.setOnClickListener(this);
		K.setOnClickListener(this);
		L.setOnClickListener(this);
		M.setOnClickListener(this);
		N.setOnClickListener(this);
		O.setOnClickListener(this);
		P.setOnClickListener(this);
		Q.setOnClickListener(this);
		Z.setOnClickListener(this);
		r.setOnClickListener(this);
		S.setOnClickListener(this);
		T.setOnClickListener(this);
		U.setOnClickListener(this);
		V.setOnClickListener(this);
		W.setOnClickListener(this);
		X.setOnClickListener(this);
		Y.setOnClickListener(this);


	}



	private void initialize() {
		// TODO Auto-generated method stub
		A=(ImageButton)findViewById(R.id.imageButton1);
		B=(ImageButton)findViewById(R.id.imageButton2);
		C=(ImageButton)findViewById(R.id.imageButton3);
		D=(ImageButton)findViewById(R.id.imageButton4);
		E=(ImageButton)findViewById(R.id.imageButton5);
		F=(ImageButton)findViewById(R.id.imageButton6);
		G=(ImageButton)findViewById(R.id.imageButton7);
		H=(ImageButton)findViewById(R.id.imageButton8);
		I=(ImageButton)findViewById(R.id.imageButton9);
		J=(ImageButton)findViewById(R.id.imageButton10);
		K=(ImageButton)findViewById(R.id.imageButton11);
		L=(ImageButton)findViewById(R.id.imageButton12);
		M=(ImageButton)findViewById(R.id.imageButton13);
		N=(ImageButton)findViewById(R.id.imageButton14);
		O=(ImageButton)findViewById(R.id.imageButton15);
		P=(ImageButton)findViewById(R.id.imageButton16);
		Q=(ImageButton)findViewById(R.id.imageButton17);
		r=(ImageButton)findViewById(R.id.imageButton18);
		S=(ImageButton)findViewById(R.id.imageButton19);
		T=(ImageButton)findViewById(R.id.imageButton20);
		U=(ImageButton)findViewById(R.id.imageButton21);
		V=(ImageButton)findViewById(R.id.imageButton22);
		W=(ImageButton)findViewById(R.id.imageButton23);
		X=(ImageButton)findViewById(R.id.imageButton24);
		Y=(ImageButton)findViewById(R.id.imageButton25);
		Z=(ImageButton)findViewById(R.id.imageButton26);

	}


	public void onClick(View arg) {
		// TODO Auto-generated method stub
		String enteringclass = null;
		int currentapiversion=android.os.Build.VERSION.SDK_INT;
		if(currentapiversion>=android.os.Build.VERSION_CODES.HONEYCOMB_MR1)
			//displaying word is for
			enteringclass="pic.words.RootWordsDisplaying";
		else
			enteringclass="pic.words.RootAzentering";

		switch(arg.getId())
		{
			case R.id.imageButton1:
				b.putString("hello","A");
				i=new Intent();
				i.setClassName("pic.words",enteringclass);
				//i=new Intent(this,DisplayingWord.class);
				i.putExtras(b);
				startActivity(i);
				break;



			case R.id.imageButton2:
				s="B";
				b.putString("hello",s);
				i=new Intent();
				i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton3:   	s="C";
				b.putString("hello",s);
				i=new Intent();
				i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;



			case R.id.imageButton4:   	s="D";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton5:   	s="E";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton6:   	s="F";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton7:   	s="G";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton8:   	s="H";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton9:   	s="I";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton10:   	s="J";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton11:   	s="K";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton12:   	s="L";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton13:   	s="M";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton14:   	s="N";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton15:   	s="O";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton16:   	s="P";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;

			case R.id.imageButton17:   	s="Q";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton18:   	s="R";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;



			case R.id.imageButton19:   	s="S";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;



			case R.id.imageButton20:   	s="T";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton21:   	s="U";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton22:   	s="V";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton23:Toast.makeText(getApplicationContext(), "sorry no words in W",Toast.LENGTH_LONG).show();
		/*s="W";
	b.putString("hello",s);
	i=new Intent();i.setClassName("pic.words",enteringclass);
	i.putExtras(b);
	startActivity(i);*/
				break;



			case R.id.imageButton24:   	s="X";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;


			case R.id.imageButton25:Toast.makeText(getApplicationContext(), "sorry no words in Y",Toast.LENGTH_LONG).show();
		/* 	s="Y";
	b.putString("hello",s);
	i=new Intent();i.setClassName("pic.words",enteringclass);
	i.putExtras(b);
	startActivity(i);*/
				break;


			case R.id.imageButton26:   	s="Z";
				b.putString("hello",s);
				i=new Intent();i.setClassName("pic.words",enteringclass);
				i.putExtras(b);
				startActivity(i);
				break;





		}




	}

}
