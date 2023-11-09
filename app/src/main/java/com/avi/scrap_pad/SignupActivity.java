package com.avi.scrap_pad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avi.scrap_pad.R;

public class SignupActivity extends AppCompatActivity {

    private TextView txtwantlogin;
    private RelativeLayout btnsignup;
    EditText etemail, etpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtwantlogin = findViewById(R.id.txtwantologin);
        etemail = findViewById(R.id.signupEmail);
        etpswd = findViewById(R.id.signupPassword);
        btnsignup = findViewById(R.id.btnSignup);

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
                } else {
                    // Successfully message
                    Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}