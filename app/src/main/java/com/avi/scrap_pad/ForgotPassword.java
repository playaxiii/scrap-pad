package com.avi.scrap_pad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private Button btnRecover;
    private TextView txtforpsd, taglienforpswd, txtgotologin;
    private EditText etinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnRecover = findViewById(R.id.btnRecovery);
        txtgotologin = findViewById(R.id.txtgotologinscreen);
        etinput = findViewById(R.id.etforgotPswd);

        txtgotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate to login screen
                Intent intent = new Intent(ForgotPassword.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if email is empty
                String email = etinput.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your email first", Toast.LENGTH_SHORT).show();
                } else {
                    // we have to send
                }
            }
        });
    }
}