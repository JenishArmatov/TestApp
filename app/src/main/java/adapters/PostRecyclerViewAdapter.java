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
import dto.PostDTO;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<PostDTO> postsArray;
    public static int posicion;
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView postId;
        TextView id;
        TextView tittle;
        TextView text;
        LinearLayout layout;


        public ViewHolder(View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.tv_post_userId);
            id = itemView.findViewById(R.id.tv_post_id);
            tittle = itemView.findViewById(R.id.tv_post_tittle);
            text = itemView.findViewById(R.id.tv_post_text);
            layout = itemView.findViewById(R.id.post_layout);
        }
    }


    public PostRecyclerViewAdapter(Context c, ArrayList<PostDTO> arrayList){
        this.context = c;
        this.postsArray = arrayList;
    }
    @Override
    public int getItemCount() {
        return 30;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.postId.setText(context.getResources().getString(R.string.user_id) +
                postsArray.get(position).getUserId());
        holder.id.setText(context.getResources().getString(R.string.id) +
                postsArray.get(position).getId());
        holder.tittle.setText(context.getResources().getString(R.string.tittle) +
                postsArray.get(position).getTitle());
        holder.text.setText(context.getResources().getString(R.string.body) +
                postsArray.get(position).getText());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostRecyclerViewAdapter.posicion = holder.getAdapterPosition();
                context.startActivity(new Intent(context, CommentsActivity.class));

            }
        });

    }




}

