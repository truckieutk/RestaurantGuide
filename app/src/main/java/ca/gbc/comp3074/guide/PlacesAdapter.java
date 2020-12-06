package ca.gbc.comp3074.guide;

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
        Place select = placesData.get(i);
        String nameRes = select.getName();
        String address = select.getAddress();
        String phone = select.getPhone();
        String description = select.getDescription();
        String tag = select.getTag();
        float rating = select.getRating();
        placeItemView.name.setText(nameRes);
        placeItemView.address.setText(address);
        placeItemView.phone.setText(phone);
        placeItemView.description.setText(description);
        placeItemView.tag.setText(tag);



    }

    @Override
    public int getItemCount() {

        return placesData.size();
    }

    public void  filterList(ArrayList<Place> filteredList){
        placesData=filteredList;
        notifyDataSetChanged();
    }

}
