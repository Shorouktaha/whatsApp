package com.example.whatsapp.ui;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsapp.R;
import com.example.whatsapp.model.chatmodel;

import java.util.ArrayList;
public class chats extends Fragment {


   RecyclerView recChat;
   chatAdapter chatadapter;
   ArrayList<chatmodel>chatData=new ArrayList<chatmodel>();

    public chats() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recChat=view.findViewById(R.id.chats_recycle);
        setRecyclChat();
    }
    private void setRecyclChat(){
        addFakeData();
      chatadapter =new chatAdapter(chatData);
      recChat.setAdapter(chatadapter);
      recChat.setLayoutManager(new LinearLayoutManager(
              getContext()

      ));
    }
    private void addFakeData(){

        chatData.add(new chatmodel("fatma",R.drawable.panda,"عايزة رينجروف"));
        chatData.add(new chatmodel("mai",R.drawable.panda,"iam feel saaaaad"));
        chatData.add(new chatmodel("sahar",R.drawable.panda,"الله ينور"));
        chatData.add(new chatmodel("dina",R.drawable.panda,"انا جضيت"));
        chatData.add(new chatmodel("doaa",R.drawable.panda,"عايزة اساافر"));
        chatData.add(new chatmodel("akoya",R.drawable.panda,"انا توهت مني "));
        chatData.add(new chatmodel("rahma",R.drawable.panda,"انا مش عارفني"));
        chatData.add(new chatmodel("shaimaa",R.drawable.panda,"يناس كترتو دمعي"));
        chatData.add(new chatmodel("shahd",R.drawable.panda,"يدنيا طفيتي شمعي"));
        chatData.add(new chatmodel("yasmine",R.drawable.panda,"ساد ورب العباد"));
        chatData.add(new chatmodel("Npytch",R.drawable.panda,"اسكني انتي "));
        chatData.add(new chatmodel("خالد كشميرى",R.drawable.panda,""));
        chatData.add(new chatmodel("يعقوب قمر الدين دبيازة",R.drawable.panda,"ya hooo"));
        chatData.add(new chatmodel("خضر كراويته",R.drawable.panda,"yaaa naaaas"));
        chatData.add(new chatmodel("اسماعيل احمد كنباوي",R.drawable.panda,"how is it going"));
        chatData.add(new chatmodel("محمد سومبل",R.drawable.panda,"hello roaa"));

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.men1,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public void onChatCardClick(chatmodel chatmodel){
        startActivity(new Intent(requireActivity(),chatActivity.class));
    }
}