package com.example.user.parkingreservation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.parkingreservation.MapsActivity;
import com.example.user.parkingreservation.R;
import com.example.user.parkingreservation.model.ParkingPojo;
import com.example.user.parkingreservation.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkingFragment extends Fragment{
    Presenter presenter;
    TextView textView;
    EditText latitude;
    EditText longitude;
    Button search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parking_fragment, container, false);
        textView = view.findViewById(R.id.tv_name);
        latitude = view.findViewById(R.id.et_latitude);
        longitude = view.findViewById(R.id.et_longitude);
        search = view.findViewById(R.id.b_search);
        search.setOnClickListener(event -> newParking());

        return view;
    }

    private void newParking() {
        Double lng = Double.parseDouble(longitude.getText().toString());
        Double lat = Double.parseDouble(latitude.getText().toString());
       // if (lng==null || lat==null) {
      //      }
       // else{
            presenter.getParkingLot(lng, lat);
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            intent.putExtra("longitude",lng);
            intent.putExtra("latitude",lat);
            startActivity(intent);
      //  }

    }

}
