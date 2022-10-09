package com.example.firebase;

import static com.google.firebase.auth.PhoneAuthProvider.verifyPhoneNumber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Phone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        EditText Enum = findViewById(R.id.number);
        Button otp = findViewById(R.id.otp);

        otp.setOnClickListener(v -> {

            if(!Enum.getText().toString().trim().isEmpty())
            {
                if(Enum.getText().toString().trim().length()==10) {
                    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = null;
                    FirebaseAuth mAuth = null;
                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(String.valueOf(Enum))       // Phone number to verify
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(this)                 // Activity (for callback binding)
                                    .setCallbacks(mCallBack)          // OnVerificationStateChangedCallbacks
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                } else
                {
                    Toast.makeText(Phone.this, "Enter Correct Number", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(Phone.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            }

        });


    }
}