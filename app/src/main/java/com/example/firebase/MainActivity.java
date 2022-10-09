package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText Name,Email,Password;
    Button next;
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        next = findViewById(R.id.next);
        Auth =  FirebaseAuth.getInstance();

        if(Auth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        next.setOnClickListener(v -> {
            String email = Email.getText().toString().trim();
            String pass = Password.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                Email.setError("Enter Email!");
                return;
            }

            if(TextUtils.isEmpty(pass)){
                Password.setError("Enter Password!");
                return;
            }

            if(pass.length() < 8){
                Password.setError("Please Enter 8 Character Password !");
                return;
            }


            Auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Error "+ task.getException().getMessage()+ "!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        });
        next=(Button) findViewById(R.id.next);
        next.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,Phone.class);
            startActivity(i);
        });
    }
}