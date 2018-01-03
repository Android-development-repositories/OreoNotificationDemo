package com.demo.notification;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rachit Solanki on 3/1/18.
 */

public class Main extends AppCompatActivity {


    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // register broadcast receivers
        // @link https://developer.android.com/guide/components/broadcasts.html#receiving_broadcasts
        getApplication()
                .registerReceiver(new MyReceiver(),new IntentFilter(Filters.ACTION_FILTER_DEMO));

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Filters.ACTION_FILTER_DEMO);
                intent.putExtra(Filters.KEY_DEMO,"May the force be with you!");
                sendBroadcast(intent);

            }
        });

    }



}
