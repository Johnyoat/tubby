package com.litetech.tuby.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.litetech.tuby.R;
import com.litetech.tuby.utils.UICreator;

public class MainActivity extends AppCompatActivity {
    private UICreator creator;
    private SearchView searchView;
    private LinearLayout innerToolbar;
    private AppCompatImageView search;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bnv);
        creator = UICreator.getInstance(this);


        search = findViewById(R.id.search);
        innerToolbar = findViewById(R.id.innerToolbar);
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.toolbarSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
                searchView.setVisibility(View.VISIBLE);
                innerToolbar.setVisibility(View.GONE);
                toolbar.setElevation(4);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                innerToolbar.setVisibility(View.VISIBLE);
                searchView.setVisibility(View.GONE);
                toolbar.setElevation(0);
                return false;
            }
        });

        creator.createFragment(Home.newInstance(), "home");
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId = item.getItemId();

                switch (menuId) {
                    case R.id.home:
                        creator.createFragment(Home.newInstance(), "home");
                        break;
                    case R.id.downloads:
                        creator.createFragment(Downloads.newInstance(), "downloads");
                        break;
                    case R.id.notifications:
                        creator.createFragment(Notifications.newInstance(), "notifications");
                        break;
                    case R.id.account:
                        creator.createFragment(Account.newInstance(), "account");
                        break;
                }
                return true;
            }
        });

    }
}
