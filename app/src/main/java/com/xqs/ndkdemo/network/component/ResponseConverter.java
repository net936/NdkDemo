package com.xqs.ndkdemo.network.component;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Yat3s on 16/04/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class ResponseConverter<T> implements Converter<ResponseBody, T> {
    private static final String TAG = "ResponseConverter";

    private final Gson mGson;
    private final Type mType;

    public ResponseConverter(Gson gson, Type type) {
        mGson = gson;
        mType = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String responseString = value.string();
        Log.d(TAG, "okhttp: " + responseString);
//        JSONObject responseJSON  = new JSONObject( responseString);
//        int code = responseJSON.getInt("code");
//        if (code == 1) {
//            return convertResponseToEntity(responseString);
//        } else {
//            throw new IOException("Response is error");
//        }
        return convertResponseToEntity(responseString);
    }

    public T convertResponseToEntity(String response) {
        TypeToken typeToken = TypeToken.get(mType);
        if (typeToken.getRawType() == String.class || TextUtils.isEmpty(response)) {
            return (T) response;
        } else {
            return mGson.fromJson(response, mType);
        }
    }
}
