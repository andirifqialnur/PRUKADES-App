package com.aran.prukades_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {

    TextView id_registeradmin;
    AppCompatButton id_btnadminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        id_registeradmin = findViewById(R.id.id_registeradmin);
        id_btnadminlogin = findViewById(R.id.id_btnadminlogin);

        id_registeradmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminLogin.this, AdminRegistrasi.class);
                startActivity(intent);
                finish();
            }
        });

        id_btnadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminLogin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}