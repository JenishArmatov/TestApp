package interfaces;

import java.util.List;

import dto.CommentsDTO;
import dto.PostDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<PostDTO>> getPost();

    @GET()
    public Call<List<CommentsDTO>> getComment(@Url String url);
}
