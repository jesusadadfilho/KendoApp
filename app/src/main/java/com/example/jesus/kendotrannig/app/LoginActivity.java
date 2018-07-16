package com.example.jesus.kendotrannig.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jesus.kendotrannig.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.Authenticator;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private SignInButton signInButton;
    private GoogleApiClient mGoogleApiClient;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    private static final String TAG = "signInActivity";
    private static final int RC_SIGN_IN = 9001;
    private static final int SIGIN_IN_CODE = 777;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("dados.file", Context.MODE_PRIVATE);
        editor = preferences.edit();
        setupViews();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN || requestCode == SIGIN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectFalied: " + connectionResult);
        Toast.makeText(this,"Falha ao logar",Toast.LENGTH_SHORT);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "onConnectFalied: " + result.isSuccess());
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            editor.putString("userName", account.getDisplayName());
            editor.putString("userImageUrl", account.getPhotoUrl().toString());
            editor.putString("userEmail", account.getEmail());
            editor.putString("userId", account.getId());
            editor.apply();
            Toast.makeText(this, "Bem vindo : " + account.getDisplayName() +"!" ,Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();


        }
    }

    private void setupViews() {
        signInButton = findViewById(R.id.singin_button);
    }

    public void singIn(View view) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void teste(View view){
        Toast.makeText(this, "Clicando" ,Toast.LENGTH_LONG).show();
    }
}
