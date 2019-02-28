package com.mayank.ok.events;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mayank.ok.events.adapter.EventAdapter;
import com.mayank.ok.events.adapter.EventModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends com.mayank.ok.events.Menu {

    List<EventModel> events;
    DatabaseReference databaseEvents;
    ListView listViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        events=new ArrayList<EventModel>();
        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
        listViewEvents=findViewById(R.id.allevents);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                events.clear();

                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    EventModel event=postSnapshot.getValue(EventModel.class);
                    events.add(event);
                }

                EventAdapter feedsAdapter=new EventAdapter(DashboardActivity.this,events);
                listViewEvents.setAdapter(feedsAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
