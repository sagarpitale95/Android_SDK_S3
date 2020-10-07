package com.anurag_mishra.my_prac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send_server(View view){
        Intent intent = new Intent(this, Send_Server.class);
        startActivity(intent);
    }
    public void recieve_server(View view){
        Intent intent = new Intent(this, Recieve_server.class);
        startActivity(intent);
    }

}