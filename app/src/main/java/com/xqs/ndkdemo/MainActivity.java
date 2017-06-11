package com.xqs.ndkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    public TextView mNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNum = (TextView) findViewById(R.id.tv_num);

        int c = JniUtil.add(10,22);

        mNum.setText("c = "+c);
    }
}
