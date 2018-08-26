package com.example.chleh.test2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.module.AppGlideModule;

public class View_Main_Item extends LinearLayout {

    ImageView image_Main;
    TextView text_Main;

    public View_Main_Item(Context context, Java_Main_List_Item aItem) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_main_item, this, true);
        image_Main = (ImageView) findViewById(R.id.imageitem);
        //image_Main.setImageDrawable(aItem.func_Get_Sales_Image());//이미지 세팅
        func_Set_Main_Image(aItem.func_Get_Sales_Image());
        text_Main = (TextView) findViewById(R.id.textitem);
        text_Main.setText(aItem.func_Get_String(0));//문구 세팅
    }

    public void func_Set_Main_Text(int index,String data) throws IllegalAccessException {
        if(index==0) {
            text_Main.setText(data);
        }
        else {
            throw new IllegalAccessException();
        }
    }
    public void func_Set_Main_Image(Drawable icon) {
       // image_Main.setImageDrawable(icon);
        FirebaseStorage fs = FirebaseStorage.getInstance();

        StorageReference imagesRef = fs.getReference().child("user_store/Trustone_store/sales_Picture/dolpin.jpg");
        GlideApp.with(this)
                .load(imagesRef)
                .centerCrop()
                .into(image_Main);
    }



}