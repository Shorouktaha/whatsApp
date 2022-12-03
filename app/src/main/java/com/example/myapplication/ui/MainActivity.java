package com.example.whatsapp.ui;
import static com.example.whatsapp.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.whatsapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
  private ViewPager viewPager;
  private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
         init();
        tabLayout.setupWithViewPager(viewPager);
        adapFrag adapter=new adapFrag(getSupportFragmentManager());
        adapter.addfragment(new chats(),"chat");
        adapter.addfragment(new status(),"status");
        adapter.addfragment(new calls(),"calls");
       viewPager.setAdapter(adapter);
    }
    private void init(){

       viewPager=findViewById(id.view);
       tabLayout=findViewById(id.tab);
     }



}