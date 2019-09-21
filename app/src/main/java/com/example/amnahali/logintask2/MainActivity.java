package com.example.amnahali.logintask2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;
    CheckBox check;
    public TextView userName;
    public SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.mainToolBar);
        setSupportActionBar(toolBar);
        prefs = getSharedPreferences("pref",Context. MODE_PRIVATE);
        userName = findViewById(R.id.userName);
        showDialogFragment();

    }

    private void showDialogFragment() {
        String name = prefs.getString("key", String.valueOf(""));

        if(!name.equals("admin")) {
            LoginFragment loginFragment = new LoginFragment();

            loginFragment.show(getSupportFragmentManager(), null);

        }

        userName.setText(name);
    }
}