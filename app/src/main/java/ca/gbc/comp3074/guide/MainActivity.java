package ca.gbc.comp3074.guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter placeAdapter;
    private ArrayList<Place> placesData = new ArrayList<Place>();
    private EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        placesData.add(new Place(1,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008","good",5));
        placesData.add(new Place(2,"Durbar Indian Cuisine"," 2469 Bloor St W, Toronto, ON M6S 1P7","Indian Cuisine", "(416) 762-4441","so so",4));
        placesData.add(new Place(3,"Mai Bistro"," 4906 Dundas St W, Etobicoke, ON M9A 1B5","Italian", "(647) 343-3130","normal",3));
        placesData.add(new Place(4,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008","normal",3));
        placesData.add(new Place(5,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008","normal",3));
        placesData.add(new Place(6,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008","normal",3));
        placesData.add(new Place(7,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Italian", "(416) 239-2008","normal",3));


        placeAdapter = new PlacesAdapter(placesData);
        ((PlacesAdapter)placeAdapter).setPlacesActivity(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(placeAdapter);
        recyclerView.setLayoutManager(layoutManager);
        search = findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text){
        ArrayList<Place> filteredList = new ArrayList<>();

        for (Place place : placesData){
            if(place.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(place);
            }
        }
        placeAdapter.filterList(filteredList);
    }

    public void navigateToDetailPlace(Integer position){
        Intent intent = new Intent(MainActivity.this, DetailPlaceActivity.class);
        Place selectedPlace = placesData.get(position);
        intent.putExtra("selectedPlace", selectedPlace);
        startActivity(intent);
        DetailPlaceActivity.placesActivity=this;
    }
    public void deletePlace(Integer placeId){
        placesData.removeIf(place -> place.getPlaceId().equals(placeId));
        placeAdapter.notifyDataSetChanged();
        }
    public void editPlace(Place editPlace){
        placesData.forEach(place -> {
            if(place.getPlaceId().equals(editPlace.getPlaceId())){
                place.setName(editPlace.getName());
                place.setAddress(editPlace.getAddress());
                place.setDescription(editPlace.getDescription());
                place.setPhone(editPlace.getPhone());
                place.setTag(editPlace.getTag());
                place.setRating(editPlace.getRating());
            }
        });
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