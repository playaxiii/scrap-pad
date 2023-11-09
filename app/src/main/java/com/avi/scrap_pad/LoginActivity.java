package com.avi.scrap_pad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avi.scrap_pad.R;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout gotosignup;
    private EditText enteremail, enterpswd;
    private TextView txtforgot;
    private RelativeLayout btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gotosignup = findViewById(R.id.btnNewUser);
        txtforgot = findViewById(R.id.txtforgotpswdlogin);
        enteremail = findViewById(R.id.loginemail);
        enterpswd = findViewById(R.id.loginPassword);
        btnlogin = findViewById(R.id.btnlogin);

        txtforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if email is empty
                String email = enteremail.getText().toString().trim();
                String pswd = enterpswd.getText().toString().trim();

                if (email.isEmpty() || pswd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All field are required", Toast.LENGTH_SHORT).show();
                } else {
                    // we have to send
                }
            }
        });
    }
}