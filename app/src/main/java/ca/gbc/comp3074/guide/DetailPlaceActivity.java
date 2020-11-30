package ca.gbc.comp3074.guide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailPlaceActivity extends Activity {
    public static MainActivity placesActivity;

    public void setSelectedPlace(Place selectedPlace) {
        this.selectedPlace = selectedPlace;
        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());

    }

    private Place selectedPlace;
    private TextView name,address,phone,tag,description;
    private RatingBar ratingBar;
    private Button edit,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);
        selectedPlace = (Place) getIntent().getExtras().getSerializable("selectedPlace");
        name = findViewById(R.id.txtname);
        address = findViewById(R.id.txtaddress);
        description = findViewById(R.id.txtdescription);
        tag = findViewById(R.id.txttag);
        phone = findViewById(R.id.txtphone);
        ratingBar = findViewById(R.id.rating);
        edit = findViewById(R.id.btnedit);
        delete = findViewById(R.id.btndelete);
        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());
        ratingBar.setRating(selectedPlace.getRating());
        setupAction();
    }
    private void actionEditPlace(){
        EditPlaceDialog editPlaceDialog = new EditPlaceDialog(this,
                DetailPlaceActivity.placesActivity,
                this,
                selectedPlace,
                R.layout.edit_layout);
        editPlaceDialog.show();

    }
    private void setupAction(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DetailPlaceActivity.this)
                        .setTitle("Delete a place")
                        .setMessage("Are you sure want to delete this?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DetailPlaceActivity.this.placesActivity.deletePlace(selectedPlace.getPlaceId());
                                finish();
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEditPlace();
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEditPlace();
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEditPlace();
            }
        });
        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEditPlace();
            }
        });
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionEditPlace();
            }
        });
    }

}