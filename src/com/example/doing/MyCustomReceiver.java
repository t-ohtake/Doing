package com.example.doing;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// カスタムレシーバを作成して、受信時の設定を行う
public class MyCustomReceiver extends BroadcastReceiver {
    private static final String TAG = "MyCustomReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
              String action = intent.getAction();
              String channel = intent.getExtras().getString("com.nifty.Channel");
              JSONObject json = new JSONObject(intent.getExtras().getString("com.nifty.Data"));
         
              Iterator itr = json.keys();
              while (itr.hasNext()) {
                String key = (String) itr.next();
                Log.d("a", key);
              }
            } catch (JSONException e) {
              // エラー処理
            }
    }
}