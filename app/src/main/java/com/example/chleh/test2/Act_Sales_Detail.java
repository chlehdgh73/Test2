package com.example.chleh.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Act_Sales_Detail extends AppCompatActivity {

    ImageView imageview_main;
    StorageReference imagesRef;
    String filename_Sale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__sales__detail);
        Intent myIntent= getIntent();
        filename_Sale=myIntent.getStringExtra("filename_Sale");
        imageview_main=findViewById(R.id.imageview_Detail_Main);
        FirebaseStorage fs = FirebaseStorage.getInstance();
        imagesRef = fs.getReference().child("user_store/Trustone_store/sales_Picture/" + filename_Sale);
        GlideApp.with(this)
                .load(imagesRef)
                .centerCrop()
                .skipMemoryCache(true)
                .into(imageview_main);




    }
}
