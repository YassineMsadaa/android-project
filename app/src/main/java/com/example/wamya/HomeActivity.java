package com.example.wamya;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set up the toolbar
        ImageButton notificationButton = findViewById(R.id.notificationButton);
        ImageButton userButton = findViewById(R.id.userButton);
        TopBarHandler topBarHandler = new TopBarHandler(this);
        topBarHandler.setupNotificationButton(notificationButton);
        topBarHandler.setupUserButton(userButton);
    }





    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
