package com.xqs.ndkdemo.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Yat3s on 16/04/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public interface APIService {

    @FormUrlEncoded
    @POST("/auth/register/smsverifycode")
    Observable<String> test(@Field("name") String name,@Field("sex") String sex);
}
