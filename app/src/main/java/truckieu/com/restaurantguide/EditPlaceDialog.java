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
    private  MainActivity placesActivity;
    private DetailPlaceActivity detailPlaceActivity;
    private Place selectedPlace;
    private EditText name,address,phone,tag,description;
    private Button save;
    EditPlaceDialog(Context context, MainActivity placesActivity, DetailPlaceActivity detailPlaceActivity ,Place selectedPlace, int layoutResId){
        super(context);
        this.placesActivity = placesActivity;
        this.selectedPlace = selectedPlace;
        this.detailPlaceActivity= detailPlaceActivity;
        this.setContentView(layoutResId);
        setupUI();
    }
    private void setupUI() {
        name = (EditText) findViewById(R.id.txtname);
        address = (EditText) findViewById(R.id.txtaddress);
        phone = (EditText) findViewById(R.id.txtphone);
        description = (EditText) findViewById(R.id.txtdescription);
        tag = (EditText) findViewById(R.id.txttag);
        save = (Button)findViewById(R.id.btnsave);

        name.setText(selectedPlace.getName());
        address.setText(selectedPlace.getAddress());
        phone.setText(selectedPlace.getPhone());
        description.setText(selectedPlace.getDescription());
        tag.setText(selectedPlace.getTag());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using trim to eliminate the white space in beginning and end of the String
                selectedPlace.setName(name.getText().toString().trim());
                selectedPlace.setAddress(address.getText().toString().trim());
                selectedPlace.setPhone(phone.getText().toString().trim());
                selectedPlace.setDescription(description.getText().toString().trim());
                selectedPlace.setTag(tag.getText().toString().trim());

                EditPlaceDialog.this.placesActivity.editPlace(selectedPlace);
                EditPlaceDialog.this.detailPlaceActivity.setSelectedPlace(selectedPlace); //update the Detail Screen
                EditPlaceDialog.this.dismiss();
                //to make the Edit dialog disappear after clicking Save
            }
        });
    }
}