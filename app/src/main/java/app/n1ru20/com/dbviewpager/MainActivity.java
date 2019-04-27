package app.n1ru20.com.dbviewpager;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";
    RecyclerView rcview;
    CustomAdapter customAdapter;
    ArrayList<Profile> list;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "starting state");


        //setting layout to recycler view for gallery
        rcview = findViewById(R.id.my_recycler_view);
        rcview.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Profile>();

        //getting data from firebase database and adding it into the list
        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Profile p = dataSnapshot1.getValue(Profile.class);
                    list.add(p);
                }
                //setting adapter to recycle view
                customAdapter = new CustomAdapter(MainActivity.this,list);
                rcview.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //occurs when permissions are wrong
                Toast.makeText(MainActivity.this,"try again",Toast.LENGTH_SHORT).show();
                System.out.println("error occured");
            }
        });

    }
}