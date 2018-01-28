package org.abhijay.com.firebase_demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class WriteData extends AppCompatActivity {

    public String NAME,EMAIL,PHONE;
    EditText name,email,phone;
    DatabaseReference mDataBase;
    FirebaseUser user;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.write_data);
       user= FirebaseAuth.getInstance().getCurrentUser();
       name = findViewById(R.id.name_edit);
       email = findViewById(R.id.email_edit);
       phone = findViewById(R.id.phone_edit);
       mDataBase = FirebaseDatabase.getInstance().getReference().child("DATA").child(user.getUid());
       findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mDataBase.child("Name").setValue(name.getText().toString());
               mDataBase.child("Email ID").setValue(email.getText().toString());
               mDataBase.child("Phone").setValue(phone.getText().toString());
           }
       });
   }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
