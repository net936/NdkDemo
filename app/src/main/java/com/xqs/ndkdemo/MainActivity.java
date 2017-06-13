package com.xqs.ndkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xqs.ndkdemo.network.RestClient;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    public TextView mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNum = (TextView) findViewById(R.id.tv_num);

        int c = JniUtil.add(10, 22);

        mNum.setText("c = " + c);

        String name = "liuliu";

        String sex = "[\"kkkk\",\"pppp\"]";


        RestClient.getInstance()
                .getAPIService()
                .test(name, sex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
