package org.abhijay.com.firebase_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class DatabaseExample extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_screen);
        findViewById(R.id.read_btn).setOnClickListener(this);
        findViewById(R.id.write_btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        switch(i){
            case R.id.read_btn:
                startActivity(new Intent(DatabaseExample.this,ReadData.class));
                break;
            case R.id.write_btn:
                startActivity(new Intent(DatabaseExample.this,WriteData.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
