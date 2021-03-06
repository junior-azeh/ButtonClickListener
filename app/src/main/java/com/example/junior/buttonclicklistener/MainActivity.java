package com.example.junior.buttonclicklistener;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private int numTimesClicked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    /** Called when the user taps the Send button */
    public  void incrementTap(View view) {
        // Do something in response to button
        TextView textView = findViewById(R.id.textview);
        numTimesClicked = numTimesClicked + 1;
        String result = "The button got tapped " + numTimesClicked + " time";
        if(numTimesClicked != 1) {
            result += "s...";
        }
        textView.setText(result);
    }

    public  void sendMessage(View view) {
        Intent intent = new Intent(this, ButtonCountActivity.class);
        TextView textView = findViewById(R.id.textview);
        String message = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

       }
    }


