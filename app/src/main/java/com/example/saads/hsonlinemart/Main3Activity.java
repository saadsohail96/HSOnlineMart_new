package com.example.saads.hsonlinemart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView noaccount;

    ProgressDialog progressDialog;
    EditText usernametxt;
    EditText passwordtxt;

    String usernamest="",passwordst="";
    private boolean CustomerEmptyfields;

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        usernametxt=findViewById(R.id.username);
        passwordtxt=findViewById(R.id.password);

        progressDialog = new ProgressDialog(Main3Activity.this);

        this.setTitle("Mart Admin Login");

        noaccount=(TextView)findViewById(R.id.textView);
        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

        login=(Button)findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkemptyfields();
            }
        });
    }

    private void checkemptyfields() {
        usernamest = usernametxt.getText().toString();
        passwordst = passwordtxt.getText().toString();
        if (TextUtils.isEmpty(usernamest) || TextUtils.isEmpty(passwordst))

        {
            CustomerEmptyfields = true;

            if (usernamest.isEmpty()) {
                usernametxt.setError("Enter the Username");

            }

            if (passwordst.isEmpty()) {
                passwordtxt.setError("Enter the Password");

            }
        }
        else
        {
            CustomerEmptyfields = false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
