package com.example.doing;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//タイトルバー非表示
		setContentView(R.layout.activity_main);
		
		//ボタン情報を取得
		ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
		ImageButton hmBtn = (ImageButton)findViewById(R.id.hmBtn);
		ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
		ImageButton grBtn = (ImageButton)findViewById(R.id.grBtn);
		ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		
		//各ボタンが押された時
		ueBtn.setOnClickListener(this);
		hmBtn.setOnClickListener(this);
		runBtn.setOnClickListener(this);
		grBtn.setOnClickListener(this);
		stBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
			//矢印ボタンを押下
			case R.id.ueBtn:
				//フッター非表示、表示処理
				iconEraser();
		    break;
			case R.id.hmBtn:
				System.out.println("hmBtn");
			    break;
			case R.id.runBtn:
				System.out.println("runBtn");
			    break;
			case R.id.grBtn:
				System.out.println("grBtn");
			    break;
			case R.id.stBtn:
				System.out.println("stBtn");
			    break;
		}		
    }
	
	/**
	 *　フッターのアイコンを消す
	 */
	public void iconEraser()
	{
		//ボタン、リニアレイアウト（フッターのレイアウト郡)
		ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
		//非表示
		ueBtn.setVisibility(View.INVISIBLE);
		ueBtn.setVisibility(View.GONE);
		linearLayout.setVisibility(View.INVISIBLE);
		linearLayout.setVisibility(View.GONE);
		System.out.println("フッターアイコンを非表示");
	}

	/**
	 *　フッターのアイコンを表示する
	 */
	@Override
    public boolean onTouchEvent(MotionEvent event)
	{
        Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());
		
		//したらへん触ったら、ボタン、リニアレイアウトを表示
		if(event.getY() >= 760)
		{
			//ボタン、リニアレイアウト（フッターのレイアウト郡)
			ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
			LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
			ImageButton hmBtn = (ImageButton)findViewById(R.id.hmBtn);
			ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
			ImageButton grBtn = (ImageButton)findViewById(R.id.grBtn);
			ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		
			if (ueBtn.getVisibility() != View.VISIBLE)
			{   
		        //フェードインアニメーションの準備する(1,0)フェードアウト、(0,1)フェードイン
		        //フェードインするまでの時間。単位はmsec。
		        AlphaAnimation feedin_ueBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_hmBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_runBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_grBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_stBtn = new AlphaAnimation( 0, 1 );	      
		        feedin_ueBtn.setDuration( 150 );
		        feedin_hmBtn.setDuration( 150 );
		        feedin_runBtn.setDuration( 350 );
		        feedin_grBtn.setDuration( 550 );
		        feedin_stBtn.setDuration( 750 );

		        //フェードインアニメーションを適用する
		        ueBtn.startAnimation( feedin_ueBtn );
		        hmBtn.startAnimation( feedin_hmBtn );
		        runBtn.startAnimation( feedin_runBtn );
		        grBtn.startAnimation( feedin_grBtn );
		        stBtn.startAnimation( feedin_stBtn );
				
				//実物表示
				ueBtn.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
			}
		}

        return true;
    }
}
