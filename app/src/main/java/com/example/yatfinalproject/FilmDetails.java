package com.example.yatfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FilmDetails extends AppCompatActivity {

    String filmName,filmUrl;
    String filmBio;
    TextView filmN,filmDesc;
    ImageView filmImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);

        filmBio=getIntent().getExtras().getString("filmBio");
        filmName=getIntent().getExtras().getString("filmName");
        filmUrl=getIntent().getExtras().getString("filmUrl");

        filmN=findViewById(R.id.film_details_name);
        filmDesc=findViewById(R.id.film_details_describtion);
        filmImg=findViewById(R.id.film_details_img);

        Picasso.get().load(filmUrl).into(filmImg);
        filmN.setText(filmName);

        filmDesc.setText(filmBio);




    }

}