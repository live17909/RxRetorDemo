package com.drawtink.flux.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * <b>类名称：</b> RetrofitHelper <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 下午6:46<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public abstract class RetrofitHelper<T> {

    public Retrofit retrofit;

    public abstract Retrofit createRetrofit();

    public T getRetrofit(Class clazz) {
        if (createRetrofit() == null) {
            throw new NullPointerException("createRetrofit method can't return null !");
        }
        return (T) createRetrofit().create(clazz);
    }


    public OkHttpClient writeLogClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // add your other interceptors …
        // add logging as last interceptor
        return new OkHttpClient.Builder().addInterceptor(logging).build();
    }
}
