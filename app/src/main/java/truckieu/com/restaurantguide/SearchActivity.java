package truckieu.com.restaurantguide;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] restaurantNameList;
    ArrayList<RestaurantNames> arraylist = new ArrayList<RestaurantNames>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate sample data

        restaurantNameList = new String[]{"KFC", "Teddy Story", "Cresent",
                "Sheridan", "Pour House", "168 Sushi", "Mimi Chicken"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < restaurantNameList.length; i++) {
            RestaurantNames restaurantNames = new RestaurantNames(restaurantNameList[i]);
            // Binds all strings into an array
            arraylist.add(restaurantNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
