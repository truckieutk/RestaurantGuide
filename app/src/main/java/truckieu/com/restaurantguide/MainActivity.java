package truckieu.com.restaurantguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter placeAdapter;
    private SearchView searchView;

    private ArrayList<Place> placesData = new ArrayList<Place>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        searchView = findViewById(R.id.search);
        placesData.add(new Place(1,"Trattoria Leonardo"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Reasonable Price", "(416) 239-2008","Vegetarian", 4));
        placesData.add(new Place(2,"Durbar Indian Cuisine"," 2469 Bloor St W, Toronto, ON M6S 1P7","Good curry", "(416) 762-4441","Asian Cuisine",3));
        placesData.add(new Place(3,"Mai Bistro"," 4906 Dundas St W, Etobicoke, ON M9A 1B5","Having patio and LCBO", "(647) 343-3130","BBQ",4));
        placesData.add(new Place(4,"Pour House"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","LCBO and fries is good", "(416) 239-2008","Drinks",5));
        placesData.add(new Place(5,"MiMi Chicken"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Good garlic honey chicken", "(416) 239-2008","Asian Cuisine",4));
        placesData.add(new Place(6,"Teddy Story"," 4740 Dundas St W, Etobicoke, ON M9A 1A9","Can buy Teddy bear and coffee", "(416) 239-2008","Dessert",4));


        placeAdapter = new PlacesAdapter(placesData);
        ((PlacesAdapter)placeAdapter).setPlacesActivity(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(placeAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void navigateToDetailPlace(Integer position){
        Intent intent = new Intent(MainActivity.this, DetailPlaceActivity.class);
        Place selectedPlace = placesData.get(position);
        intent.putExtra("selectedPlace", selectedPlace);
        startActivity(intent);
        DetailPlaceActivity.placesActivity=this;
    }

    @SuppressLint("NewApi")
    public void deletePlace(final Integer placeId) {
        //removeIf is a Lambda method using arrow, return true false
        placesData.removeIf(place -> place.getPlaceId().equals(placeId));
        placeAdapter.notifyDataSetChanged();
    }

    @SuppressLint("NewApi")
    public void editPlace(Place editPlace) {
        //loop through each element in the array to see if any of it match with the ID we find
        placesData.forEach(place -> {
            if(place.getPlaceId().equals(editPlace.getPlaceId())){
                //if matched, then update
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