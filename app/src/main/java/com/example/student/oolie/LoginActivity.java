package com.example.student.oolie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class    LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonCreateAccount;
    String emailtxt, passwordtxt;
    String login_url = "http://10.0.0.50:3000/signUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);


        buttonCreateAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent regactivity = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(regactivity);
                finish();
            }
        }); // Create Account Action End

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                emailtxt = editTextEmail.getText().toString();
                passwordtxt = editTextPassword.getText().toString();
                //POST Parameters
                Map<String,String> params = new HashMap<String, String>();
                params.put("email",emailtxt);
                params.put("password",passwordtxt);
                //Request a JSON response from the login_url
                JSONObject userDetails = new JSONObject(params);
                Log.d("UserLoginInfo",userDetails.toString());
                ConnectToServer();

            }
        });
    }

    private void ConnectToServer(){
        emailtxt = editTextEmail.getText().toString();
        passwordtxt = editTextPassword.getText().toString();
        //POST Parameters
        Map<String,String> params = new HashMap<String, String>();
        params.put("email",emailtxt);
        params.put("password",passwordtxt);
        //Request a JSON response from the login_url
        JSONObject userDetails = new JSONObject(params);
        Log.d("UserLoginInfo",userDetails.toString());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, login_url, userDetails,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), response.toString(),Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        MySingleton.getInstance(LoginActivity.this).addToRequestqueue(jsonObjectRequest);

    }
}