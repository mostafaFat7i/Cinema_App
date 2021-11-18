package com.example.yatfinalproject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovesRecyclerViewAdapter extends RecyclerView.Adapter<MovesRecyclerViewAdapter.MoveViewHolder>{

    List<MoveModel> infoList;
    onFavoriteItemListner listener;
    Context context;
    public MovesRecyclerViewAdapter(onFavoriteItemListner listener,List<MoveModel> infoList,Context context) {
        this.infoList = infoList;
        this.listener=listener;
        this.context=context;
    }

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.move_list_item,parent,false);
        return new MoveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoveViewHolder holder , int position) {
        holder.moveName.setText(infoList.get(position).getName());
        Picasso.get().load(infoList.get(position).getImageurl()).into(holder.moveImage);
        holder.favorItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (infoList.get(position).getIsfavor()==false){
                    infoList.get(position).setIsfavor(true);
                    holder.favorItem.setImageResource(R.drawable.block_favorite);
                }
                else {
                    infoList.get(position).setIsfavor(false);
                    holder.favorItem.setImageResource(R.drawable.favorite);
                }
                    listener.onFavoriteItemListner(infoList.get(position).getName(),infoList.get(position).getImageurl(),infoList.get(position).getIsfavor());

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,FilmDetails.class);
//                intent.putExtra("filmBio",infoList.get(position).getBio());
                intent.putExtra("filmName",infoList.get(position).getName());
                intent.putExtra("filmUrl",infoList.get(position).getImageurl());
                intent.putExtra("filmBio",infoList.get(position).getBio());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder  {
        TextView moveName;
        ImageView moveImage,favorItem;
        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            moveName = itemView.findViewById(R.id.move_name);
            moveImage=itemView.findViewById(R.id.move_image);
            favorItem=itemView.findViewById(R.id.love_item);

        }


    }
}
