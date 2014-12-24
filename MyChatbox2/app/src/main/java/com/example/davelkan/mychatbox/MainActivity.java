package com.example.davelkan.mychatbox;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ExpandableListAdapter;

import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.R.layout.expandable_list_content;


public class MainActivity extends ActionBarActivity {
    String activeUser;
    List<String> userList;
    Spinner spinner;
   // TextView textView;
    Button submit;
    EditText message;
    ArrayList chatArray;
    ListView chats;
    List<ChatModel> chatmod;
//    ChatModel newChat;
 //   ArrayAdapter madapter;
    ArrayAdapter adapter;
    chatAdapter newAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStuff();
//        Firebase myFirebaseRef = new Firebase("https://<your-firebase>.firebaseio.com/");
        populateUsers();
        buildUserListener();
        buildSubmitListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void populateUsers(){
        userList.add("Wolf");
        userList.add("Bond");
        userList.add("balls");
        chatArray.add("This is the first message");
        chatArray.add("This is the second message");
        chatArray.add("This is the third message");

        /*madapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, chatArray);
        chats.setAdapter(madapter);*/
        newAdapter = new chatAdapter(this,R.layout.chat_item,chatmod);
        //newAdapter.populate(chatmod);
        chats.setAdapter(newAdapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void buildUserListener(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                activeUser = spinner.getItemAtPosition(position).toString();
                //
                // textView.setText(activeUser);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void buildSubmitListener(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = message.getText().toString();
                input = activeUser +": " + input;
                if(null!=input&&input.length()>0){
                    /*if(Array.getLength(chatArray) > 6) {
                        //chatarry.rm
                        chatArray.add(input);
                        madapter.notifyDataSetChanged();
                    }*/
                    ChatModel newChat = new ChatModel();
                    newChat.message = input;
                    newChat.name = activeUser;
                    newChat.timestamp = System.currentTimeMillis()/1000;
                    chatmod.add(newChat);
                   //chatArray.add(input);
                    //madapter.notifyDataSetChanged();
                    newAdapter.notifyDataSetChanged();
                }
            }
        });
    }


    public void initStuff(){
        userList  = new ArrayList<>();
        chatArray = new ArrayList<>();
        chatmod = new List<ChatModel>() {
            @Override
            public void add(int location, ChatModel object) {

            }

            @Override
            public boolean add(ChatModel object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends ChatModel> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ChatModel> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public ChatModel get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<ChatModel> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<ChatModel> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<ChatModel> listIterator(int location) {
                return null;
            }

            @Override
            public ChatModel remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public ChatModel set(int location, ChatModel object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<ChatModel> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        //textView = (TextView)findViewById(R.id.textView);
        submit = (Button)findViewById(R.id.submit);
        message = (EditText)findViewById(R.id.message);
        chats = (ListView)findViewById(R.id.chats);
        spinner = (Spinner) findViewById(R.id.spinner);
    }


}
