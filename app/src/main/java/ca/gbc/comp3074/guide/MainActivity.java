package ca.gbc.comp3074.guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.home:
                break;
            case R.id.add:
                AddActivity();
                break;
            case R.id.search:
                Search();
                break;
            case R.id.about:
                About();
                break;
        }
        return super .onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contexts_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.edit:
                break;
            case R.id.delete:
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void AddActivity(){
        Intent start = new Intent(getApplicationContext(),AddActivity.class);
        startActivity(start);
    }
    private void Search() {
        Intent start = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(start);
    }
    private void About(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }
}