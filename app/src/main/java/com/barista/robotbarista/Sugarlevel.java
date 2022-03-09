package com.barista.robotbarista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Sugarlevel extends AppCompatActivity {

    RadioGroup rg_sugar;
    Button btn_sugar_next;
    Button btn_sugar_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugarlevel);

        rg_sugar  = (RadioGroup) findViewById(R.id.rg_sugar);
        btn_sugar_next = (Button) findViewById(R.id.btn_sugar_next);
        btn_sugar_back = (Button) findViewById(R.id.btn_sugar_back);
        //proceed to choose milk
        btn_sugar_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkID = rg_sugar.getCheckedRadioButtonId();
                if (checkID == -1){
;                    //Nothing selected
                    Message.message(getApplicationContext(), "Sugar level not selected");
                }else{
                    //Selected
                    findRadioButton_sugar(checkID);
                    //Proceed to choose Milk
                    Bundle extras = getIntent().getExtras();
                    Integer coffee = extras.getInt("key1");
                    //System.out.println(coffee);

                    if (checkID == 2131231062){
                        int y = 0;
                        String sugar_result = Integer.toString(coffee) + Integer.toString(y);
                        Integer sugar_results=Integer.parseInt(sugar_result); //String to Integer
                        //System.out.println(sugar_result);
                        Intent sugar= new Intent(Sugarlevel.this,Milk.class);
                        sugar.putExtra("key2",sugar_results);
                        startActivity(sugar);
                    }
                    else if (checkID == 2131231064){
                        int y=1;
                        String sugar_result = Integer.toString(coffee) + Integer.toString(y);
                        Integer sugar_results=Integer.parseInt(sugar_result); //String to Integer
                        Intent sugar= new Intent(Sugarlevel.this,Milk.class);
                        sugar.putExtra("key2",sugar_results);
                        startActivity(sugar);
                    }
                    else if (checkID == 2131231065){
                        int y=2;
                        String sugar_result = Integer.toString(coffee) + Integer.toString(y);
                        Integer sugar_results=Integer.parseInt(sugar_result); //String to Integer
                        Intent sugar= new Intent(Sugarlevel.this,Milk.class);
                        sugar.putExtra("key2",sugar_results);
                        startActivity(sugar);
                    }
                    else if (checkID == 2131231066){
                        int y=3;
                        String sugar_result = Integer.toString(coffee) + Integer.toString(y);
                        Integer sugar_results=Integer.parseInt(sugar_result); //String to Integer
                        Intent sugar= new Intent(Sugarlevel.this,Milk.class);
                        sugar.putExtra("key2",sugar_results);
                        startActivity(sugar);
                    }
                    else if (checkID == 2131231063){
                        int y=4;
                        String sugar_result = Integer.toString(coffee) + Integer.toString(y);
                        Integer sugar_results=Integer.parseInt(sugar_result); //String to Integer
                        Intent sugar= new Intent(Sugarlevel.this,Milk.class);
                        sugar.putExtra("key2",sugar_results);
                        startActivity(sugar);
                    }
                }
            }
        });
        //Go back to typeofcoffee
        btn_sugar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sugarlevel.this,Typeofcoffee.class);
                startActivity(intent);
            }
        });
    }
    private void findRadioButton_sugar(int checkID) {
        switch (checkID) {
            case R.id.rb_s0:
                Message.message(getApplicationContext(), "Sugar level 0% selected");
                break;
            case R.id.rb_s25:
                Message.message(getApplicationContext(), "Sugar level 25% selected");
                break;
            case R.id.rb_s50:
                Message.message(getApplicationContext(), "Sugar level 50% selected");
                break;
            case R.id.rb_s75:
                Message.message(getApplicationContext(), "Sugar level 75% selected");
                break;
            case R.id.rb_s100:
                Message.message(getApplicationContext(), "Sugar level 100% selected");
                break;
        }
    }
}