package com.example.user.parkingreservation.presenter;

import android.util.Log;

import com.example.user.parkingreservation.model.ConnectApi;
import com.example.user.parkingreservation.model.ParkingInterfaceApi;
import com.example.user.parkingreservation.model.ParkingPojo;
import com.example.user.parkingreservation.view.ViewContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Presenter implements PresenterInterface {
    final String TAG = Presenter.class.getSimpleName();
    ViewContract viewContract;

    public Presenter(ViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public void getParkingLot(Double latitude, Double longitude) {
        Retrofit retrofit = ConnectApi.getInstance().initRetrofit();
        ParkingInterfaceApi parkingInterfaceApi = retrofit.create(ParkingInterfaceApi.class);
        parkingInterfaceApi.getParking(latitude, longitude).enqueue(new Callback<List<ParkingPojo>>() {
            @Override
            public void onResponse(Call<List<ParkingPojo>> call, Response<List<ParkingPojo>> response) {
                viewContract.findParkingLot(response.body().get(0));
                viewContract.findParkingLot(response.body().get(1));
                viewContract.findParkingLot(response.body().get(2));
                viewContract.findParkingLot(response.body().get(3));
                viewContract.findParkingLot(response.body().get(4));
            }

            @Override
            public void onFailure(Call<List<ParkingPojo>> call, Throwable t) {
                Log.d(TAG,"Error...");

            }
        });
    }
}
