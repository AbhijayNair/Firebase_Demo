package org.abhijay.com.firebase_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class ReadData extends AppCompatActivity {

    String NAME,EMAIL,PHONE;
    TextView name,email,phone;
    FirebaseUser user;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_data);
        name =findViewById(R.id.name_text);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.phone_text);
        user= FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("DATA").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                NAME = dataSnapshot.child("Name").getValue(String.class);
                name.setText(NAME);
                EMAIL = dataSnapshot.child("Email ID").getValue(String.class);
                email.setText(EMAIL);
                PHONE = dataSnapshot.child("Phone").getValue(String.class);
                phone.setText(PHONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
