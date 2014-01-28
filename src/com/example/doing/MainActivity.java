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
	 *�@�t�b�^�[�̃A�C�R����\��������A�������� 
	 */
	public void iconEraser()
	{
		//���j�A���C�A�E�g�i�t�b�^�[�̃��C�A�E�g�S)
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);
		
		//�z�[���A�C�R�����\������Ă������\���ɂ���A��\���Ȃ炷�ׂẴA�C�R����\������
		if (linearLayout.getVisibility() == 0)
		{
			linearLayout.setVisibility(View.INVISIBLE);
			linearLayout.setVisibility(View.GONE);
			System.out.println("�t�b�^�[�A�C�R�����\��");
		}
		else
		{
			linearLayout.setVisibility(View.VISIBLE);
			System.out.println("�t�b�^�[�A�C�R����\��");
		}
	}

}
