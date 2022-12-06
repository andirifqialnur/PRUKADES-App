package com.aran.prukades_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminRegistrasi extends AppCompatActivity {

    TextView id_loginadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registrasi);

        id_loginadmin = findViewById(R.id.id_loginadmin);

        id_loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminRegistrasi.this, AdminLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}