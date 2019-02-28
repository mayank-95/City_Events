package com.mayank.ok.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Menu extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        switch(id)
        {
            case R.id.home:
                Intent i=new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(i);
                break;
            case R.id.add:
                Intent i1=new Intent(getApplicationContext(),AddeventActivity.class);
                startActivity(i1);
                break;
            case R.id.logout:
                Appdata.save(getApplicationContext(),"false",Appdata.login);
                Intent signout=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(signout);
                finish();
                break;
            case R.id.myevent:
                Intent i3=new Intent(getApplicationContext(),MyeventsActivity.class);
                startActivity(i3);
                break;
            case R.id.profile:
                Intent pro=new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(pro);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
