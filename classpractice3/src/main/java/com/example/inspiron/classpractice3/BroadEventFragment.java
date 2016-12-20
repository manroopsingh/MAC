package com.example.inspiron.classpractice3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class BroadEventFragment extends Fragment {


    private static final String TAG = "Broadcast Fragment: ";
    private Button broadcast_btn;
    private Button event_btn;
    private EditText editText;


    public BroadEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = (EditText) view.findViewById(R.id.f_et);
        broadcast_btn = (Button) view.findViewById(R.id.f_btn_broadcast);
        event_btn = (Button) view.findViewById(R.id.f_btn_event);

        broadcast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Broadcast");

                Intent intent = new Intent();
                intent.setAction("My_Action");
                intent.putExtra("Edittext", editText.getText().toString());

                LocalBroadcastManager
                        .getInstance(getActivity())
                        .sendBroadcast(intent);
            }
        });

        event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Event");


                EventBus.getDefault().post(new ManroopEvent(editText.getText().toString()));



            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_broadevent, container, false);




    }



}
