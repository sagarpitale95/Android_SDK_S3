package com.anurag_mishra.my_prac;
import com.anurag_mishra.my_prac.amplify;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;




public class Send_Server extends AppCompatActivity {

    private static final int FILE_SELECT_CODE = 42;
    String addr = new String("");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__server);
    }

    public void browse(View view){
        browser();
    }
    public void browser(){
        Intent intent = new Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,FILE_SELECT_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == FILE_SELECT_CODE && resultCode == RESULT_OK) {
            if(data != null){
                Uri uri = data.getData();
                this.addr = uri.getPath().toString();

                TextView txv = (TextView) findViewById(R.id.textview1);
                txv.setText(this.addr);

                //Toast.makeText(this,this.addr,Toast.LENGTH_SHORT);

            }

        }
    }

    public void send_file(View view){
        TextView txu = (TextView) findViewById(R.id.textview2);
        txu.setText("Processing");

        if(this.addr.equals(new String(""))){
            txu.setText("Select File First");
        }
        else
        {
            amplify sos = new amplify("avai.csv",this.addr);
            txu.setText(sos.upload(this));
        }


    }


}