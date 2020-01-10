package com.example.testingdm.charactercreation.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface dnd5eapi {

    @GET("equipment/{name}")
    Call<equipment> getEquipment(@Path("name") String name);

    @GET("skills/{skillname}")
    Call<skills> getSkills(@Path("skillname") String skillname);
}
