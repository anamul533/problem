package com.haquedeveloper.texttospeekstop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText edtextid;
    FloatingActionButton fabuttonid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtextid = (EditText) findViewById(R.id.edtextid);
        fabuttonid = (FloatingActionButton) findViewById(R.id.fabuttonid);

        TextToSpeech textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        fabuttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String text = edtextid.getText().toString();
                    if (edtextid.length()>0) {
                        if (fabuttonid.getTag() != null && fabuttonid.getTag().toString().contains("not_speek"))
                        {
                            textToSpeech.stop();
                            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                            fabuttonid.setTag("speek");
                            fabuttonid.setImageResource(R.drawable.voice2);
                    }else {
                            edtextid.setError("Plase Enter your Input Value!");
                        }
              }
            }
        });
    }
}