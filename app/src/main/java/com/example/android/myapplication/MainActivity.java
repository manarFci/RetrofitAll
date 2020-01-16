package com.example.android.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<Object,Object> map=new HashMap<>();
        map.put("title","Manar Samir gamal");
        map.put("body","this is Post method with data not related");
        map.put("userId",7);

        //this is for Post Method lw 7gat mmkn agbha mn class wa7ed
        Post post = new Post(5, "CodeWithNerds", "this is my first Post");

        TextView post_title = findViewById(R.id.post_title);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

      /*  //this is for Get
        Call<List<Post>> call=apiInterface.getPost("1");
       call.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               post_title.setText(response.body().get(0).getTitle());
           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {
               post_title.setText(t.getMessage());

           }
       });
*/
        Call<Post> call = apiInterface.storePost(map);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                post_title.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                post_title.setText(t.getMessage());
            }
        });

    }
}
