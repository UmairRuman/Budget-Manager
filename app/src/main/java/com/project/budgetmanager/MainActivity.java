package com.project.budgetmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FloatingActionButton btnNewCatalog;
    Fragment profileFragment = new ProfileFragment();
    Fragment savingFragment = new SavingFragment();
    Fragment sharingFragment = new SharingFragment();
    Fragment spendingFragment = new SpendFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        btnNewCatalog = findViewById(R.id.btnNewCatalog);
        bottomNavigationView.setBackground(null);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,spendingFragment).setReorderingAllowed(true).commit();

//        Bottom Navigation items Click Listeners should implement below
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menuProfile){
                   openFragment(profileFragment);
                }
                else if(item.getItemId() == R.id.menuSaving){
                    openFragment(savingFragment);
                }
                else if(item.getItemId() == R.id.menuSharing){
                    openFragment(sharingFragment);
                }
                else if (item.getItemId() == R.id.menuSpend){
                    openFragment(spendingFragment);
                }
                return true;
            }
        });

        // intent to start catalog Activity
        Intent catalogActivityIntent = new Intent(MainActivity.this,CatalogActivity.class);
        btnNewCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                startActivity(catalogActivityIntent);
            }
        });

    }

    // function to load fragment in fragment container view
    public void openFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).setReorderingAllowed(true).commit();
    }

}
