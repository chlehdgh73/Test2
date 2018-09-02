package com.example.chleh.test2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.module.AppGlideModule;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class View_Main_Item extends LinearLayout {

    ImageView image_Main;
   // TextView text_Main;
    ImageView image_Person;
    TextView text_Storename;
    TextView text_Location;
    TextView text_Desc;
    TextView text_Lately;
    TextView text_Service;
    TextView text_Mob_Tel;
    TextView text_Tel;
    TextView text_Sale;

    public View_Main_Item(Context context, Java_Main_List_Item aItem) throws IllegalAccessException {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_main_item, this, true);

        image_Main = findViewById(R.id.imageview_Item);
        image_Person= findViewById(R.id.imageview_Person);
        text_Storename=findViewById(R.id.textview_Storename);
        text_Location=findViewById(R.id.textview_Location);
        text_Lately=findViewById(R.id.textview_Lately);
        text_Desc=findViewById(R.id.textview_Desc);
        text_Service=findViewById(R.id.textview_Service);
        text_Tel=findViewById(R.id.textview_Tel);
        text_Mob_Tel=findViewById(R.id.textview_Mob_Tel);
        text_Sale=findViewById(R.id.textview_Sale);
        //text_Main = (TextView) findViewById(R.id.textitem);





        image_Person.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            image_Person.setClipToOutline(true);
        }

        //image_Main.setImageDrawable(aItem.func_Get_Sales_Image());//이미지 세팅
        func_Set_Image(0,aItem.func_Get_Sales_Filename());
        func_Set_Image(1,aItem.func_Get_Sales_Filename());
        //func_Set_Text(0,aItem.func_Get_String(0));
        func_Set_Text(1,aItem.func_Get_String(0));
        func_Set_Text(2,aItem.func_Get_String(0));
        func_Set_Text(3,aItem.func_Get_String(0));
        func_Set_Text(4,aItem.func_Get_String(0));
        func_Set_Text(5,aItem.func_Get_String(0));
        func_Set_Text(6,aItem.func_Get_String(0));
        func_Set_Text(7,aItem.func_Get_String(0));
        func_Set_Text(8,aItem.func_Get_String(0));
       //text_Main.setText(aItem.func_Get_String(0));//문구 세팅

    }

    public void func_Set_Text(int index,String data) throws IllegalAccessException {
        if (index == 0) {//메인
            //text_Main.setText(data);
        }
        else if (index==1)
        {
            text_Storename.setText(data);
        }
        else if (index==2)
        {
            text_Service.setText(data);
        }
        else if (index==3)
        {
            text_Desc.setText(data);
        }
        else if (index==4)
        {
            text_Lately.setText(data);
        }
        else if (index==5)
        {
            text_Location.setText(data);
        }
        else if (index==6)
        {
            text_Tel.setText(data);
        }
        else if (index==7)
        {
            text_Mob_Tel.setText(data);
        }
        else if (index==8)
        {
            text_Sale.setText(data);
        }
        else {
            throw new IllegalAccessException();
        }
    }
/*    public void func_Set_Main_Image(Drawable icon) {
        image_Main.setImageDrawable(icon);
    }

*/




    public void func_Set_Image(int index,String filename) {
        //image_Main.setImageDrawable(icon);
        FirebaseStorage fs = FirebaseStorage.getInstance();
        if (index == 0) {
            StorageReference imagesRef1 = fs.getReference().child("user_store/Trustone_store/sales_Picture/" + filename);
            GlideApp.with(this)
                    .load(imagesRef1)
                    .centerCrop()
                    .skipMemoryCache(true)
                    .into(image_Main);
        }
        else if(index==1) {
            StorageReference imagesRef2 = fs.getReference().child("user_store/Trustone_store/sales_Picture/" + filename);

            GlideApp.with(this)
                    .load(imagesRef2).transform(new CircleCrop())//.transform(new MultiTransformation<Bitmap>( new CircleCrop(),new RoundedCornersTransformation(100,0)))
                    //.circleCrop()
                    //.fitCenter()
                    //.centerCrop()
                   // .centerInside()
                    .into(image_Person);
            //image_Person.setBackground(new ShapeDrawable(new OvalShape()));
            //image_Person.setClipToOutline(true);
            image_Person.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }

}