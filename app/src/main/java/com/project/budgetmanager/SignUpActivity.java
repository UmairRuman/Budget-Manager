package com.project.budgetmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignUpActivity extends AppCompatActivity {
    // I have make a email format for recognizing valid email Address
    String emailFormat = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    EditText etRegistrationPassword,etRegistrationConfirmPassword,etRegistrationEmail;
    TextView tvAlreadyHaveAnAccount;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    ProgressDialog progressDialog;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnRegister = findViewById(R.id.btnRegister);
        tvAlreadyHaveAnAccount = findViewById(R.id.tvAlreadyHaveAnAccount);
        etRegistrationEmail = findViewById(R.id.etEmailRegistration);
        etRegistrationPassword = findViewById(R.id.etPasswordRegistration);
        etRegistrationConfirmPassword =findViewById(R.id.etConfirmPasswordRegistration);
        progressDialog = new ProgressDialog(this);

        //Above we make a class level variable and fetch instance of FireBaseAuthentication and assign it to variable
        //For getting this class we have to add dependencies of FireBAse Authentication
        firebaseAuth = FirebaseAuth.getInstance();
        //Above we also make a variable of FireBaseUSer and get current user from fireBase Authentication
        firebaseUser = firebaseAuth.getCurrentUser();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //I have make a method below to perform authentication on Button Register
                performAuthentication();
            }
        });
        tvAlreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When someOne Clicked on Text View already hava an account , it will send intent to loginActivity
                sendIntentToLogin();
            }
        });
    }

    private void sendIntentToLogin() {
        Intent intent = new Intent(SignUpActivity.this, LoginPageActivity.class);
        // Now we have to set Flags because when user successfully registered , he never came back to this activity again
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    private void performAuthentication() {
        //Getting text from editText and storing in Strings
        String email = etRegistrationEmail.getText().toString();
        String password = etRegistrationPassword.getText().toString();
        String confirmPassword = etRegistrationConfirmPassword.getText().toString();
        //Below are the few descriptive conditions
        if (!email.matches(emailFormat)) {
            etRegistrationEmail.setError("Please enter the valid Email");
        } else if (password.isEmpty() || password.length() < 8) {
            etRegistrationPassword.setError("Enter 8 digit Password");
        } else if (!password.equals(confirmPassword)) {
            etRegistrationConfirmPassword.setError("Both the password fields don't match");
        }else {
            // if all the input fields are correctly filled then this block of code will execute
            progressDialog.setMessage("PLease wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            //The method i call below which save user email and password in FireBase Authentication users
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        //If the task is successful then we have to dismiss dialog and show user the main interface of our app
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        // Now we have to set Flags because when user successfully registered , he never came back to this activity again
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}