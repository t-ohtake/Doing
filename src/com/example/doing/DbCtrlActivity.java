package com.example.doing; 

import android.content.ContentValues;
import android.content.Context;  
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
  
  
public class DbCtrlActivity extends SQLiteOpenHelper
{
    /* データベース名 */  
    private final static String DB_NAME = "androidstudydb";  
    /* データベースのバージョン */  
    private final static int DB_VER = 1;  
   
    /* 
     * コンストラクタ 
      */  
    public DbCtrlActivity(Context context)
    {  
        super(context, DB_NAME, null, DB_VER);  
    }  
  
    /* 
     * onCreateメソッド 
     * データベースが作成された時に呼ばれます。 
     * テーブルの作成などを行います。 
     */  
    @Override  
    public void onCreate(SQLiteDatabase db)
    {  
    	StringBuffer sb = new StringBuffer();
    	sb.append("create table MyTable (");
    	sb.append(" No integer primary key autoincrement");
    	sb.append(",Name text not null");
    	sb.append(",Tel text");
    	sb.append(",Age integer");
    	sb.append(")");
    	sb.append("");
    	db.execSQL(sb.toString());
    }  
  
    /* 
     * onUpgradeメソッド 
     * onUpgrade()メソッドはデータベースをバージョンアップした時に呼ばれます。 
     * 現在のレコードを退避し、テーブルを再作成した後、退避したレコードを戻すなどの処理を行います。 
     */  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {  
    
    } 
    
    /** TEST TEST エントリ追加 */
    public void doAddEntry( SQLiteDatabase db )
    {
        // 挿入するデータはContentValuesに格納
        ContentValues val = new ContentValues();
        val.put( "No", "1" );
        val.put( "Name" , "2"  );
        val.put( "Tel" , "3"  );
        val.put( "Age" , "4"  );

        // “name_book_table”に1件追加
        db.insert( "MyTable", null, val );
        
        
        
        //select
        Cursor cursor = null;
        try{
            // name_book_tableからnameとageのセットを検索する
            // ageが指定の値であるものを検索
        	cursor = db.query( "MyTable",new String[]{ "name", "age" },null, null,null, null, null );

            // 検索結果をcursorから読み込んで返す
        }
        finally{

        }
        // まず、Cursorからnameカラムとageカラムを
        // 取り出すためのインデクス値を確認しておく
        int indexName = cursor.getColumnIndex( "Name" );
        int indexAge  = cursor.getColumnIndex( "Age"  );
        
     // ↓のようにすると、検索結果の件数分だけ繰り返される
        while( cursor.moveToNext() ){
            // 検索結果をCursorから取り出す
            String name = cursor.getString(indexName);
            String age  = cursor.getString(indexAge);
            System.out.println("=============================================================");
            System.out.println("name=" + name);
            System.out.println("age=" + age);
            System.out.println("=============================================================");
            
        }
    }
  
}