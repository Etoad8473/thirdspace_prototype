package com.example.sumon.androidvolley;

import static com.example.sumon.androidvolley.api.ApiClientFactory.GetEventApi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sumon.androidvolley.api.SlimCallback;
import com.example.sumon.androidvolley.model.Event;

import java.util.List;
/**
 * @author kaiheng
 */
public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button getEventBtn, saveEventBtn, backButton;
    private EditText eventName, eventTime, eventLocation;
    private TextView viewEvent;
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";
    private ProgressDialog pDialog;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getEventBtn = (Button) findViewById(R.id.getEventBtn);
        saveEventBtn = (Button) findViewById(R.id.createEventBtn);
        backButton = (Button) findViewById(R.id.eventBackButton);
        eventName = (EditText) findViewById(R.id.eventNameTextField);
        eventTime = (EditText) findViewById(R.id.eventTimeTextField);
        eventLocation = (EditText) findViewById(R.id.eventLocationTextField);
        viewEvent = (TextView) findViewById(R.id.eventList);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        getEventBtn.setOnClickListener(this);
        saveEventBtn.setOnClickListener(this);
        backButton.setOnClickListener(this);
        viewEvent.setMovementMethod(new ScrollingMovementMethod());

        RegenerateAllEventsOnScreen(viewEvent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createEventBtn:
                postEvent();
                break;
            case R.id.getEventBtn:
                RegenerateAllEventsOnScreen(viewEvent);
                break;

            case R.id.eventBackButton:
                finish();
                break;

            default:
                break;
        }
    }

    public void postEvent(){
        Event newEvent = new Event();
        //newTrivia.setId(4);
        newEvent.setEventName(eventName.getText().toString());
        newEvent.setTime(eventTime.getText().toString());
        newEvent.setLocation(eventLocation.getText().toString());
        GetEventApi().PostEventByBody(newEvent).enqueue(new SlimCallback<Event>(event->{
            RegenerateAllEventsOnScreen(viewEvent);
        }));
        /*GetPostApi().getFirstPost().enqueue(new SlimCallback<Post>(response -> {
            String result = "email:  "+ response.getEmail()
                    +"\n  phone:  "+ response.getPhoneNumber()
                    +"\n  name:  "+ response.getName()
                    +"\n  aboutMe:  "+ response.getAboutMe()
                    +"\n  personality:  "+ response.getPersonality()
                    +"\n  gender:  "+ response.getGender()
                    +"\n  Body:    "+ response.getBigText();
            System.out.println(result);
        }, "CustomTagForFirstApi"));

         */
    }
    void RegenerateAllEventsOnScreen( TextView apiText1){

        GetEventApi().GetAllEvent().enqueue(new SlimCallback<List<Event>>(events ->{
            apiText1.setText("");

            for (int i = events.size()-1; i>=0; i--){
                apiText1.append(events.get(i).printable());
            }
        }, "GetAllEvents"));

    }
}