package com.example.davelkan.mychatbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davelkan on 12/23/14.
 */
public class chatAdapter extends ArrayAdapter{
    private int resource;
    private Context context;
    private List<ChatModel> chatmod = new ArrayList<ChatModel>();
    public chatAdapter(final Context context, int resource, List<ChatModel> chats) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        populate(chats);
    }

    private class chatBox{
        TextView messageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView is child
        chatBox chatBox;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) { // this child is new // has not been rendered
            // inflater takes id of chat item and parent view
            convertView = inflater.inflate(resource, parent, false);

            // holder keeps all found views from last timestamp (we can update the views directly without re-finding them)
            chatBox = new chatBox();

            // find elements in chat item, cast to views
            chatBox.messageView = (TextView) convertView.findViewById(R.id.messageView);
            convertView.setTag(chatBox);
        } else {
            chatBox = (chatBox) convertView.getTag();
        }
        //chatBox.messageView.setText(chats.get(position).name + " @ " + chats.get(position).timestamp + ": " + chats.get(position).message);
        fillViews(chatBox, chatmod.get(position));
        notifyDataSetChanged();
        return convertView;
    }

    @Override
    public int getCount() {
        return this.chatmod.size();
    }

    public ChatModel getChat(int index) {
        if(index + 1 > this.chatmod.size() || index < 0) {
            return null;
        } else {
            return this.chatmod.get(index);
        }
    }

    private void fillViews(chatBox chatBox, ChatModel chat) {
        chatBox.messageView.setText(chat.name + " @ " + chat.timestamp + ": " + chat.message);
        this.chatmod.add(chat);
    }

    public void populate(List<ChatModel> moarChats){
//        this.chats.addAll(moarChats);
        notifyDataSetChanged();
    }
}
