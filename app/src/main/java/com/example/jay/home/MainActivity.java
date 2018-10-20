package com.example.jay.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends Activity {
    ImageButton btDown,btUp,btFront,btLamp,btLiv,btbd1,btbd2;
    TextView tem1,tem2,title,tem,hum;
    Calendar cal = Calendar.getInstance();
    String chk1 ="ON" ,chk2="ON" ;
    String cb1 ="ON" ,cb2="ON" ,chL="ON";



    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference Tem = mRootRef.child("Tem");
    DatabaseReference Hum = mRootRef.child("Hum");

    DatabaseReference Liv = mRootRef.child("Living");
    DatabaseReference bed1 = mRootRef.child("Bedroom1");
    DatabaseReference bed2 = mRootRef.child("Bedroom2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        tem = (TextView) findViewById(R.id.tem);
        hum = (TextView) findViewById(R.id.hum);

        Tem.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temm = dataSnapshot.getValue(String.class);
                tem.setText(temm);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Hum.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String humm = dataSnapshot.getValue(String.class);
                hum.setText(humm);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        int hourofday = cal.get(Calendar.HOUR_OF_DAY);
        title = (TextView) findViewById(R.id.title);
        if(hourofday>=6 && hourofday <12){
            title.setText("Good Morning");
        }else if(hourofday >= 12 && hourofday <= 18){
            title.setText("Good Afternoon");
        }else if(hourofday > 18  && hourofday <= 24){
            title.setText("Good Night");
        }else  {
            title.setText("Nooo");
        }

        btLiv = (ImageButton) findViewById(R.id.btLiv);
        btLiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chL == "OFF" ){
                    btLiv.setImageResource(R.mipmap.living);
                    Liv.setValue("OFF");
                    chL = "ON";
                }else if(chL == "ON" )  {
                    btLiv.setImageResource(R.mipmap.living_click);
                    Liv.setValue("ON");
                    chL = "OFF";
                }
            }
        });

        btbd1 = (ImageButton) findViewById(R.id.btB1);
        btbd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cb1 == "OFF" ){
                    btbd1.setImageResource(R.mipmap.bedroom1);
                    bed1.setValue("OFF");
                    cb1 = "ON";
                }else if(cb1 == "ON" )  {
                    btbd1.setImageResource(R.mipmap.bedroom1_click);
                    bed1.setValue("ON");
                    cb1 = "OFF";
                }
            }
        });

        btbd2 = (ImageButton) findViewById(R.id.btB2);
        btbd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cb2 == "OFF" ){
                    btbd2.setImageResource(R.mipmap.bedroom2);
                    bed2.setValue("OFF");
                    cb2 = "ON";
                }else if(cb2 == "ON" )  {
                    btbd2.setImageResource(R.mipmap.bedroom2_click);
                    bed2.setValue("ON");
                    cb2 = "OFF";
                }
            }
        });




//        btDown = (ImageButton) findViewById(R.id.btDown);
////        tem1 = (TextView) findViewById(R.id.tem1);
////        btDown.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                btDown.setImageResource(R.mipmap.down_click);
////                tem1.setTextColor(Color.parseColor("#FFFFFF"));
////                return false;
////            }
////        });

//        btDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//
//
//
//            }
//        });


//
//        btUp = (ImageButton) findViewById(R.id.btUp);
////        tem2 = (TextView) findViewById(R.id.tem2);
////        btUp.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                btUp.setImageResource(R.mipmap.up_click);
////                tem2.setTextColor(Color.parseColor("#FFFFFF"));
////                return false;
////            }
////        });
//        btUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//
//            }
//        });
//
//        btFront = (ImageButton) findViewById(R.id.btFront);
//        btFront.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(chk1 == "OFF" ){
//                    btFront.setImageResource(R.mipmap.front);
//                    FrontLight.setValue("OFF");
//                    chk1 = "ON";
//                }else if(chk1 == "ON" )  {
//                    btFront.setImageResource(R.mipmap.front_click);
//                    FrontLight.setValue("ON");
//                    chk1 = "OFF";
//                }
//            }
//        });
//
//        btLamp = (ImageButton) findViewById(R.id.btLamp);
//        btLamp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(chk2 == "OFF" ){
//                    btLamp.setImageResource(R.mipmap.lamp);
//                    LampFence.setValue("OFF");
//                    chk2 = "ON";
//                } else if(chk2 == "ON" ) {
//                    btLamp.setImageResource(R.mipmap.lamp_click);
//                    LampFence.setValue("ON");
//                    chk2 = "OFF";
//                }
//            }
//        });


    }

}
