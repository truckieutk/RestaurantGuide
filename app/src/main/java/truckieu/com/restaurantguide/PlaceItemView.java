package truckieu.com.restaurantguide;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PlaceItemView extends RecyclerView.ViewHolder {
    public TextView name, address, phone, description, tag, rating;
    private MainActivity placesActivity;

    public void setPlacesActivity(MainActivity placesActivity) {
        this.placesActivity = placesActivity;
    }

    public PlaceItemView(View view){
        super(view);
        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        phone = view.findViewById(R.id.phone);
        description = view.findViewById(R.id.description);
        tag=view.findViewById(R.id.tag);
        rating=view.findViewById(R.id.rating);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PlaceItemView.this.placesActivity.navigateToDetailPlace(getLayoutPosition());

            }
        });

    }

}