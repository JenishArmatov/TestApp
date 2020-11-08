package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jenishbek.armatov.testapp.R;
import com.jenishbek.armatov.testapp.UI.CommentsActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dto.CommentsDTO;



public class CommentRecycleViewAdapter extends RecyclerView.Adapter<CommentRecycleViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<CommentsDTO> postsArray;
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView postId;
        TextView id;
        TextView name;
        TextView email;
        TextView comment;


        public ViewHolder(View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.tv_postId);
            id = itemView.findViewById(R.id.tv_comment_id);
            name = itemView.findViewById(R.id.tv_comment_name);
            email = itemView.findViewById(R.id.tv_comments_email);
            comment = itemView.findViewById(R.id.tv_comments);
        }
    }


    public CommentRecycleViewAdapter(Context c, ArrayList<CommentsDTO> arrayList){
        this.context = c;
        this.postsArray = arrayList;
    }
    @Override
    public int getItemCount() {
        return postsArray.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment_layout, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.postId.setText(context.getResources().getString(R.string.post_id) +
                postsArray.get(position).getPostId());
        holder.id.setText(context.getResources().getString(R.string.id) +
                postsArray.get(position).getId());
        holder.name.setText(context.getResources().getString(R.string.comment_name) +
                postsArray.get(position).getName());
        holder.email.setText(context.getResources().getString(R.string.email) +
                postsArray.get(position).getEmail());
        holder.comment.setText(context.getResources().getString(R.string.body) +
                postsArray.get(position).getComment());

    }




}

