package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class verifyotp extends AppCompatActivity {

    EditText input1,input2,input3,input4,input5,input6;
    Button ver = findViewById(R.id.verify);
    String getotp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);

        input1 = findViewById(R.id.otp1);
        input2 = findViewById(R.id.otp2);
        input3 = findViewById(R.id.otp3);
        input4 = findViewById(R.id.otp4);
        input5 = findViewById(R.id.otp5);
        input6 = findViewById(R.id.otp6);

        getotp = getIntent().getStringExtra("getotp");
        ver.setOnClickListener(v -> {

            if(!input1.getText().toString().trim().isEmpty() && !input2.getText().toString().trim().isEmpty() && !input3.getText().toString().trim().isEmpty() && !input4.getText().toString().trim().isEmpty() && !input5.getText().toString().trim().isEmpty() && !input6.getText().toString().trim().isEmpty())
            {
                String enterotp = input1.getText().toString()+
                        input2.getText().toString()+
                        input3.getText().toString()+
                        input4.getText().toString()+
                        input5.getText().toString()+
                        input6.getText().toString();

                if(getotp!=null){
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            getotp,enterotp
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(getApplicationContext(),Home.class);
                            getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(i);
                        }else{
                            Toast.makeText(verifyotp.this, "Enter correct OTP", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });

            Toast.makeText(verifyotp.this, "OTP Verified", Toast.LENGTH_SHORT).show();
        }}else{
                Toast.makeText(verifyotp.this, "Enter all numbers", Toast.LENGTH_SHORT).show();
            }
        });
                otpmove();
    }
    private void otpmove()
    {
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

}