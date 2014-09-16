package com.example.david.chatbox;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by david on 9/11/14.
 */
public class ChatAdapter extends ArrayAdapter<String> {

    public ChatAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }
}
