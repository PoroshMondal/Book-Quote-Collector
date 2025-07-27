package com.bqc.somvob.bookquotecollector;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.bqc.somvob.bookquotecollector.databinding.ActivityMainBinding;
import com.bqc.somvob.bookquotecollector.ui.Home;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    //private NavController navController;

    private QuoteViewModel quoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quoteViewModel = new ViewModelProvider(this).get(QuoteViewModel.class);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_collections){
                    navigateToFragmentIfNotCurrent(R.id.home_main);
                    Toast.makeText(MainActivity.this,"Collections",Toast.LENGTH_SHORT).show();
                }else if (item.getItemId()==R.id.nav_fav){
                    navigateToFragmentIfNotCurrent(R.id.home_main);
                    Toast.makeText(MainActivity.this,"Fav",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /*NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fav);
        navController = navHostFragment.getNavController();
        // Connect BottomNavigationView with NavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController);*/

    }

    private void navigateToFragmentIfNotCurrent(int fragmentId) {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_content_main); // your NavHostFragment ID

        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavDestination currentDestination = navController.getCurrentDestination();

            if (currentDestination != null && currentDestination.getId() != fragmentId) {
                navController.navigate(fragmentId);
            } else {
                Log.d("Navigation", "Already on the target fragment.");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search) {
            Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menu_settings) {
            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menu_exit) {
            Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}