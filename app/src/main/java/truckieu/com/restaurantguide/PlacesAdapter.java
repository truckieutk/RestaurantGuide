package truckieu.com.restaurantguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlaceItemView> {
    private ArrayList<Place> placesData;
    private MainActivity placesActivity;

    //constructor
    PlacesAdapter(ArrayList<Place> placesData){
        this.placesData = placesData;
    }

    public void setPlacesActivity(MainActivity placesActivity) {
        this.placesActivity = placesActivity;
    }

    @NonNull
    @Override
    public PlaceItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_item_view,viewGroup,false);
        PlaceItemView placeItemView = new PlaceItemView(view);
        placeItemView.setPlacesActivity(this.placesActivity);
        return placeItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceItemView placeItemView, int i) {
        //get object at index i
        Place selectedPlace = placesData.get(i);

        String nameRes = selectedPlace.getName();
        String address = selectedPlace.getAddress();
        String phone = selectedPlace.getPhone();
        String description = selectedPlace.getDescription();
        String tag = selectedPlace.getTag();
        Integer rating = selectedPlace.getRating();
        placeItemView.name.setText(nameRes);
        //placeItemView.address.setText("Address: " + address);
        //placeItemView.phone.setText("Phone: "+phone);
        //placeItemView.description.setText("Description: " + description);
        placeItemView.tag.setText("Tag: " + tag);
        placeItemView.rating.setText("Rating: " + rating);

        //just show name, tag and rating in the main list view
        //will show more detail in detail place

    }

    @Override
    public int getItemCount() {

        return placesData.size();
    }
    //get total elements in array


}

