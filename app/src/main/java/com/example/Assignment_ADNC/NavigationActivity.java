package com.example.Assignment_ADNC;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.Assignment_ADNC.fargment.KhoahocFragment;
import com.example.Assignment_ADNC.fargment.MapsFragment;
import com.example.Assignment_ADNC.fargment.NewsFragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        navigationView = findViewById(R.id.nv_view);
        navigationView.setItemIconTintList(null);

        mDrawerLayout = findViewById(R.id.dr_ly);
        toolbar = findViewById(R.id.tg_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerToggle = setupDrawerToggle();
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_khoahoc);
            getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new KhoahocFragment()).commit();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Class fragmentClass = null;
                //
                switch (item.getItemId()) {
                    case R.id.nav_khoahoc:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new KhoahocFragment()).commit();
                        break;
                    case R.id.nav_maps:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new MapsFragment()).commit();
                        break;
                    case R.id.nav_news:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new NewsFragment()).commit();
                        break;
                    case R.id.nav_gioithieu:
                        Toast.makeText(NavigationActivity.this, "Giới thiệu!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_thoat:
                        finish();
                        break;
                    default:
                        fragmentClass = KhoahocFragment.class;
                }

                item.setChecked(true);
                setTitle(item.getTitle());
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(NavigationActivity.this, mDrawerLayout, toolbar, R.string.open, R.string.close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
