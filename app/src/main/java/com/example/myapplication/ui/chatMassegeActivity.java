package com.example.whatsapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp.R;
import com.example.whatsapp.databinding.ActivityChatBinding;
import com.example.whatsapp.model.messageModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class chatMassegeActivity extends AppCompatActivity {
 public final static String userId="s213";
 ActivityChatBinding binding;
 ArrayList<messageModel>list=new ArrayList<>();
 DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
 messageAdapter messageAdapter=new messageAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.sendButtun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=binding.editMass.getText().toString().trim();
                if(!message.isEmpty()){
                sendMess(message);
                }
            }
        });
        getMess();
    }
    private void sendMess(String message)
    {
         ref.child("message").push().setValue(new messageModel(message,userId));
         binding.editMass.setText("");

    }
    private void getMess(){
        ref.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren())
                {
                    list.add(snapshot1.getValue(messageModel.class));
                }
                     messageAdapter.setList(list);
                    binding.messRecycle.setAdapter(messageAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}