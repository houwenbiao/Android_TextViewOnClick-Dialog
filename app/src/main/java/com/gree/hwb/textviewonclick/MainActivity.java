package com.gree.hwb.textviewonclick;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

	TextView tv_testMode,tv_cool,tv_heat,tv_fan,tv_chushi;
	ImageView iv_onOff;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_testMode = (TextView) findViewById(R.id.tv_testMode);
		iv_onOff = (ImageView) findViewById(R.id.iv_onOff);
		tv_testMode.setClickable(true);
		iv_onOff.setClickable(true);
		tv_testMode.setOnClickListener(new MyOnClickListener());
		iv_onOff.setOnClickListener(new MyOnClickListener());
	}

	public void dialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setMessage("确认退出吗？");
		builder.setTitle("提示：");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialogInterface, int i)
			{
				dialogInterface.dismiss();
				MainActivity.this.finish();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialogInterface, int i)
			{
				dialogInterface.dismiss();
			}
		});
		builder.create().show();
	}

	@Override
	public void onBackPressed()
	{
		dialog();
	}

	class MyOnClickListener implements View.OnClickListener
	{

		@Override
		public void onClick(View view)
		{
			switch (view.getId())
			{
				case R.id.tv_testMode:
					Toast.makeText(MainActivity.this, "请选择模式：", Toast.LENGTH_LONG).show();
					showMode();
					break;
				case R.id.iv_onOff:
					if(iv_onOff.isSelected())
					{
						iv_onOff.setSelected(false);
						iv_onOff.setImageResource(R.drawable.switch_off);
						Toast.makeText(MainActivity.this, "开机", Toast.LENGTH_LONG).show();
					}
					else
					{
						iv_onOff.setSelected(true);
						iv_onOff.setImageResource(R.drawable.switch_on);
						Toast.makeText(MainActivity.this, "关机", Toast.LENGTH_LONG).show();
					}
					break;
				case R.id.model_cold:
					Toast.makeText(MainActivity.this,"制冷",Toast.LENGTH_LONG).show();
				break;
				case R.id.model_dry:
					Toast.makeText(MainActivity.this,"除湿",Toast.LENGTH_LONG).show();
					break;
				case R.id.model_fan:
					Toast.makeText(MainActivity.this,"送风",Toast.LENGTH_LONG).show();
					break;
				case R.id.model_heat:
					Toast.makeText(MainActivity.this,"制热",Toast.LENGTH_LONG).show();
					break;
				default:
					break;
			}
		}
	}

	public void showMode()
	{
		View view = View.inflate(MainActivity.this,R.layout.dialog_model,null);
		tv_chushi = (TextView) view.findViewById(R.id.model_dry);
		tv_cool = (TextView) view.findViewById(R.id.model_cold);
		tv_fan = (TextView) view.findViewById(R.id.model_fan);
		tv_heat = (TextView) view.findViewById(R.id.model_heat);

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		alertDialog.setTitle("请选择模式");
		alertDialog.setView(view);
		alertDialog.create().show();

		//下面的方式也可以
		/*Dialog dialog = new Dialog(MainActivity.this);
		dialog.show();
		dialog.setTitle("请选择模式：");
		dialog.getWindow().setContentView(view);*/

		tv_heat.setOnClickListener(new MyOnClickListener());
		tv_cool.setOnClickListener(new MyOnClickListener());
		tv_fan.setOnClickListener(new MyOnClickListener());
		tv_chushi.setOnClickListener(new MyOnClickListener());
	}

}
