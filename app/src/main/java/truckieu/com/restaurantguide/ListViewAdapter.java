package truckieu.com.restaurantguide;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

    public class ListViewAdapter extends BaseAdapter {

        // Declare Variables

        Context mContext;
        LayoutInflater inflater;
        private List<RestaurantNames> restaurantNamesList = null;
        private ArrayList<RestaurantNames> arraylist;

        public ListViewAdapter(Context context, List<RestaurantNames> restaurantNamesList) {
            mContext = context;
            this.restaurantNamesList = restaurantNamesList;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<RestaurantNames>();
            this.arraylist.addAll(restaurantNamesList);
        }

        public class ViewHolder {
            TextView name;
        }

        @Override
        public int getCount() {
            return restaurantNamesList.size();
        }

        @Override
        public RestaurantNames getItem(int position) {
            return restaurantNamesList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.activity_search, null);
                // Locate the TextViews in listview_item.xml
                holder.name = (TextView) view.findViewById(R.id.name);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            // Set the results into TextViews
            holder.name.setText(restaurantNamesList.get(position).getAnimalName());
            return view;
        }

        // Filter Class
        public void filter(String charText) {
            charText = charText.toLowerCase(Locale.getDefault());
            restaurantNamesList.clear();
            if (charText.length() == 0) {
                restaurantNamesList.addAll(arraylist);
            } else {
                for (RestaurantNames wp : arraylist) {
                    if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                        restaurantNamesList.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }

