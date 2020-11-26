package ca.gbc.comp3074.guide;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PlaceItemView extends RecyclerView.ViewHolder {
    public TextView name, address, phone, description;

    public PlaceItemView(View view){
        super(view);
        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        phone = view.findViewById(R.id.phone);
        description = view.findViewById(R.id.description);
    }

}
