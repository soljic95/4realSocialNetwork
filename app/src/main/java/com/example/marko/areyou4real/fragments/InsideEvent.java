package com.example.marko.areyou4real.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marko.areyou4real.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class InsideEvent extends AppCompatActivity {
    private TextView tvEventName;
    private TextView tvEventActivity;
    private TextView tvEventTime;
    private TextView tvEventDescription;
    private TextView tvEventPlace;
    private TextView tvEventPlayersNeeded;
    private TextView tvEventPlayersEntered;
    private Button btnDoSomething;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference eventsRef = db.collection("Events");
    private Intent intent;
    private String eventId;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_event);

        fab = findViewById(R.id.fab);
        tvEventName = findViewById(R.id.tvEventName);
        tvEventActivity = findViewById(R.id.tvEventActivity);
        tvEventTime = findViewById(R.id.tvEventTime);
        tvEventDescription = findViewById(R.id.tvEventDescription);
        tvEventPlace = findViewById(R.id.tvEventPlace);
        tvEventPlayersNeeded = findViewById(R.id.tvPlayersNeeded);
        tvEventPlayersEntered = findViewById(R.id.tvPlayersEntered);
        btnDoSomething = findViewById(R.id.btnDoSomething);

        Toast.makeText(this, eventId, Toast.LENGTH_SHORT).show();
        loadData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void loadData() {

        intent = getIntent();
        eventId = intent.getStringExtra("EVENT_ID");

        eventsRef.whereEqualTo("eventId", eventId)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot dc : task.getResult()) {
                        Event event = dc.toObject(Event.class);
                        tvEventName.setText(event.getName());
                        tvEventActivity.setText(event.getActivity());
                        tvEventTime.setText("" + event.getTime());
                        tvEventDescription.setText(event.getEventDescription());
                        tvEventPlace.setText("Neko mjesto");
                        tvEventPlayersNeeded.setText("" + event.getUsersNeeded());
                        tvEventPlayersEntered.setText("" + event.getUsersEntered());
                        if (event.getIdOfTheUserWhoCreatedIt() == FirebaseAuth.getInstance().getUid()) {
                            btnDoSomething.setText("delete event");

                        }
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsideEvent.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
