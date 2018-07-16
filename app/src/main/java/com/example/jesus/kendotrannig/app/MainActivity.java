package com.example.jesus.kendotrannig.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.model.Treino;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private TextView userNameText, emailText;
    private ImageView userImage;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("dados.file", MODE_PRIVATE);
        editor = preferences.edit();
        setupViews();
        setupDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.singout:
                startActivity(new Intent(this, LoginActivity.class));
                editor.clear();
                editor.apply();
                finish();
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        userNameText = navigationView.getHeaderView(0).findViewById(R.id.username_perfil);
        emailText = navigationView.getHeaderView(0).findViewById(R.id.email_perfil);
        userImage = navigationView.getHeaderView(0).findViewById(R.id.image_perfil);
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        userNameText.setText(preferences.getString("userName","invalido"));
        emailText.setText(preferences.getString("userEmail","invalido"));
        Glide.with(this)
                .load(preferences.getString("userImageUrl","https://firebasestorage.googleapis.com/v0/b/kendo-tranning.appspot.com/o/icon_not_found.png?alt=media&token=7ef72b7c-e316-4d8f-8fa0-5c0e119ec94a"))
                .into(userImage);
    }

    public void irParaTreinos(View view) {
        startActivity(new Intent(this, TreinoActivity.class));
    }

    public void irParaExercicios(View view) {
        startActivity(new Intent(this, ExerciciosActivity.class));
    }
}
