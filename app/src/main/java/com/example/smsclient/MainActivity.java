package com.example.smsclient;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText no, msg;
    Button snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no = (EditText) findViewById(R.id.editText);
        msg= (EditText) findViewById(R.id.editText1);
        snd = (Button) findViewById(R.id.button);
        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms();
            }
        });
    }

    void sendsms() {
        String num = no.getText().toString();
        String msg1 = msg.getText().toString();
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(num, null, msg1 + "\n~Sent From My SMS Client", null, null);
        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
    }
}
