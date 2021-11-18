package com.example.yatfinalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteFragment extends Fragment {

    RecyclerView favorMoveRecyclerView;
    TextView isempty;
    MoveDao dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.favorite_fragment,container,false);

        favorMoveRecyclerView=view.findViewById(R.id.favo_list);
        isempty=view.findViewById(R.id.empty);

        AppDatabase appDatabase=AppDatabase.getInstance(getContext());
            dao = appDatabase.moveDao();
            List<MoveModel> list=dao.getAll();
            if (list.isEmpty()){
                favorMoveRecyclerView.setVisibility(View.GONE);
                isempty.setVisibility(View.VISIBLE);
            }
            else {
                setAdapter(list);
            }

        return view;
    }

    private void setAdapter(List<MoveModel> list){
        FavoriteMovesRecyclerViewAdapter adapter=new FavoriteMovesRecyclerViewAdapter(list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        favorMoveRecyclerView.setLayoutManager(layoutManager);
        favorMoveRecyclerView.setAdapter(adapter);

    }
}
