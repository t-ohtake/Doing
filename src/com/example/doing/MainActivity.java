package com.example.doing;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
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
	 *　フッターのアイコンを表示したり、消したり 
	 */
	public void iconEraser()
	{
		//リニアレイアウト（フッターのレイアウト郡)
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
		
		//ホームアイコンが表示されていたら非表示にする、非表示ならすべてのアイコンを表示する
		if (linearLayout.getVisibility() == 0)
		{
			linearLayout.setVisibility(View.INVISIBLE);
			linearLayout.setVisibility(View.GONE);
			System.out.println("フッターアイコンを非表示");
		}
		else
		{
			linearLayout.setVisibility(View.VISIBLE);
			System.out.println("フッターアイコンを表示");
		}
	}

}
