package com.example.chleh.test2;
import android.graphics.drawable.Drawable;
public class Java_Main_List_Item {

    Drawable image_Sales;
    Drawable image_Person;
    String [] String_Array;
    boolean boolean_ad;
    String filename_Sales;
    String filename_Person;

    public Java_Main_List_Item(Drawable Image, String main_text,boolean ad)
    {
        boolean_ad=ad;
        if(!ad)
        {
            this.image_Sales=Image;
            String_Array = new String [3];
            String_Array[0]=main_text;
        }
        else {
            this.image_Person = Image;
            String_Array = new String[3];
            String_Array[0] = main_text;
        }
    }

    public Java_Main_List_Item(String filename, String main_text,boolean ad)
    {
        boolean_ad=ad;
        filename_Person="bee.jpg";
        filename_Sales="bee.jpg";
        if(!ad)
        {
            this.filename_Sales=filename;
            String_Array = new String [3];
            String_Array[0]=main_text;
        }
        else {
            this.filename_Person = filename;
            String_Array = new String[3];
            String_Array[0] = main_text;
        }
    }




    public String[] func_Get_String_Array()
    {
        return String_Array;
    }
    public String func_Get_String(int index)
    {
        if(String_Array== null || index >= String_Array.length)
        {
            return null;
        }
        return String_Array[index];
    }
    public Drawable func_Get_Sales_Image()
    {
        return image_Sales;
    }
    public Drawable func_Get_Person_Image()
    {
        return image_Person;
    }
    public String func_Get_Sales_Filename(){return filename_Sales;};
    public String func_Get_Person_Filename(){return filename_Person;}


}