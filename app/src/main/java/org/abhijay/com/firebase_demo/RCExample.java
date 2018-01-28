package org.abhijay.com.firebase_demo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class RCExample extends AppCompatActivity {
    FirebaseRemoteConfig mFirebaseRemoteConfig;
    long cacheExpiration = 0;
    View viewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rc_layout);
         viewGroup = findViewById(R.id.rc_back);
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Map<String,Object> m = new HashMap<>();
        m.put("Status",false);
        mFirebaseRemoteConfig.setDefaults(m);
        fetchData();

    }

    private void fetchData() {
        mFirebaseRemoteConfig.fetch(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d("Fetch:","Successful");
                    mFirebaseRemoteConfig.activateFetched();
                }
                else{
                    Log.d("Fetch:","Failed");
                }
                changeBack();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void changeBack() {
        boolean mStatus = mFirebaseRemoteConfig.activateFetched();
        Log.d("TAG",String.valueOf(mStatus));
        if(mFirebaseRemoteConfig.getBoolean("Status")){
            viewGroup.setBackgroundColor(Color.parseColor("#00ff00"));
        }
        else{
            viewGroup.setBackgroundColor(Color.parseColor("#ff0000"));
        }
   }


}
