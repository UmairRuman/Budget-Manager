package com.project.budgetmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPageActivity extends AppCompatActivity {
    String emailFormat = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    TextView tvCreateNewAccount,tvForgotPassword;
    EditText etLoginEmail,etLoginPassword;
    Button btnLogin;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        btnLogin = findViewById(R.id.btnLogin);
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        tvCreateNewAccount = findViewById(R.id.tvNewAccount);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        //Above we make a class level variable and fetch instance of FireBaseAuthentication and assign it to variable
        //For getting this class we have to add dependencies of FireBAse Authentication
        firebaseAuth = FirebaseAuth.getInstance();
        //Above we also make a variable of FireBaseUSer and get current user from fireBase Authentication
        firebaseUser = firebaseAuth.getCurrentUser();

        progressDialog = new ProgressDialog(this);

        tvCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I have make a method below that send intent to sign up activity when user clicked on create new account
                sendIntentToSignUpActivity();

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I have make a method below to login from the saved users email and password in firebase
                performLogin();
            }
        });

    }

    private void performLogin() {
        //Getting text from editText and storing in Strings
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        //Below are the few descriptive conditions
        if (!email.matches(emailFormat)) {
            etLoginEmail.setError("Please enter the valid Email");
        } else if (password.isEmpty() || password.length() < 8) {
            etLoginPassword.setError("Enter 8 digit Password");
        }
        else {
            // if all the input fields are correctly filled then this block of code will execute
            progressDialog.setMessage("PLease wait while Login...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            //The method i call below which checked and match email and password from users of dataBase and login to my app
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(LoginPageActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(LoginPageActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendIntentToSignUpActivity() {
        Intent intent = new Intent(LoginPageActivity.this, SignUpActivity.class);
        // Now we have to set Flags because when user successfully registered , he never came back to this activity again
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(LoginPageActivity.this, MainActivity.class);
        // Now we have to set Flags because when user successfully registered , he never came back to this activity again
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}