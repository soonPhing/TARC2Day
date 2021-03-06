package rsf2.android.tarc2day;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventList extends AppCompatActivity {

    private List<Event> eventList = new ArrayList<Event>();
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEventList);
        eventData();
        eventAdapter = new EventAdapter(eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventAdapter);


    }

    private void eventData() {

        //Get event data from database

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");
        //simpleDateFormat.applyPattern("d MMM yyyy");
        Date date = new Date();

        String startDate = simpleDateFormat.format(date);
        String endDate = simpleDateFormat.format(date);


        Society society = new Society("Computer Science Society","Ming Keat","testing","test","test2");
        Event event = new Event("Computer Science Night", "Code", startDate,endDate,society.getName(),0,"012123","tmk@gmail.com");
        eventList.add(event);

        event = new Event("Hackathon", "Coding", startDate,endDate,society.getName(),0,"4","tmk@gmail.com");
        eventList.add(event);

        event = new Event("Idea", "Hacking", startDate,endDate,society.getName(),0,"123","tmk@gmail.com");
        eventList.add(event);

    }
}
