package com.zhangzhixuan.mytext;

import androidx.appcompat.app.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch mSwitch;
    private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","hello!");
        mSwitch = (Switch) findViewById(R.id.switch1);
        mText = (TextView) findViewById(R.id.tv1);
        // 添加监听
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mText.setText("地狱！！！");
                    Log.d("MainActivity","welcome to diyu");
                }else {
                    mText.setText("天堂！！！");
                    Log.d("MainActivity","welcome to tiantang");
                }
            }
        });
    }
    // myClick为xml中指定的方法名，参数是View类型
    public void myClick(View view) {
        Toast.makeText(this,"恭喜你！",Toast.LENGTH_LONG).show();
        Log.d("MainActivity","wonderful!!");
    }
}
