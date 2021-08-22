package com.e.myzipcoe;

import com.e.myzipcoe.modelclass.ModelClassZIp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @Headers({"token:100f8bcd4626d373cade4e832633b5f7","source:ANDROID"})
    @FormUrlEncoded
    @POST("api/users/zipcodes/")
    Call<ModelClassZIp> update_password(
            @Field("token") String token
    );

}
