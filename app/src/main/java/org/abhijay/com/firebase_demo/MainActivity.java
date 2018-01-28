package org.abhijay.com.firebase_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.database_btn).setOnClickListener(this);
        findViewById(R.id.rc_btn).setOnClickListener(this);
        findViewById(R.id.noti_btn).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
                if(i == R.id.database_btn){
                    startActivity(new Intent(MainActivity.this,DatabaseExample.class));
                }
                else if(i == R.id.rc_btn){
                    startActivity(new Intent(MainActivity.this,RCExample.class));
                }
                else if(i == R.id.noti_btn){
                    startService(new Intent(MainActivity.this,FirebaseService.class));
                }
    }
}
