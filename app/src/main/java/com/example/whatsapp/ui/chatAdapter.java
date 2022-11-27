package com.example.whatsapp.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whatsapp.R;
import com.example.whatsapp.model.chatmodel;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatHolder> {
    private List<chatmodel>chats;

    public chatAdapter(List<chatmodel> chats ) {

        this.chats = chats;

    }

    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_layout,parent,false);
        return new chatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatHolder holder, int position) {
      chatmodel chatmodel=chats.get(position);
      holder.photo.setImageResource(chatmodel.getPhoto());
      holder.chat.setText(chatmodel.getChat());
      holder.username.setText(chatmodel.getUsername());
    }

    @Override
    public int getItemCount() {

        if (chats!=null)
            return chats.size();
        return 0;
    }

    static class chatHolder extends RecyclerView.ViewHolder{
        TextView username,chat;
        ImageView photo;
        public chatHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            chat=itemView.findViewById(R.id.chat);
            photo=itemView.findViewById(R.id.photo);


            };
        }
    }



