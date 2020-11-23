package ca.gbc.comp3074.guide;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return  true;
    }
    private void Home(){
        Intent start = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(start);
    }
    private void About(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    private void Add() {
        Intent start = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.home:
                Home();
                break;
            case R.id.add:
                Add();
                break;
            case R.id.about:
                About();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


