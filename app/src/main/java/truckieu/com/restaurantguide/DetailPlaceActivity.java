package truckieu.com.restaurantguide;

import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPlaceActivity extends Activity {

    private Place selectedPlace;
    private TextView name, address, phone, description, tag, rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        selectedPlace = (Place)getIntent().getExtras().getSerializable("selectedPlace");
        Toast.makeText(this,selectedPlace.toString(), Toast.LENGTH_LONG).show();

        name = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        phone = (TextView) findViewById(R.id.phone);
        description = (TextView) findViewById(R.id.description);
        tag= (TextView) findViewById(R.id.tag);
        rating= (TextView) findViewById(R.id.rating);

        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());
        rating.setText(selectedPlace.getRating());
    }
}
