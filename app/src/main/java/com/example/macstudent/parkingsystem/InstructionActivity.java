package com.example.macstudent.parkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class InstructionActivity extends AppCompatActivity {
 WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);



              myWebView = findViewById(R.id.myWebView);
              myWebView.loadUrl("file:///android_asset/instruction.html");

    }

}
