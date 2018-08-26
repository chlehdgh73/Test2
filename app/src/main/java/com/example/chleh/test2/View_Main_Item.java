package com.example.chleh.test2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
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
    ImageView image_Person;
    TextView text_Storename;
    TextView text_Location;
    TextView text_Desc;
    TextView text_Lately;
    TextView text_Service;

    public View_Main_Item(Context context, Java_Main_List_Item aItem) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_main_item, this, true);

        image_Main = (ImageView) findViewById(R.id.imageitem);
/*        image_Person= findViewById(R.id.imageview_Person);
        text_Storename=findViewById(R.id.textview_Storename);
        text_Location=findViewById(R.id.textview_Location);
        text_Lately=findViewById(R.id.textview_Lately);
        text_Desc=findViewById(R.id.textview_Desc);
        text_Service=findViewById(R.id.textview_Service);
        image_Person.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            image_Person.setClipToOutline(true);
        }
*/
        //image_Main.setImageDrawable(aItem.func_Get_Sales_Image());//이미지 세팅
        func_Set_Main_Image(aItem.func_Get_Sales_Filename());
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
        image_Main.setImageDrawable(icon);
    }






    public void func_Set_Main_Image(String filename) {
        //image_Main.setImageDrawable(icon);
        FirebaseStorage fs = FirebaseStorage.getInstance();
        StorageReference imagesRef = fs.getReference().child("user_store/Trustone_store/sales_Picture/"+filename);

        GlideApp.with(this)
                .load(imagesRef)
                .centerCrop()
               // .circleCrop() 동그랗게 ㅎㅎ

                .into(image_Main);
    }



}