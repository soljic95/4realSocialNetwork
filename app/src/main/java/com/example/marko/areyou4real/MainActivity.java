package com.example.marko.areyou4real;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.marko.areyou4real.fragments.GroupsFragment;
import com.example.marko.areyou4real.fragments.Home;
import com.example.marko.areyou4real.fragments.adapter.SectionPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    SectionPagerAdapter mPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mPageAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.container);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.profileMenu) {
            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "going to UserProfile", Toast.LENGTH_SHORT).show();

            return false;
        } else if (item.getItemId() == R.id.about4real) {
            Toast.makeText(MainActivity.this, "nismo jos ovaj acc napravili", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menuSignOut) {
            signOut();
        }


        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home(), "Home");
        adapter.addFragment(new GroupsFragment(), "GroupsFragment");
        viewPager.setAdapter(adapter);
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "signing out", Toast.LENGTH_SHORT).show();
    }
}
