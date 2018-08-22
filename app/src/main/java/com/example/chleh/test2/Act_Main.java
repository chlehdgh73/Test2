package com.example.chleh.test2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Act_Main extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private FirebaseAuth mAuth;
    private boolean bool_Login=false;
    private TabLayout tabLayout_Main;
    private ViewPager viewPager_Main;
    private ImageView imageview_Login;
    private PageAdapter_Main_Tab pageAdapter_main_tab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_act__main);
        mAuth = FirebaseAuth.getInstance();                              //로그인 파이어베이스 용

        imageview_Login = findViewById(R.id.imageview_Login) ;          //레이아웃 매핑
        tabLayout_Main= findViewById(R.id.tab_Srch);
        viewPager_Main=findViewById(R.id.viewpager_Main_List);


        func_Set_Spinner_Adapter();
        func_Set_Tab_Adapter();

    }//onCreate






    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {

            String email = currentUser.getEmail();
            TextView mTextView = findViewById(R.id.textview_Main_Login);

            if(TextUtils.isEmpty(email)) {
                mTextView.setText(currentUser.getDisplayName() + "님");

            }
            else {
                mTextView.setText(currentUser.getEmail() + "님");

            }
            bool_Login = true;

        } else {
            bool_Login=false;
            TextView mTextView = findViewById(R.id.textview_Main_Login);
            mTextView.setText("로그인");
        }
    }//UpdateUI

    public void OnclickM(View view) {
        if(bool_Login ==false)
        {
            Intent intent = new Intent(Act_Main.this, Act_Login.class);
            startActivity(intent);
        }

        else{
            AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                    android.R.style.Theme_DeviceDefault_Light_Dialog);

            oDialog.setMessage("로그아웃 하시겠습니까?");
            oDialog.setTitle("일반 Dialog");
            oDialog.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            oDialog.setNeutralButton("예", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    mAuth.signOut();
                    //LoginManager.getInstance().logOut();

                    updateUI(null);
                }
            });
            oDialog.setCancelable(false);
            oDialog.show();

        }
    }


    //스피너 설정
    public void func_Set_Spinner_Adapter()
    {
        Spinner spinner_Main = findViewById(R.id.spinner_Main_Menu);
        ArrayAdapter spinner_Main_Adapter = ArrayAdapter.createFromResource(this, R.array.testing_spinner, android.R.layout.simple_dropdown_item_1line);
        spinner_Main_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Main.setAdapter(spinner_Main_Adapter);
    }


    public void func_Set_Tab_Adapter() //탭 프래그먼트 어댑터
    {

        pageAdapter_main_tab = new PageAdapter_Main_Tab(getSupportFragmentManager());
        pageAdapter_main_tab.addFragment(new Fragment_Main_First(),"first");
        pageAdapter_main_tab.addFragment(new Fragment_Main_First(),"second");
        pageAdapter_main_tab.addFragment(new Fragment_Main_First(),"third");
        pageAdapter_main_tab.addFragment(new Fragment_Main_First(),"fourth");
      /*  pagerAdapter.addFragment(new fragment2(),"second");
        pagerAdapter.addFragment(new fragment3(),"third");
        pagerAdapter.addFragment(new fragment4(),"forth");
        pagerAdapter.addFragment(new fragment5(),"fifth");
        pagerAdapter.addFragment(new fragment6(),"sixth");
        pagerAdapter.addFragment(new fragment7(),"seventh");*/
        viewPager_Main.setAdapter(pageAdapter_main_tab);
        tabLayout_Main.setupWithViewPager(viewPager_Main);

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


   //팝업설정
    public void func_Show_Area_Menu(View v){
        PopupMenu pop= new PopupMenu(this, v);
        pop.setOnMenuItemClickListener(this);
        pop.inflate(R.menu.menu_area);
        pop.show();
    }
    public void func_Show_Kind_Menu(View v){
        PopupMenu pop= new PopupMenu(this, v);
        pop.setOnMenuItemClickListener(this);
        pop.inflate(R.menu.menu_kind);
        pop.show();
    }
    public void func_Show_Latest_Menu(View v){
        PopupMenu pop= new PopupMenu(this, v);
        pop.setOnMenuItemClickListener(this);
        pop.inflate(R.menu.menu_latest);
        pop.show();
    }
}
