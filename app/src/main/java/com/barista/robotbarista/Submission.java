package com.barista.robotbarista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Submission extends AppCompatActivity {

    Button btn_restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Bundle extras = getIntent().getExtras();
        String submission = extras.getString("key3");
        System.out.println("Submissioooooooonnn");
        System.out.println(submission);

        btn_restart = (Button) findViewById(R.id.btn_restart);
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Submission.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
