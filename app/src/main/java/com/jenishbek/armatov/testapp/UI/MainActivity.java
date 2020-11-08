package com.jenishbek.armatov.testapp.UI;

import android.os.Bundle;

import com.jenishbek.armatov.testapp.R;

import java.util.ArrayList;
import java.util.List;

import adapters.PostRecyclerViewAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dto.PostDTO;
import interfaces.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostRecyclerViewAdapter adapter;
    private ArrayList<PostDTO> postDTOS;
    private String content = "";
    static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    static String CODE = "code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPosts();
    }

    private void initPosts() {
        postDTOS = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<PostDTO>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<PostDTO>>() {
            @Override
            public void onResponse(Call<List<PostDTO>> call, Response<List<PostDTO>> response) {
                if(!response.isSuccessful()){
                    content = CODE + response.code();
                    PostDTO postDTO = new PostDTO();
                    postDTO.setText(content);
                    postDTOS.add(postDTO);
                    return;
                }
                postDTOS = (ArrayList<PostDTO>) response.body();
                recyclerView = findViewById(R.id.recycleView_posts);
                adapter = new PostRecyclerViewAdapter(MainActivity.this, postDTOS);
                LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostDTO>> call, Throwable t) {

            }
        });
    }
}
