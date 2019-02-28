package com.mayank.ok.events;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mayank.ok.events.adapter.EventModel;

public class UpdateeventActivity extends com.mayank.ok.events.Menu {

    EditText title,date,location,description;
    Button update;
    String id;
    DatabaseReference databaseEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateevent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title=findViewById(R.id.title);
        date=findViewById(R.id.date);
        location=findViewById(R.id.location);
        description=findViewById(R.id.description);
        Bundle extras=getIntent().getExtras();
        id=extras.getString("id");
        title.setText(extras.getString("title"));
        date.setText(extras.getString("date"));
        location.setText(extras.getString("location"));
        description.setText(extras.getString("description"));

        databaseEvents= FirebaseDatabase.getInstance().getReference("events");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void update(View view) {
        String name,dat,loc,des,creator;
        name=title.getText().toString();
        dat=date.getText().toString();
        loc=location.getText().toString();
        des=description.getText().toString();
        creator=Appdata.get(getApplicationContext(),Appdata.userkey);
        Toast.makeText(getApplicationContext(),name+"\n"+dat+"\n"+loc+"\n"+des+"\n",Toast.LENGTH_LONG).show();
        EventModel em=new EventModel(id,name,dat,des,loc,creator);
        databaseEvents.child(id).setValue(em);
    }
}
