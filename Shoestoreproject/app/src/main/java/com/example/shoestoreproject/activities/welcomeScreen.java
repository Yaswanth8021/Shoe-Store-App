package com.example.shoestoreproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.shoestoreproject.R;

import java.util.ArrayList;
import java.util.List;

public class welcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //imageslider

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slide1,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide3, ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);
    }

    public void login(View view) {
        startActivity(new Intent(welcomeScreen.this, Login_user.class));
    }

    public void registration(View view) {
        startActivity(new Intent(welcomeScreen.this, registration.class));
    }





}
