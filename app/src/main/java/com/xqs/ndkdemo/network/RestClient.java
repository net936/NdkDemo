package com.xqs.ndkdemo.network;




import com.xqs.ndkdemo.network.component.NetworkInterceptor;
import com.xqs.ndkdemo.network.component.OMConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Yat3s on 16/04/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class RestClient {
    private static RestClient sRestClient;
    private static OkHttpClient sOkHttpClient;
    private APIService mAPIService;

    public static RestClient getInstance() {
        if (null == sRestClient) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            sOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)
                    .addInterceptor(new NetworkInterceptor())
                    .connectTimeout(3000, TimeUnit.SECONDS)
                    .build();

            sRestClient = new RestClient("http://www.baidu.com/");
        }

        return sRestClient;
    }


    public RestClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(OMConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(sOkHttpClient)
                .build();

        mAPIService = retrofit.create(APIService.class);
    }

    public APIService getAPIService() {
        return mAPIService;
    }
}
