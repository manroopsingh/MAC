package com.example.inspiron.classpractice2;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class GreenFragment extends Fragment {


    private static final String TAG = "GreenFragment";
    private Button button;
    private MyCallBack myCallBack;
    private EditText editText;

    public GreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_green, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myCallBack = (MyCallBack)context;
        Log.d(TAG, "onAttach: ");

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = (EditText) view.findViewById(R.id.et_green);

        button = (Button) view.findViewById(R.id.f_red_green);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.someoneClicked(editText.getText().toString());


            }
        });


    }



    public interface MyCallBack{

        void someoneClicked(String message);

    }

}
