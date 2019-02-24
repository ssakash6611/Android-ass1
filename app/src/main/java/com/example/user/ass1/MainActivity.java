package com.example.user.ass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText et;
Button bt;
ListView lv;
ArrayAdapter<String> aa;
ArrayList<String> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editText);
        bt=findViewById(R.id.button);
        lv=findViewById(R.id.list);
        al=new ArrayList<>();
        aa=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aa.add(et.getText().toString());
                et.setText("");
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                al.remove(i);
                aa.notifyDataSetChanged();
                return true;
            }
        });
    }
}
