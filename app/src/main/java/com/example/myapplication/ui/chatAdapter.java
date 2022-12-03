package com.example.whatsapp.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whatsapp.R;
import com.example.whatsapp.databinding.ItemChatLayoutBinding;
import com.example.whatsapp.model.chatmodel;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatHolder> {
   public static List<chatmodel>chats;
    public static chatAction chatAction;
    public chatAdapter(List<chatmodel> chats,chatAction chatAction ) {

        this.chats = chats;
        this.chatAction=chatAction;
    }

    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatLayoutBinding itemChatLayoutBinding=
                ItemChatLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
                return  new chatHolder(itemChatLayoutBinding);
        //View view=LayoutInflater.from(parent.getContext())
           //     .inflate(R.layout.item_chat_layout,parent,false);
       // return new chatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatHolder holder, int position) {
      chatmodel chatmodel=chats.get(position);
      holder.binding.photo.setImageResource(chatmodel.getPhoto());
      holder.binding.chat.setText(chatmodel.getChat());
      holder.binding.username.setText(chatmodel.getUsername());
    }

    @Override
    public int getItemCount() {

        if (chats!=null)
            return chats.size();
        return 0;
    }

    static class chatHolder extends RecyclerView.ViewHolder{
        ItemChatLayoutBinding binding;
        //TextView username,chat;
        //ImageView photo;
        public chatHolder(@NonNull ItemChatLayoutBinding binding ) {
           // super(itemView);
            super(binding.getRoot());
           // username=itemView.findViewById(R.id.username);
           // chat=itemView.findViewById(R.id.chat);
           // photo=itemView.findViewById(R.id.photo);
            this.binding=binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chatAction.ChatCardClick(chats.get(getLayoutPosition()));
                }
            });
            }
        }

      public   interface chatAction{
         void ChatCardClick(chatmodel chatmodel);
        }
    }



