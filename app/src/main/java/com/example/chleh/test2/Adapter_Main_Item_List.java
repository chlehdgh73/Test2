package com.example.chleh.test2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class Adapter_Main_Item_List extends BaseAdapter {

    Context mContext;
    ArrayList<Java_Main_List_Item> mItems = new ArrayList<Java_Main_List_Item>();
    public Adapter_Main_Item_List(Context context)
    {
        mContext=context;
    }

    public void func_Add_Item(Java_Main_List_Item item)
    {
        mItems.add(item);
    }
    public  int getCount()
    {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(final int position, final View convertView, ViewGroup parent){
        View_Main_Item dataView=null;



        if(convertView == null){
            try {
                dataView = new View_Main_Item(mContext,mItems.get(position));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }else{
            dataView = (View_Main_Item) convertView;
            //dataView.func_Set_Main_Image(mItems.get(position).func_Get_Sales_Image());
            dataView.func_Set_Image(0,mItems.get(position).func_Get_Sales_Filename());
            dataView.func_Set_Image(1,mItems.get(position).func_Get_Sales_Filename());
            try {
                dataView.func_Set_Text(1,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(2,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(3,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(4,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(5,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(6,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(7,mItems.get(position).func_Get_String(0));
                dataView.func_Set_Text(8,mItems.get(position).func_Get_String(0));
                ImageView imageview_Sale= dataView.findViewById(R.id.imageview_Item);
                ImageView imageview_Person=dataView.findViewById(R.id.imageview_Person);


                final View_Main_Item finalDataView = dataView;//이벤트 리스터
                imageview_Person.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(finalDataView.getContext(), Act_Sales_Detail.class);//구체적 뷰
                    myIntent.putExtra("filename_Sale", mItems.get(position).func_Get_Sales_Filename()); //파일이름 전송!
                    mContext.startActivity(myIntent);
                }
            });

            imageview_Sale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(finalDataView.getContext(), Act_Sales_Detail.class);//구체적 뷰
                        myIntent.putExtra("filename_Sale", mItems.get(position).func_Get_Sales_Filename()); //파일이름 전송!
                        mContext.startActivity(myIntent);
                    }
                });



                } catch (IllegalAccessException e) {
                e.printStackTrace();
                }
         }
                return  dataView;
                }



    }
