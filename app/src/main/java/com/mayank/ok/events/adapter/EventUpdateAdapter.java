package com.mayank.ok.events.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mayank.ok.events.R;
import com.mayank.ok.events.UpdateeventActivity;

import java.util.List;

public class EventUpdateAdapter extends ArrayAdapter <EventModel> {
    private Activity context;
    List<EventModel> events;



    public EventUpdateAdapter(@NonNull Activity context, List<EventModel> events) {
        super(context, R.layout.updatelistitem, events);
        this.events = events;
        this.context=context;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.updatelistitem,null,true);

        TextView title=(TextView) listViewItem.findViewById(R.id.title);
        TextView date=(TextView) listViewItem.findViewById(R.id.date);
        TextView location=(TextView) listViewItem.findViewById(R.id.location);
        TextView description=(TextView) listViewItem.findViewById(R.id.description);
        TextView creator=(TextView) listViewItem.findViewById(R.id.creator);
        Button update=(Button) listViewItem.findViewById(R.id.update);
        final EventModel eventModel=events.get(position);
        title.setText(eventModel.getTitle());
        date.setText("Date: "+ eventModel.getDate());
        location.setText("Location: "+eventModel.getLocation());
        description.setText("Description: "+eventModel.getDescription());
        creator.setText("Posted By: "+eventModel.getCreator());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(context, UpdateeventActivity.class);
                x.putExtra("id",eventModel.getId());
                x.putExtra("title",eventModel.getTitle());
                x.putExtra("date",eventModel.getDate());
                x.putExtra("location",eventModel.getLocation());
                x.putExtra("description",eventModel.getDescription());
                context.startActivity(x);

            }
        });

        return listViewItem;

    }
}
