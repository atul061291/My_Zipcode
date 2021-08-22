package com.e.myzipcoe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static String BASEURL = "http://edflow.cladev.com/";
    public static final String token="100f8bcd4626d373cade4e832633b5f7";


    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;


    //following lines 16,17,19,20,21,22,24,25,31 are used for showing datas with api in logcat by  D/OkHttp
    private OkHttpClient.Builder builder=new OkHttpClient.Builder();
    private HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();

    public RetrofitClient(){
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();



        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(builder.build())    //this line show data in logcat by OkHttp
                .build();
    }

    //Checking for singltan class

    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient=new RetrofitClient();
        }
        return retrofitClient;
    }
    public Api getApi(){
        return retrofit.create(Api.class);
    }
}



