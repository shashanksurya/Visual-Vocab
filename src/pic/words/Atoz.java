	package pic.words;

	import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.ImageButton;

	public class Atoz extends Activity implements OnClickListener{

		ImageButton A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,r,S,T,U,V,W,X,Y,Z;
		Bundle b = new Bundle();


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
			String enteringclass = null;
			int currentapiversion=android.os.Build.VERSION.SDK_INT;
			if(currentapiversion>=android.os.Build.VERSION_CODES.HONEYCOMB_MR1)
				enteringclass="pic.words.DisplayingWord";
			else
				enteringclass="pic.words.Azentering";
			Intent i = new Intent();
			switch(arg.getId())
			{
				case R.id.imageButton1:
					b.putString("hello","A");
					i.setClassName("pic.words",enteringclass);
					//i=new Intent(this,DisplayingWord.class);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton2:
					b.putString("hello","B");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton3:
					b.putString("hello","C");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton4:
					b.putString("hello","D");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton5:
					b.putString("hello","E");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton6:
					b.putString("hello","F");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton7:
					b.putString("hello","G");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton8:
					b.putString("hello","H");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton9:
					b.putString("hello","I");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton10:
					b.putString("hello","J");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton11:  "K"
					b.putString("hello",s);
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton12:
					b.putString("hello","L");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton13:
					b.putString("hello","M");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton14:
					b.putString("hello","N");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton15:
					b.putString("hello","O");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton16:
					b.putString("hello","P");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton17:
					b.putString("hello","Q");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton18:
					b.putString("hello","R");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton19:  ;
					b.putString("hello","S");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton20:
					b.putString("hello","T");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton21:
					b.putString("hello","U");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton22:
					b.putString("hello","V");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;
				case R.id.imageButton23:
					b.putString("hello","W");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton24:
					b.putString("hello","X");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton25:
					b.putString("hello","Y");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

				case R.id.imageButton26:
					b.putString("hello","Z");
					i.setClassName("pic.words",enteringclass);
					i.putExtras(b);
					startActivity(i);
					break;

			}
		}
	}
