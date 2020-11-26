package truckieu.com.restaurantguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlaceItemView> {
    private ArrayList<Place> placesData;
    PlacesAdapter(ArrayList<Place> placesData){
        this.placesData = placesData;
    }
    @NonNull
    @Override
    public PlaceItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_item_view,viewGroup,false);
        PlaceItemView placeItemView = new PlaceItemView(view);
        return placeItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceItemView placeItemView, int i) {
        Place select = placesData.get(i);
        String nameRes = select.getName();
        String address = select.getAddress();
        String phone = select.getPhone();
        String description = select.getDescription();
        String tag = select.getTag();
        String rating = select.getRating();
        placeItemView.name.setText(nameRes);
        placeItemView.address.setText("Address: " + address);
        placeItemView.phone.setText("Phone: "+phone);
        placeItemView.description.setText("Description: " + description);
        placeItemView.tag.setText("Tag: " + tag);
        placeItemView.rating.setText("Rating: " + rating);

    }

    @Override
    public int getItemCount() {
        return placesData.size();
    }
}

