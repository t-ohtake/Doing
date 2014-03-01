package com.example.doing;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import com.nifty.cloud.mb.*;
import android.app.AlertDialog;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity implements OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//タイトルバー非表示
		setContentView(R.layout.activity_main);
		
		
		
		/**
		 * プッシュ通知のサンプル===========================
		 */
		NCMB.initialize(this, "**************", "**************");
		
		NCMBQuery<NCMBObject> query = NCMBQuery.getQuery("TestClass");
        query.whereEqualTo("message", "Hello, Tarou!");
        query.findInBackground(new FindCallback<NCMBObject>() {
            @Override
            public void done(List<NCMBObject> result, NCMBException e){
                if (result.isEmpty() != true){
                    dispMessage(result.get(0));
                } else {
                    PostData();
                }
            }
        });
		
        final NCMBInstallation instllation = NCMBInstallation.getCurrentInstallation();
        instllation.getRegistrationIdInBackground("**************", new RegistrationCallback() {
            @Override
            public void done(NCMBException e) {
                if (e == null) {
                    // 成功
                    try {
                        instllation.save();
                    } catch (NCMBException le) {
                        // サーバ側への保存エラー
                    }
                } else {
                    // エラー
                }
            }
        });
		
		/**
		 *============================ ここまで
		 */
		
		//データベースヘルパーのインスタンスを作成する（まだデータベースはできない）  
		DbCtrlActivity dbCtrl = new DbCtrlActivity(this);  
        //データベースオブジェクトを取得する（データベースにアクセスすると作成される。）  
        SQLiteDatabase db = dbCtrl.getWritableDatabase();
        //インサートとセレクトのTEST
        dbCtrl.doAddEntry(db);
        
        //データベースを閉じる  
        db.close();
        
		//グラフのテスト
		//WebView web = (WebView) findViewById(R.id.webView1);
		//web.loadUrl("file:///android_asset/test.html");
		//web.getSettings().setBuiltInZoomControls(true);
		//web.setWebViewClient(new WebViewClient());
		//web.getSettings().setJavaScriptEnabled(true);
		
		
		
		//各ボタンが押された時
		ImageButton batsu = (ImageButton)findViewById(R.id.batsu);
		ImageButton hmBtn = (ImageButton)findViewById(R.id.pcBtn);
		ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
		ImageButton grBtn = (ImageButton)findViewById(R.id.bthBtn);
		ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		batsu.setOnClickListener(this);
		hmBtn.setOnClickListener(this);
		runBtn.setOnClickListener(this);
		grBtn.setOnClickListener(this);
		stBtn.setOnClickListener(this);
		
		
		/*
		ListView lv;
		String[] members = { "teststart", "test", "test", "test","test", "test", "testend" };
        lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, members);
        lv.setAdapter(adapter);
        */
	}
	
	
	/**
	 * プッシュ通知のサンプル===========================
	 */
	 private void PostData(){
	        NCMBObject TestClass = new NCMBObject("TestClass");
	        TestClass.put("message", "Hello, NCMB!");
	        TestClass.saveInBackground(); 
	    }
	    
	    private void dispMessage(NCMBObject message){
	        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	        
	        alertDialogBuilder.setTitle("データ取得");
	        alertDialogBuilder.setMessage(message.getString("message"));
	        alertDialogBuilder.show();
	    }
	
	    private void sendPush() throws JSONException {
	        NCMBPush push = new NCMBPush();
	        JSONObject data = new JSONObject("{\"action\": \"com.example.pushsample7.RECEIVE_PUSH\", \"title\": \"test title\", \"target\": [android]}");
	        push.setData(data);
	        push.setMessage("send push!");
	        push.setImmediateDeliveryFlag(true);
	        push.sendInBackground(new SendCallback() {
	            @Override
	            public void done(NCMBException e) {
	                if (e != null) {
	                    // エラー処理
	                } else {
	                    // プッシュ通知登録後の処理
	                }
	            }
	        });
	    }
	/**
	 *============================ ここまで
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.optionsmenu, menu);
		return true;
	}
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
			//矢印ボタンを押下
			case R.id.batsu:
				//フッター非表示、表示処理
				iconEraser();
		    break;
			case R.id.pcBtn:
				System.out.println("pcBtn");
				//ボタン押下時実行
				//executePicture();
			    break;
			case R.id.runBtn:
				System.out.println("runBtn");
			    break;
			case R.id.bthBtn:
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
		ImageButton batsu = (ImageButton)findViewById(R.id.batsu);
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
		
		//フェードアウトアニメーション準備、適用
		AlphaAnimation feedout = new AlphaAnimation( 1, 0 );
		feedout.setDuration( 150 );
		linearLayout.startAnimation( feedout );
		
		//非表示
		batsu.setVisibility(View.INVISIBLE);
		batsu.setVisibility(View.GONE);
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
			ImageButton batsu = (ImageButton)findViewById(R.id.batsu);
			LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
			ImageButton hmBtn = (ImageButton)findViewById(R.id.pcBtn);
			ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
			ImageButton grBtn = (ImageButton)findViewById(R.id.bthBtn);
			ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		
			if (batsu.getVisibility() != View.VISIBLE)
			{   
		        //フェードインアニメーションの準備する(1,0)フェードアウト、(0,1)フェードイン
		        //フェードインするまでの時間。単位はmsec。
		        AlphaAnimation feedin_batsu = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_hmBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_runBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_grBtn = new AlphaAnimation( 0, 1 );
		        AlphaAnimation feedin_stBtn = new AlphaAnimation( 0, 1 );	      
		        feedin_batsu.setDuration( 50 );
		        feedin_hmBtn.setDuration( 50 );
		        feedin_runBtn.setDuration( 250 );
		        feedin_grBtn.setDuration( 450 );
		        feedin_stBtn.setDuration( 650 );

		        //フェードインアニメーションを適用する
		        batsu.startAnimation( feedin_batsu );
		        hmBtn.startAnimation( feedin_hmBtn );
		        runBtn.startAnimation( feedin_runBtn );
		        grBtn.startAnimation( feedin_grBtn );
		        stBtn.startAnimation( feedin_stBtn );
				
				//実物表示
				batsu.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
			}
		}

        return true;
    }
	
	public void executePicture()
	{
		//画面遷移
		Intent intent = new Intent(MainActivity.this, PictureActivity.class);
        startActivity(intent);
	}
}
