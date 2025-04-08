package com.example.indentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.indentdemo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivy(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    } public void openGoogle(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }
    public void sendMain(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // Ensures only email apps handle it
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tamilscientist2004@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi just subject");
        intent.putExtra(Intent.EXTRA_TEXT, "A message to send via email");

        try {
            startActivity(Intent.createChooser(intent, "Choose an email client:"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(v.getContext(), "No email client installed!", Toast.LENGTH_SHORT).show();
        }
    }
}
