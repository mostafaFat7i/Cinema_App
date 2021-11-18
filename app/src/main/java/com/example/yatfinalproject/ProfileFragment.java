package com.example.yatfinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView numOfFavorItem;
    MoveDao dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.profile_fragment,container,false);
        numOfFavorItem=view.findViewById(R.id.favotite_items_value);
        AppDatabase appDatabase=AppDatabase.getInstance(getContext());
        dao = appDatabase.moveDao();

        numOfFavorItem.setText(String.valueOf(dao.getAll().size()));


        return view;
    }
}
