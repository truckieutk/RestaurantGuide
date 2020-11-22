package ca.gbc.comp3074.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    private TextView  name1,name2,name3,name4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        name1 =findViewById(R.id.name1);
        name2 =findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
    }
    private void Search(){
        Intent start = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(start);
    }
    private void AddActivity(){
        Intent start = new Intent(getApplicationContext(),AddActivity.class);
        startActivity(start);
    }
    private void Home(){
        Intent start = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.home:
                Home();
                break;
            case R.id.add:
                AddActivity();
                break;
            case R.id.search:
                Search();
                break;
            case R.id.view:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
