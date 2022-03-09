package com.barista.robotbarista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Milk extends AppCompatActivity {

    RadioGroup rg_milk;
    Button btn_milk_submit;
    Button btn_milk_back;
    static String finalr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);

        rg_milk  = (RadioGroup) findViewById(R.id.rg_milk);
        btn_milk_submit = (Button) findViewById(R.id.btn_milk_submit);
        btn_milk_back = (Button) findViewById(R.id.btn_milk_back);

        //Submit
        btn_milk_submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                sendRequestWithHttpURLConnection1();
                int checkID = rg_milk.getCheckedRadioButtonId();
                if (checkID == -1){
                    //Nothing selected
                    Message.message(getApplicationContext(), "Milk choice not selected");
                }else{
                    //Selected
                    findRadioButton_milk(checkID);
                    //Proceed to Submit
                    Bundle extras = getIntent().getExtras();
                    Integer sugar = extras.getInt("key2");
                    //System.out.println(sugar);
                    if (checkID == 2131231060){
                        int z = 0;
                        String milk_result = Integer.toString(sugar) + Integer.toString(z);
                        finalr=milk_result;
                        //System.out.println(milk_result);
                        Intent milk= new Intent(Milk.this,Submission.class);
                        milk.putExtra("key3",finalr);
                        startActivity(milk);

                    }
                    else if (checkID == 2131231061){
                        int z = 1;
                        String milk_result = Integer.toString(sugar) + Integer.toString(z);
                        finalr=milk_result;
                        //System.out.println(milk_result);
                        Intent milk= new Intent(Milk.this,Submission.class);
                        milk.putExtra("key3",finalr);
                        //start();
                        startActivity(milk);
                    }
                }
            }
        });
        //Go back to type of coffee
        btn_milk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Milk.this,Sugarlevel.class);
                startActivity(intent);
            }
        });
    }
    private void findRadioButton_milk(int checkID) {
        switch (checkID){
            case R.id.rb_m0:
                Message.message(getApplicationContext(),"No milk selected");
                break;
            case R.id.rb_m1:
                Message.message(getApplicationContext(),"Milk selected");
                break;
        }
    }
    /////Socket/////
    public void sendRequestWithHttpURLConnection1()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run() {
                int PORT = 6355;
                InetAddress addr = null;
                try
                {
                    addr = InetAddress.getByName("172.20.10.9");//Rpi IP address
                }
                catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }
                Socket socket = new Socket();
                try
                {
                    socket.connect(new InetSocketAddress(addr, PORT), 30000);
                    socket.setSendBufferSize(100);
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String value = finalr;
                    //System.out.println("chk");
                    //System.out.println(finalr);
                    out.write(value);
                    out.flush();

                }
                catch (SocketException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    StringBuilder response = new StringBuilder();
                    String line="Iot";
                    response.append(line);
                    //showResponse(response.toString());
                }
                finally
                {
                    try
                    {
                        socket.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    /////Socket/////
}