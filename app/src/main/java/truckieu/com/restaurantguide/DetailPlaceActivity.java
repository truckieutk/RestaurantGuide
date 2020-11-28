package truckieu.com.restaurantguide;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class DetailPlaceActivity extends Activity {

    public static MainActivity placesActivity;
    private Place selectedPlace;
    private TextView name, address, phone, description, tag, rating;
    private Button delete;

    public void setSelectedPlace(Place selectedPlace) {
        this.selectedPlace = selectedPlace;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        selectedPlace = (Place) getIntent().getExtras().getSerializable("selectedPlace");

        name = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        phone = (TextView) findViewById(R.id.phone);
        description = (TextView) findViewById(R.id.description);
        tag = (TextView) findViewById(R.id.tag);
        rating = (TextView) findViewById(R.id.rating);
        delete = findViewById(R.id.delete);

        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());
        rating.setText(selectedPlace.getRating());

        setupActions();

    }

    private void actionUpdatePlace() {
        //Show EditDialog
        EditPlaceDialog editPlaceDialog = new EditPlaceDialog(this,
                DetailPlaceActivity.placesActivity,
                selectedPlace,
                R.layout.edit_place,
                this);
        editPlaceDialog.show();

    }

    // Delete a place and alert message
    private void setupActions() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Message show to get confirm deletion from the user
                new AlertDialog.Builder(DetailPlaceActivity.this)
                        .setTitle("Delete a place")
                        .setMessage("Are you sure you want to delete this ?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //When click "Yes"
                                DetailPlaceActivity.this.placesActivity.deletePlace(selectedPlace.getPlaceId());
                                finish();
                            }
                        }).
                        setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //When click "No", it will turn back to the previous screen
                                finish();
                            }
                        }).show();
            }
        });

        //Update information for each field
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdatePlace();
            }
        });

    }
}
