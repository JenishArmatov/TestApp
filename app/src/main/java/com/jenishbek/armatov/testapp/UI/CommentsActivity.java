package com.jenishbek.armatov.testapp.UI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.jenishbek.armatov.testapp.R;

import java.util.ArrayList;
import java.util.List;

import adapters.CommentRecycleViewAdapter;
import adapters.PostRecyclerViewAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dto.CommentsDTO;
import interfaces.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CommentRecycleViewAdapter adapter;

    private ArrayList<CommentsDTO> data;

    private String content = "";

    static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    static String COMMENT_URL = "comments?postId=";
    static String CODE = "code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initToolbar();
        initComment();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.comment_toolbar);
        toolbar.setTitle(R.string.activity_comments_label);
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                showDialog();
                return true;
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_layout, null);
        EditText inputName = view.findViewById(R.id.edit_text_name);
        EditText inputEmail = view.findViewById(R.id.edit_text_email);
        EditText inputComment = view.findViewById(R.id.edit_text_comment);
        builder.setView(view);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                CommentsDTO dto = new CommentsDTO();
                dto.setPostId(data.get(data.size()-1).getPostId());
                dto.setId(data.get(data.size()-1).getId() + 1);
                dto.setName(String.valueOf(inputName.getText()));
                dto.setEmail(String.valueOf(inputEmail.getText()));
                dto.setComment(String.valueOf(inputComment.getText()));

                data.add(dto);
                adapter.notifyDataSetChanged();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    private void initComment() {
        data = new ArrayList<>();

        int posicion = PostRecyclerViewAdapter.posicion + 1;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<CommentsDTO>> call = jsonPlaceHolderApi.getComment(COMMENT_URL + posicion);
        call.enqueue(new Callback<List<CommentsDTO>>() {
            @Override
            public void onResponse(Call<List<CommentsDTO>> call, Response<List<CommentsDTO>> response) {
                if(!response.isSuccessful()){
                    content = CODE + response.code();
                    CommentsDTO commentsDTO = new CommentsDTO();
                    commentsDTO.setComment(content);
                    data.add(commentsDTO);
                    return;
                }
                data = (ArrayList<CommentsDTO>) response.body();
                recyclerView = findViewById(R.id.recycleView_comments);
                adapter = new CommentRecycleViewAdapter(CommentsActivity.this, data);
                LinearLayoutManager llm = new LinearLayoutManager(CommentsActivity.this.getApplicationContext());
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CommentsDTO>> call, Throwable t) {

            }


        });
    }
}
