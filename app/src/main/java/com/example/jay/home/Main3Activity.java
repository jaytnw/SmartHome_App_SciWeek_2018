package com.example.jay.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends Activity {
    ImageButton btBack,btLiving,btBath;
    String chkLiving = "ON",chkBath= "ON";
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference LivingRoom = mRootRef.child("LivingRoom2");
    DatabaseReference BathnRoom = mRootRef.child("BathnRoom2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);

        btBack = (ImageButton) findViewById(R.id.btBack3);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main3Activity.this,MainActivity.class);
                finish();
            }
        });
        btLiving = (ImageButton) findViewById(R.id.btLiving);
        btLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkLiving == "OFF" ){
                    btLiving.setImageResource(R.mipmap.living);
                    LivingRoom.setValue("OFF");
                    chkLiving = "ON";
                }else if(chkLiving == "ON" )  {
                    btLiving.setImageResource(R.mipmap.living_click);
                    LivingRoom.setValue("ON");
                    chkLiving = "OFF";
                }
            }
        });

        btBath = (ImageButton) findViewById(R.id.btBath);
        btBath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkBath == "OFF" ){
                    btBath.setImageResource(R.mipmap.bath);
                    BathnRoom.setValue("OFF");
                    chkBath = "ON";
                }else if(chkBath == "ON" )  {
                    btBath.setImageResource(R.mipmap.bath_click);
                    BathnRoom.setValue("ON");
                    chkBath = "OFF";
                }
            }
        });



    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
