package com.project.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUserName,etPassword;
    TextView tvSignUp;
    Button btnSignIn;
    ImageView ivGoogle,ivFaceBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);
        tvSignUp=findViewById(R.id.tvSignUp);
        btnSignIn=findViewById(R.id.btnSign);
        ivGoogle=findViewById(R.id.ivGoogle);
        ivFaceBook=findViewById(R.id.ivFacebook);

        //Login Button Click
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "your Account is Sign In", Toast.LENGTH_SHORT).show();
            }
        });

        //Sign Up Click
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Sign UP is AvailAble", Toast.LENGTH_SHORT).show();
            }
        });

        //Google Image Click
        ivGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Google Page iS here", Toast.LENGTH_SHORT).show();
            }
        });

        //FaceBookImage Click
        ivFaceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "FaceBook page is here", Toast.LENGTH_SHORT).show();
            }
        });
    }
}