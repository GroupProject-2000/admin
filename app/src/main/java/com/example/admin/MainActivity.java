package com.example.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.admin.Fragment.PartnerFragment;
import com.example.admin.Fragment.StatisticalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new PartnerFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_khoanthu:
                            selectedFragment = new PartnerFragment();
                            break;

                        case R.id.nav_loaithu:
                            selectedFragment = new StatisticalFragment();
                            break;
                    }

                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                            selectedFragment).commit();
                    return true;
                }
            };
}
