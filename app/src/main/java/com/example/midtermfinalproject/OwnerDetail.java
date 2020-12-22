package com.example.midtermfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OwnerDetail extends AppCompatActivity {

    TextView nameOwner;
    TextView loginOwner;
    TextView fullnameOwner;
    TextView ownerOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_detail);

        nameOwner=findViewById(R.id.name);
        loginOwner=findViewById(R.id.login);
        fullnameOwner=findViewById(R.id.fullname);
        ownerOwner=findViewById(R.id.owner);



        Intent intent=getIntent();
        final String Name = intent.getStringExtra("ownerName");
        final String Login = intent.getStringExtra("ownerLogin");
        final String FullName = intent.getStringExtra("ownerFullName");
        final String Owner = intent.getStringExtra("Owner");


        nameOwner.setText(Name);
        loginOwner.setText(Login);
        fullnameOwner.setText(FullName);
        ownerOwner.setText(Owner);

    }


}