package truckieu.com.restaurantguide;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.annotation.RequiresApi;

public class EditPlaceDialog extends Dialog {
    private MainActivity placesActivity;
    private DetailPlaceActivity detailPlaceActivity;
    private Place selectedPlace;
    //UI
    private EditText name,address,phone, description;
    private AutoCompleteTextView tag;
    private RatingBar rating;
    private Button save;

    EditPlaceDialog(Context context, MainActivity placesActivity,
                    Place selectedPlace, int layoutResId, DetailPlaceActivity detailPlaceActivity) {
        super(context);
        this.placesActivity = placesActivity;
        this.selectedPlace = selectedPlace;
        this.detailPlaceActivity = detailPlaceActivity;
        this.setContentView(layoutResId);
        setupUI();
    }
    private void setupUI() {
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        description = (EditText) findViewById(R.id.description);
        tag = (AutoCompleteTextView) findViewById(R.id.tag);
        rating = (RatingBar) findViewById(R.id.rating);
        save = (Button)findViewById(R.id.save);

        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());
        rating.setRating(selectedPlace.getRating()); // Problem - Consider to change from String to Integer
        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // using trim to eliminate the white space in beginning and end of the String
                selectedPlace.setName(name.getText().toString().trim());
                selectedPlace.setAddress(address.getText().toString().trim());
                selectedPlace.setPhone(phone.getText().toString().trim());
                selectedPlace.setDescription(description.getText().toString().trim());
                selectedPlace.setTag(tag.getText().toString().trim());
                selectedPlace.setRating((int) rating.getRating()); //Problem - consider to change from String to Integer

                EditPlaceDialog.this.placesActivity.updatePlace(selectedPlace);
                EditPlaceDialog.this.detailPlaceActivity.setSelectedPlace(selectedPlace); //update the Detail Screen
                EditPlaceDialog.this.dismiss(); //to make the Edit dialog disappear after clicking Save
            }
        });
    }
}