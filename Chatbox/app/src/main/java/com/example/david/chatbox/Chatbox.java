package com.example.david.chatbox;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;


public class Chatbox extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbox);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chatbox, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_chatbox, container, false);
            ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);
            final String[] listChats = {"Dude","What","the","funky"};
            final ArrayList<String> arrayChats = new ArrayList<String>(Arrays.asList(listChats));
            Button myButton = (Button) rootView.findViewById(R.id.myButton);
            final EditText the_chat = (EditText) rootView.findViewById(R.id.editText);

            final ChatAdapter mAdapter = new ChatAdapter(getActivity(), R.layout.chatfile, arrayChats);
            myListView.setAdapter(mAdapter);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String input = the_chat.getText().toString();
                    if(null!=input&&input.length()>0){
                        arrayChats.add(input);
                        mAdapter.notifyDataSetChanged();
                    }
            }
            });


            return rootView;

        }

    }
}
