package com.mayank.ok.events;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.mayank.ok.events.adapter.EventAdapter;
import com.mayank.ok.events.adapter.EventModel;
import com.mayank.ok.events.adapter.EventUpdateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyeventsActivity extends Menu {

    List<EventModel> events;
    DatabaseReference databaseEvents;
    ListView listViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        events=new ArrayList<EventModel>();
        databaseEvents= FirebaseDatabase.getInstance().getReference("events");
        listViewEvents=findViewById(R.id.myevents);

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
    protected void onStart()
    {
        super.onStart();

        Query query=databaseEvents.orderByChild("creator").equalTo(Appdata.get(getApplicationContext(),Appdata.userkey));
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                events.clear();

                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    EventModel event=postSnapshot.getValue(EventModel.class);
                    events.add(event);
                }
                EventUpdateAdapter feedsAdapter=new EventUpdateAdapter(MyeventsActivity.this,events);
                listViewEvents.setAdapter(feedsAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
