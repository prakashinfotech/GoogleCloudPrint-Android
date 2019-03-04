package com.psspl.restapi;


import com.psspl.model.SearchPrinterEntity;
import com.psspl.model.SubmitJobEntity;
import com.psspl.model.TokenResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by
 * Haresh on 9/4/2017.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("oauth2/v4/token")
    Call<TokenResponse> getGenerateToken(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("grant_type") String qrantType, @Field("code") String Code);


    @GET("cloudprint/search")
    Call<SearchPrinterEntity> getSearchPrinter();

    @Multipart
    @POST("cloudprint/submit")
    Call<SubmitJobEntity> getSubmitJob(@Part("printerid") RequestBody printerid,
                                       @Part MultipartBody.Part file,
                                       @Part("title") RequestBody title,
                                       @Part("contentType") RequestBody contentType);
   // @Part("ticket") RequestBody ticket,
   }
