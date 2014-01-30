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
		requestWindowFeature(Window.FEATURE_NO_TITLE);//�^�C�g���o�[��\��
		setContentView(R.layout.activity_main);
		
		//�{�^�������擾
		ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
		ImageButton hmBtn = (ImageButton)findViewById(R.id.hmBtn);
		ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
		ImageButton grBtn = (ImageButton)findViewById(R.id.grBtn);
		ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		
		//�e�{�^���������ꂽ��
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
			//���{�^��������
			case R.id.ueBtn:
				//�t�b�^�[��\���A�\������
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
	 *�@�t�b�^�[�̃A�C�R��������
	 */
	public void iconEraser()
	{
		//�{�^���A���j�A���C�A�E�g�i�t�b�^�[�̃��C�A�E�g�S)
		ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
		//��\��
		ueBtn.setVisibility(View.INVISIBLE);
		ueBtn.setVisibility(View.GONE);
		linearLayout.setVisibility(View.INVISIBLE);
		linearLayout.setVisibility(View.GONE);
		System.out.println("�t�b�^�[�A�C�R�����\��");
	}

	/**
	 *�@�t�b�^�[�̃A�C�R����\������
	 */
	@Override
    public boolean onTouchEvent(MotionEvent event)
	{
        Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());
		
		//������ւ�G������A�{�^���A���j�A���C�A�E�g��\��
		if(event.getY() >= 760)
		{
			//�{�^���A���j�A���C�A�E�g�i�t�b�^�[�̃��C�A�E�g�S)
			ImageButton ueBtn = (ImageButton)findViewById(R.id.ueBtn);
			LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
			ImageButton hmBtn = (ImageButton)findViewById(R.id.hmBtn);
			ImageButton runBtn = (ImageButton)findViewById(R.id.runBtn);
			ImageButton grBtn = (ImageButton)findViewById(R.id.grBtn);
			ImageButton stBtn = (ImageButton)findViewById(R.id.stBtn);
		
			if (ueBtn.getVisibility() != View.VISIBLE)
			{   
		        //�t�F�[�h�C���A�j���[�V�����̏�������(1,0)�t�F�[�h�A�E�g�A(0,1)�t�F�[�h�C��
		        //�t�F�[�h�C������܂ł̎��ԁB�P�ʂ�msec�B
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

		        //�t�F�[�h�C���A�j���[�V������K�p����
		        ueBtn.startAnimation( feedin_ueBtn );
		        hmBtn.startAnimation( feedin_hmBtn );
		        runBtn.startAnimation( feedin_runBtn );
		        grBtn.startAnimation( feedin_grBtn );
		        stBtn.startAnimation( feedin_stBtn );
				
				//�����\��
				ueBtn.setVisibility(View.VISIBLE);
				linearLayout.setVisibility(View.VISIBLE);
			}
		}

        return true;
    }
}
