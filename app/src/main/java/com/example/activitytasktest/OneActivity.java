package com.example.activitytasktest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {

  //constants
  private static final String TAG="OneActivity";
  //ui
  private TextView tvTitle;
  private Button btnOne;
  private Button btnTwo;
  private Button btnThree;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_common);

    initViews();
  }

  @Override protected void onResume() {
    super.onResume();
    Log.i(TAG,"onResume");
    ActivityTaskUtil.showTaskInfo(this);//输出任务栈的log
  }

  private void initViews() {
    tvTitle = findViewById(R.id.tv_title);
    btnOne = findViewById(R.id.btn_one);
    btnTwo = findViewById(R.id.btn_two);
    btnThree = findViewById(R.id.btn_three);

    tvTitle.setText(R.string.one_activity);
    btnOne.setOnClickListener(this);
    btnTwo.setOnClickListener(this);
    btnThree.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.btn_one) {
      OneActivity.startActivity(this);
    } else if (id == R.id.btn_two) {
      TwoActivity.startActivity(this);
    } else if (id == R.id.btn_three) {
      ThreeActivity.startActivity(this);
    }
  }

  public static void startActivity(Context context) {
    Intent intent = new Intent(context, OneActivity.class);
    context.startActivity(intent);
  }
}