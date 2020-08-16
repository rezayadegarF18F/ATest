package com.reza.yadegar.stest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //
    MaterialToolbar main_activity_toolbar;
    RecyclerView c_recycler_view;

    C_item_adapter adapter;
    ArrayList<item_detail> show_list = new ArrayList<>();

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //plug component
        drawer = findViewById(R.id.Main_activity_nav_drawer);
        main_activity_toolbar = findViewById(R.id.Main_activity_toolbar);
        c_recycler_view = findViewById(R.id.C_recycler_view);
        //------------------------------------------------------------------------------------------

        setSupportActionBar(main_activity_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, main_activity_toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        //
        int[] drawable_array1 = new int[]{
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
                R.drawable.pic9,
                R.drawable.pic10,
        };

        for(int i=0; i<10 ; i++)
        {
            show_list.add(new item_detail("عنوان " + i, "زیر عنوان " + i, drawable_array1[i], drawable_array1[i]));
        }
        //------------------------------------------------------------------------------------------


        adapter = new C_item_adapter(MainActivity.this, MainActivity.this, show_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        c_recycler_view.setLayoutManager(layoutManager);

        c_recycler_view.setItemAnimator(new DefaultItemAnimator());

        c_recycler_view.setNestedScrollingEnabled(false);
        c_recycler_view.setHasFixedSize(true);
        c_recycler_view.setItemViewCacheSize(10);

        c_recycler_view.setDrawingCacheEnabled(true);
        c_recycler_view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        c_recycler_view.setAdapter(adapter);
        registerForContextMenu(c_recycler_view);
        //-----------------------------------------------------------------------------------------

    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_toolbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Exit_item)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}