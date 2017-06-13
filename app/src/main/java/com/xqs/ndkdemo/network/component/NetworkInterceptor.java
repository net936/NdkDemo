package com.xqs.ndkdemo.network.component;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Yat3s on 16/04/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class NetworkInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Log.w("post","post-->"+request.body());

        if (request.body() instanceof FormBody) {
            FormBody body = (FormBody) request.body();
            for (int i = 0; i < body.size(); i++) {
                Log.w("post","post-->"+ body.name(i) + "=" +body.value(i));
               Log.w("post","post-->"+body.encodedName(i) + "=" + body.encodedValue(i));
            }
        }

        // TODO: 16/04/2017 Optional.
        return chain.proceed(request);
    }
}
