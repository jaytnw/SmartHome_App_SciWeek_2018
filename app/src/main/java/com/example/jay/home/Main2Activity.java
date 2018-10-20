package com.example.jay.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends Activity {
    ImageButton btBack,btLiving,btKitchen,btBath;
    public String chkLiving = "ON",chkKitchen= "ON",chkBath= "ON";

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference LivingRoom = mRootRef.child("LivingRoom1");
    DatabaseReference KitchenRoom = mRootRef.child("KitchenRoom1");
    DatabaseReference BathnRoom = mRootRef.child("BathnRoom1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        btBack = (ImageButton) findViewById(R.id.btBtack2);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
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
        btKitchen = (ImageButton) findViewById(R.id.btKitchen);
        btKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkKitchen == "OFF" ){
                    btKitchen.setImageResource(R.mipmap.kitchen);
                    KitchenRoom.setValue("OFF");
                    chkKitchen = "ON";
                }else if(chkKitchen == "ON" )  {
                    btKitchen.setImageResource(R.mipmap.kitchen_click);
                    KitchenRoom.setValue("ON");
                    chkKitchen = "OFF";
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

    public void load(){
        LivingRoom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(String.class)!= null ) {
                    chkLiving = dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
