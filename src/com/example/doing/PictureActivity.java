package com.example.doing;

import com.example.doing.imagemodel.AppData;
import com.example.doing.imagemodel.PictureManager;
import com.example.doing.imagewedgit.CoverFlowGallery;
import com.example.doing.imagewedgit.CoverFlowImageAdapter;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * メイン画面を表します。
 */
public class PictureActivity extends Activity implements OnItemClickListener, OnItemSelectedListener
{
	
	//画像を表示するための Activity の識別子
	private static final int PICTURE_ACTIVITY = 100;

	//ギャラリー	 
	private CoverFlowGallery mCoverFlowGallery;

	//画像情報を管理するインスタンス	 
	private PictureManager mPictureManager;

	//選択されている画像のタイトル	 
	private TextView mTitleTextView;

	//選択されている画像のインデックス	 
	private TextView mIndexTextView;

	//init時に実行
	private void initControls()
	{
		/*
		this.mCoverFlowGallery = ( CoverFlowGallery )this.findViewById( R.id.content_list );
		this.mCoverFlowGallery.setAdapter( new CoverFlowImageAdapter( this.getApplicationContext(), this.mPictureManager.getThumbnailIds(), 200, 200, false, true ) );
		this.mCoverFlowGallery.setSpacing( -25 );
		this.mCoverFlowGallery.setSelection( this.mPictureManager.getCurrentIndex(), true );
		this.mCoverFlowGallery.setAnimationDuration( 1000 );
		this.mCoverFlowGallery.setOnItemClickListener( this );
		this.mCoverFlowGallery.setOnItemSelectedListener( this );

		this.mIndexTextView = ( TextView )this.findViewById( R.id.content_index );
		this.mTitleTextView = ( TextView )this.findViewById( R.id.content_title );
		( ( TextView )this.findViewById( R.id.content_count ) ).setText( String.format( "/%d", this.mPictureManager.getCount() ) );

		this.updateSelectionInfo();
		*/
	}
	
	/**
	 * 遷移先の Activity が終了した時に発生
	 *
	 * @param requestCode 遷移先 Activity の識別情報。
	 * @param resultCode  遷移先 Activity の実行結果を示す値。
	 * @param data        遷移先 Activity が設定した Intent インスタンス。
	 */
	@Override
	protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
		if( requestCode == PICTURE_ACTIVITY ) {
			this.mCoverFlowGallery.setSelection( this.mPictureManager.getCurrentIndex(), true );
			this.updateSelectionInfo();
		}
	}
	/**
	 * 画面が生成される時に発生
	 *
	 * @param savedInstanceState 保存されたインスタンスの状態。
	 */
	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		this.setContentView( R.layout.picture );

		this.mPictureManager = ((AppData)this.getApplication() ).getPicture();
		this.initControls();
	}
	

	/**
	 * リスト上のアイテムがクリックされた時に発生
	 *
	 * @param parent   リストに関連付けられている Adapter。
	 * @param view     操作対象の View。
	 * @param position 操作対象となったアイテムのインデックス。
	 * @param id       操作対象となったアイテムの識別子。
	 */
	public void onItemClick( AdapterView< ? > parent, View view, int position, long id ) {
		Intent intent = new Intent();
		intent.setClass( this, PictureActivity.class );
		this.startActivityForResult( intent, PICTURE_ACTIVITY );
	}

	/**
	 * リストにおけるアイテムの選択状態が変更された時に発生
	 *
	 * @param parent   リストに関連付けられている Adapter。
	 * @param view     操作対象の View。
	 * @param position 操作対象となったアイテムのインデックス。
	 * @param id       操作対象となったアイテムの識別子。
	 */
	public void onItemSelected( AdapterView< ? > parent, View view, int position, long id ) {
		this.mPictureManager.select( position );
		this.updateSelectionInfo();
	}

	/**
	 * リスト上で選択されたアイテムがなくなった時に発生
	 *
	 * @param parent リストに関連付けられている Adapter。
	 */
	public void onNothingSelected( AdapterView< ? > parent ) {
		// 何もしない
	}

	/**
	 * 選択されたコンテンツの情報を更新
	 */
	private void updateSelectionInfo() {
		this.mIndexTextView.setText( String.valueOf( this.mPictureManager.getCurrentIndex() + 1 ) );
		this.mTitleTextView.setText( this.mPictureManager.getPicture().getTitle()                 );
	}
}