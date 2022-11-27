package com.example.whatsapp.ui;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.R;
import com.example.whatsapp.databinding.ItemMessageLayoutBinding;
import com.example.whatsapp.model.messageModel;

import java.util.ArrayList;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.holder>{
ArrayList<messageModel>list;

    public void setList(ArrayList<messageModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_message_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        messageModel messageModel=list.get(position);
        if(messageModel.getSenderId().equals(chatActivity.userId)){
            holder.binding.messChat.setGravity(Gravity.END);
        }
        else
        { holder.binding.messChat.setGravity(Gravity.START);}

        holder.binding.messChat.setText(messageModel.getMessage());


    }

    @Override
    public int getItemCount() {
        return list==null ? 0 : list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ItemMessageLayoutBinding binding;
        TextView message;
        public holder(@NonNull View itemView) {
            super(itemView);
        message=itemView.findViewById(R.id.mess_recycle);
    }
    }
}
