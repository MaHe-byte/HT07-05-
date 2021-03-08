package com.example.ht07_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    EditText inputText2;
    TextView text;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        inputText = findViewById(R.id.editTextTextPersonName);
        inputText2 = findViewById(R.id.editTextTextPersonName2);
        context = MainActivity.this;
    }


    public void readFile(View v){
        try {
            InputStream is = context.openFileInput(inputText2.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s = "";

            while((s=br.readLine()) != null){
                text.setText(s);
                
            }
            is.close();
        } catch (IOException e) {
            Log.e("IOEXCEPTION", "Virhe");
        }

    }

    public void wrtieFile(View v){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(inputText2.getText().toString(),Context.MODE_PRIVATE));
            String s = "";
            s = inputText.getText().toString();
            osw.write(s);
            osw.close();

        }
         catch (IOException e) {
            Log.e("IOEXCEPTION", "Virhe");
        }



    }
}