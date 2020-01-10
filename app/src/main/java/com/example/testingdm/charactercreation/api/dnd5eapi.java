package com.example.testingdm.charactercreation.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface dnd5eapi {

    @GET("equipment/{name}")
    Call<equipment> getEquipment(@Path("name") String name);

    @GET("skills/{skillname}")
    Call<skills> getSkills(@Path("skillname") String skillname);

    @GET("features/{featurename}")
    Call<Features> getFeatures(@Path("featurename") String featurename);

    @GET("classes/{classname}")
    Call<classes> getclasses(@Path("classname") String classname);

    //@GET("spells/{spell}")
}
