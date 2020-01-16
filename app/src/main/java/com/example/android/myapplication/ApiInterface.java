package com.example.android.myapplication;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts")

    public Call<List<Post>> getPost(@Query("userId") String userId);

   @POST("posts")
//deh lw Post bgyb 7gat mn nfs class w related ya3ny
   // public Call<Post> storePost(@Body Post post);
    public Call<Post> storePost(@Body HashMap<Object,Object> map);


}
