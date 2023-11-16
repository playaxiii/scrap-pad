package com.avi.scrap_pad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avi.scrap_pad.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private TextView txtwantlogin;
    private RelativeLayout btnsignup;
    EditText etemail, etpswd;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtwantlogin = findViewById(R.id.txtwantologin);
        etemail = findViewById(R.id.signupEmail);
        etpswd = findViewById(R.id.signupPassword);
        btnsignup = findViewById(R.id.btnSignup);

        firebaseAuth = FirebaseAuth.getInstance();

        txtwantlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etemail.getText().toString().trim();
                String pswd = etpswd.getText().toString().trim();

                if (email.isEmpty() || pswd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All field required", Toast.LENGTH_SHORT).show();
                } else if (pswd.length() < 7) {
                    // Successfully message
                    Toast.makeText(getApplicationContext(), "Password should greater than 7 digits", Toast.LENGTH_SHORT).show();
                } else {
                    //registered the user to firebase
                    firebaseAuth.createUserWithEmailAndPassword(email, pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registeration succesfully", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            } else {
                                Toast.makeText(getApplicationContext(), "Registeration Failed", Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            }
                        }
                    });
                }
            }
        });

    }

    //send email verification
    private void sendEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Verificationn email is sent, verify and login", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Failed to send email verification", Toast.LENGTH_SHORT).show();
        }
    }
}