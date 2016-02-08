package com.example.asra.umbrellaaa;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    Button feed;
    Button report;
    ImageButton next;
    EditText hint;
    ImageButton final3;
    String message;

    //configure list view


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> myItems = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layoutlist, myItems);
        ListView listt = (ListView) findViewById(R.id.listView);
        listt.setAdapter(adapter);
        final3 = (ImageButton)findViewById(R.id.final2);
        final3.setVisibility(View.GONE);
        report = (Button)findViewById(R.id.button5);
        feed = (Button)findViewById(R.id.button4);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed.setBackgroundColor(Color.WHITE);
                report.setBackgroundColor(Color.parseColor("#f39c12"));
                feed.setTextColor(Color.parseColor("#f39c12"));
                report.setTextColor(Color.WHITE);


            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feed.setBackgroundColor(Color.parseColor("#f39c12"));
                report.setBackgroundColor(Color.WHITE);
                feed.setTextColor(Color.WHITE);
                report.setTextColor(Color.parseColor("#f39c12"));
                Intent editScreen = new Intent(getApplicationContext(), Main2Activity.class);
                editScreen.putExtra("oudata", myItems);
                startActivity(editScreen);

            }
        });
        //after message
        next = (ImageButton)findViewById(R.id.send);
        hint = (EditText)findViewById(R.id.search);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hint.setHint("Type location");
                message = (hint.getText()).toString();
                //myItems.add("hi");
                //adapter.notifyDataSetChanged();
                next.setVisibility(View.GONE);
                final3.setVisibility(View.VISIBLE);
                hint.getText().clear();

            }

        });
        //after location
        final3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final3.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                hint.setHint("Type message");
                String location = (hint.getText()).toString();
                hint.getText().clear();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd, HH:mm a");
                String currentDateandTime = sdf.format(new Date());
                String subitem = location + ", " + currentDateandTime + "\n" + "\n" + message;
                myItems.add(0, subitem);
                //myItems.add(subitem);
                adapter.notifyDataSetChanged();


            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
}
