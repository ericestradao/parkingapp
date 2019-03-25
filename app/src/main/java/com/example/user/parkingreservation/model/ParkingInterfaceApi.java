package com.example.user.parkingreservation.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ParkingInterfaceApi {
    @GET("parkinglocations/search?")
    Call<List<ParkingPojo>> getParking (@Query("lat") Double latitude,
                                        @Query("lng") Double longitude);
}


//five points
//"id": 2073,
//    "lat": "31.661678",
//    "lng": "-106.387383",
//    "name": "Campo de Futbol",

//"id": 2074,
//    "lat": "31.663189",
//    "lng": "-106.388693",
//    "name": "Modelorama",

//"id": 2075,
//    "lat": "31.662774",
//    "lng": "-106.388550",
//    "name": "Tiendita",
//

///"id": 2076,
//    "lat": "31.662296",
//    "lng": "-106.388646",
//    "name": "Menudo Reyna",

//"id": 2077,
//    "lat": "31.662133",
//    "lng": "-106.387673",
//    "name": "Taller",