package com.example.aadteam52animationchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postViewHolder> {

    Context mContext;
    List<PostItem> mData;

    public PostAdapter(Context mContext, List<PostItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.post_item, parent, false);
        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(postViewHolder holder, int position) {
        holder.post_item.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition));

        holder.title.setText(mData.get(position).getTitle());
        holder.author.setText("Photo by " + mData.get(position).getAuthor());
        holder.photo.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class postViewHolder extends RecyclerView.ViewHolder {
        TextView title, mTitle;
        TextView author, mAuthor;
        ImageView photo, mPhoto;
        ConstraintLayout post_item, mPostItem;

        public postViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            photo = itemView.findViewById(R.id.post_bg);
            post_item = itemView.findViewById(R.id.post_item);
        }
    }
}
