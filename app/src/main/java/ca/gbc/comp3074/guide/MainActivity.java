package ca.gbc.comp3074.guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter placeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        ArrayList<Place> placesData = new ArrayList<Place>();
        placesData.add(new Place("Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008"));
        placesData.add(new Place("Durbar Indian Cuisine"," 2469 Bloor St W, Toronto, ON M6S 1P7","Indian Cuisine", "(416) 762-4441"));
        placesData.add(new Place("Mai Bistro"," 4906 Dundas St W, Etobicoke, ON M9A 1B5","Italian", "(647) 343-3130"));
        placesData.add(new Place("Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008"));
        placesData.add(new Place("Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008"));
        placesData.add(new Place("Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008"));
        placesData.add(new Place("Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008"));


        placeAdapter = new PlacesAdapter(placesData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(placeAdapter);
        recyclerView.setLayoutManager(layoutManager);
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
    private void About(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }
}