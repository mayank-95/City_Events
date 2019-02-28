package com.mayank.ok.events.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayank.ok.events.R;

import java.util.List;

public class EventAdapter extends ArrayAdapter <EventModel> {
    private Activity context;
    private List<EventModel> events;

    public EventAdapter(@NonNull Activity context, List<EventModel> events) {
        super(context, R.layout.listitem, events);
        this.context=context;
        this.events = events;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.listitem,null,true);

        TextView title=listViewItem.findViewById(R.id.title);
        TextView date=listViewItem.findViewById(R.id.date);
        TextView location=listViewItem.findViewById(R.id.location);
        TextView description=listViewItem.findViewById(R.id.description);
        TextView creator=listViewItem.findViewById(R.id.creator);

        EventModel eventModel=events.get(position);
        title.setText(eventModel.getTitle());
        date.setText("Date: "+eventModel.getDate());
        location.setText("Location: "+eventModel.getLocation());
        description.setText("Description: "+eventModel.getDescription());
        creator.setText("Posted by: "+eventModel.getCreator());

        return listViewItem;

    }
}
