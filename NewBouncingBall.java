package com.example.newbouncingball;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.newbouncingball.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBall;
    Handler handler = new Handler();
    int direction = 1;
    int directionY = 2;
    float x = 0;
    float y = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBall = findViewById(R.id.btn_ball);
    }
    public void move(View v) {
        handler.postDelayed(moveBallRunnable, 20);
    }
    Runnable moveBallRunnable = new Runnable() {
        @Override
        public void run() {
            x += 10 * direction;
            y += 10 *directionY;
            if (x > 800) direction = -1;
            if (x < 0) direction = 1;

            if(y > 1200) directionY = -1;
            if(x < 0) directionY = 1;

            btnBall.setTranslationX(x);
            btnBall.setTranslationY(y);
            handler.postDelayed(this, 20);
        }
    };
}
