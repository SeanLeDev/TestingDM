package com.example.testingdm.charactercreation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface dnd5eapi {

    @GET("equipment")
    Call<List<equipment>> getEquipment();
}
