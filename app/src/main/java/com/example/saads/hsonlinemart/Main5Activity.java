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

public class Main5Activity extends AppCompatActivity {

    TextView alreadymember;

    ProgressDialog progressDialog;
    EditText usernametxt;
    EditText passwordtxt;

    String usernamest="",passwordst="";
    private boolean CustomerEmptyfields;

    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        usernametxt=findViewById(R.id.username);
        passwordtxt=findViewById(R.id.password);

        progressDialog = new ProgressDialog(Main5Activity.this);

        this.setTitle("Mart Admin Signup");

        alreadymember=(TextView)findViewById(R.id.textView);
        alreadymember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main5Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        signup=(Button)findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
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
        Intent intent=new Intent(Main5Activity.this,Main3Activity.class);
        startActivity(intent);
    }
}
