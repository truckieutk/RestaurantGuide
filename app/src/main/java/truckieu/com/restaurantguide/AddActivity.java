package truckieu.com.restaurantguide;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AddActivity extends AppCompatActivity {
    private TextView title;
    private EditText name, address, phone, description;
    private RatingBar ratingBar;
    private Button submit;

    ListView lvRes;
    ArrayList<String> arrayInfo;

    String[] tag = { "Vegetarian","Fast Food","Asian Cuisine","Western Cuisine","BBQ","Dessert","Drinks" };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        submit = findViewById(R.id.submit);
        title = findViewById(R.id.title);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        description = findViewById(R.id.description);
        ratingBar = (RatingBar) findViewById(R.id.rating);

        lvRes=(ListView) findViewById(R.id.listAdd);
        arrayInfo = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, tag);
        //Find TextView control
        final AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.tag);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapter);

        final ArrayAdapter<String> restaurant = new ArrayAdapter<>(
                AddActivity.this, android.R.layout.simple_list_item_1, arrayInfo
        );
        lvRes.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String sName = name.getText().toString();
               String sAddress = "Address:" + address.getText().toString();
               String sPhone = "Phone:" + phone.getText().toString();
               String sDescription= "Description:" + description.getText().toString();
               //get the value from rating bar and display it into a toast
               String totalStars = "Rating:" + ratingBar.getNumStars();
               String rating = "Rating : " + ratingBar.getRating();
               Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
               String tag = "Tag: " + acTextView.getAdapter();


               arrayInfo.add(sName);
               arrayInfo.add(sAddress);
               arrayInfo.add(sPhone);
               arrayInfo.add(sDescription);
               arrayInfo.add(tag);
               arrayInfo.add(rating);

               restaurant.notifyDataSetChanged();
            }
        });
    }

    private void Home(){
        Intent start = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(start);
    }
    private void About(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.home:
                Home();
                break;
            case R.id.about:
                About();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

