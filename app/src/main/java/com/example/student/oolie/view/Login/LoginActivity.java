package com.example.student.oolie.view.Login;

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
import com.example.student.oolie.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.facebook.FacebookSdk.getApplicationContext;

public class    LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonCreateAccount;
    LoginButton login_fb;
    String emailtxt, passwordtxt;
    String login_url = "http://10.0.0.50:3000/signUp";
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        connectWithFacebook();

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
        });

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
    private void connectWithFacebook(){
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                nextActivity(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        login_fb = (LoginButton)findViewById(R.id.login_fb);
        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                nextActivity(profile);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        };
        login_fb.setReadPermissions("user_friends");
        login_fb.registerCallback(callbackManager, callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Facebook login
        Profile profile = Profile.getCurrentProfile();
        nextActivity(profile);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        //Facebook login
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);

    }

    private void nextActivity(Profile profile){
        if(profile != null){
            Intent socialLoginActivity = new Intent(LoginActivity.this, SocialLoginActivity.class);
            socialLoginActivity.putExtra("name", profile.getFirstName());
            socialLoginActivity.putExtra("surname", profile.getLastName());
            socialLoginActivity.putExtra("imageUrl", profile.getProfilePictureUri(200,200).toString());
            startActivity(socialLoginActivity);
        }
    }


}

