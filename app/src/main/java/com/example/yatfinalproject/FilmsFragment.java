package com.example.yatfinalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmsFragment extends Fragment implements onFavoriteItemListner{

    RecyclerView moveList;
    Button addToFavorite;
    AppDatabase appDatabase;
    List<MoveModel> favorItems=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.films_fragment,container,false);

        moveList=view.findViewById(R.id.moves_list);
        addToFavorite=view.findViewById(R.id.add_to_database);
        appDatabase = AppDatabase.getInstance(getContext());
        Snackbar snackbar = Snackbar.make(container,"Added to favorite",Snackbar.LENGTH_SHORT);

            ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

            apiInterface.getMove().enqueue(new Callback<List<MoveModel>>() {
                @Override
                public void onResponse(Call<List<MoveModel>> call, Response<List<MoveModel>> response) {
                    if (response.isSuccessful()){
                        List<MoveModel> modelList=response.body();
                        setAdapter(modelList);
                    }
                    else {

                        Toast.makeText(getContext(), "response null", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<List<MoveModel>> call, Throwable t) {

                }
            });

            addToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i=0;i<=favorItems.size()-1;i++){
                        appDatabase.moveDao().insert(
                                new MoveModel(favorItems.get(i).getName(),favorItems.get(i).getImageurl(),favorItems.get(i).getIsfavor()));
                        snackbar.show();
                        Log.e("Tag","insert "+favorItems.get(i).getName()+" correct");
                    }

                }
            });

        return view;
    }

    private void setAdapter(List<MoveModel> list){
        MovesRecyclerViewAdapter adapter=new MovesRecyclerViewAdapter(this,list,getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        moveList.setLayoutManager(layoutManager);
        moveList.setAdapter(adapter);

    }


    @Override
    public void onFavoriteItemListner(String filmName, String filmImage, boolean isFavor) {
        MoveModel model=new MoveModel();
        if (isFavor){
            model.setName(filmName);
            model.setImageurl(filmImage);
            model.setIsfavor(isFavor);
            favorItems.add(model);
        }
    }
}
