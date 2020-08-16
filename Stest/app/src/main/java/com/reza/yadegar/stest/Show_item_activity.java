package com.reza.yadegar.stest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Show_item_activity extends AppCompatActivity
{
    MaterialToolbar toolbar;
    CircleImageView image_show_img;
    MaterialTextView title_show_txt, sub_title_show_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        //
        toolbar = findViewById(R.id.Show_item_activity_toolbar);
        image_show_img = findViewById(R.id.Image_show_img);
        title_show_txt = findViewById(R.id.Title_show_txt);
        sub_title_show_txt = findViewById(R.id.Sub_title_show_txt);
        //------------------------------------------------------------------------------------------

        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        image_show_img.setImageResource(intent.getIntExtra("IMAGE", R.drawable.ic_error_black_24dp));
        title_show_txt.setText(intent.getStringExtra("TITLE"));
        sub_title_show_txt.setText(intent.getStringExtra("SUBTITLE"));

    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.show_item_activity_toolbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Back_item)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}