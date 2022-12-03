package com.example.whatsapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class adapFrag extends FragmentStatePagerAdapter {
    ArrayList<Fragment> fragmentsList=new ArrayList<>();
    ArrayList<String>titlelist=new ArrayList<>();

    public adapFrag(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void addfragment(Fragment fragment,String title){
        fragmentsList.add(fragment);
        titlelist.add(title);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}
