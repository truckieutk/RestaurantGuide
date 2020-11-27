package truckieu.com.restaurantguide;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PlaceItemView extends RecyclerView.ViewHolder {
    public TextView name, address, phone, description, tag, rating;
    public Button edit, map, delete;

    public PlaceItemView(View view){
        super(view);
        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        phone = view.findViewById(R.id.phone);
        description = view.findViewById(R.id.description);
        tag=view.findViewById(R.id.tag);
        rating=view.findViewById(R.id.rating);
        edit=view.findViewById(R.id.edit);
        map=view.findViewById(R.id.map);
        delete=view.findViewById(R.id.delete);
    }

}