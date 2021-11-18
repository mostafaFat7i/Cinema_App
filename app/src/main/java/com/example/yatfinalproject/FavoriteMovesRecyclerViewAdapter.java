package com.example.yatfinalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteMovesRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteMovesRecyclerViewAdapter.FavoriteMoveViewHolder> {

    List<MoveModel> favorInfoList;

    public FavoriteMovesRecyclerViewAdapter(List<MoveModel> favorInfoList) {
        this.favorInfoList = favorInfoList;
    }
    @NonNull
    @Override
    public FavoriteMoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.move_list_item,parent,false);
        return new FavoriteMoveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMoveViewHolder holder, int position) {
        holder.moveName.setText(favorInfoList.get(position).getName());
        Picasso.get().load(favorInfoList.get(position).getImageurl()).into(holder.moveImage);
    }

    @Override
    public int getItemCount() {
        return favorInfoList.size();
    }

    static class FavoriteMoveViewHolder extends RecyclerView.ViewHolder  {
        TextView moveName;
        ImageView moveImage,favorItem;
        public FavoriteMoveViewHolder(@NonNull View itemView) {
            super(itemView);
            moveName = itemView.findViewById(R.id.move_name);
            moveImage=itemView.findViewById(R.id.move_image);
            favorItem=itemView.findViewById(R.id.love_item);
            favorItem.setImageResource(R.drawable.block_favorite);

        }

    }
}
