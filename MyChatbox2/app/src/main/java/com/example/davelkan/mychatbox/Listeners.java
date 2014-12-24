package com.example.davelkan.mychatbox;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by davelkan on 12/22/14.
 */
public class Listeners extends MainActivity implements AdapterView.OnItemSelectedListener {
    TextView textView;


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        activeUser = spinner.getItemAtPosition(position).toString();
        textView.setText(activeUser);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void buildSubmitListener(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}