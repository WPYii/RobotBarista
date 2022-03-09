package com.barista.robotbarista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.List;

public class Typeofcoffee extends AppCompatActivity {

    RadioGroup rg_coffee;
    Button btn_coffee_next;
    Button btn_coffee_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeofcoffee);

        rg_coffee  = (RadioGroup) findViewById(R.id.rg_coffee);
        btn_coffee_next = (Button) findViewById(R.id.btn_coffee_next); //Next
        btn_coffee_back = (Button) findViewById(R.id.btn_coffee_back); //Back

        btn_coffee_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkID = rg_coffee.getCheckedRadioButtonId();
                if (checkID == -1){
                    //Nothing selected
                    Message.message(getApplicationContext(), "Type of coffee not selected");
                }else{
                    //Selected
                    findRadioButton_coffee(checkID);
                    //Proceed to choose Sugar Level
                    //System.out.println("Coffee");
                    //System.out.println(checkID);
                    if (checkID == 2131231053){
                        int x=1;
                        Intent coffee= new Intent(Typeofcoffee.this,Sugarlevel.class);
                        coffee.putExtra("key1",x);
                        startActivity(coffee);
                    }
                    else if (checkID == 2131231054){
                        int x=2;
                        Intent coffee= new Intent(Typeofcoffee.this,Sugarlevel.class);
                        coffee.putExtra("key1",x);
                        startActivity(coffee);
                    }
                    else if (checkID == 2131231055){
                        int x=3;
                        Intent coffee= new Intent(Typeofcoffee.this,Sugarlevel.class);
                        coffee.putExtra("key1",x);
                        startActivity(coffee);
                    }
                    /*
                    String value="1";
                    Intent i = new Intent(Typeofcoffee.this, Sugarlevel.class);
                    i.putExtra("key",value);
                    startActivity(i);*/
                    /////
                }
            }
        });
        //go back to main page
        btn_coffee_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Typeofcoffee.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void findRadioButton_coffee(int checkID) {
        switch (checkID) {
            case R.id.rb_a:
                Message.message(getApplicationContext(),"Coffee A selected");
                break;
            case R.id.rb_b:
                Message.message(getApplicationContext(),"Coffee B selected");
                break;
            case R.id.rb_c:
                Message.message(getApplicationContext(),"Coffee C selected");
                break;
            case R.id.rb_d:
                Message.message(getApplicationContext(),"Sold out");
                break;
            case R.id.rb_e:
                Message.message(getApplicationContext(),"Sold out");
                break;
            case R.id.rb_f:
                Message.message(getApplicationContext(),"Sold out");
                break;
            case R.id.rb_g:
                Message.message(getApplicationContext(),"Sold out");
                break;
        }
    }
}

