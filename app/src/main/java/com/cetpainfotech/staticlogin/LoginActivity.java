package com.cetpainfotech.staticlogin;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{
//declare java object for xml widgets
    //int a;
    EditText username,password;
    Button login;
    TextToSpeech tts;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to attach the activity_login xml pageto java class
        setContentView(R.layout.activity_login);
        //typecast convert xml widgets into java objects
        //admin as username
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        login=findViewById(R.id.login1);

        //text to speech from main to main
        tts=new TextToSpeech(LoginActivity.this,this);
        //to click on the login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to pass any action to perform

                // admin is test username
                // 12345 is test password
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("12345"))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                    // text to speech
                    tts.speak("Credentials correct",TextToSpeech.QUEUE_ADD,null);
                }
                else {

                    //toast message
                    Toast.makeText(LoginActivity.this, "Credentials incorrect", Toast.LENGTH_SHORT).show();

                    //text to speech
                    tts.speak("Credentials incorrect",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
}
/// to text to speeech
    @Override
    public void onInit(int status) {
        tts.setLanguage(Locale.ENGLISH);
        tts.setSpeechRate(0.8f);
    }
}
