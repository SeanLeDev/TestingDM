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

    @GET("choices/{choicename}")
    Call<choices> getchoices(@Path("choicename") String choicename);

    @GET("levels/{levelname}")
    Call<levels> getlevels(@Path("levelname") String levelname);

    @GET("proficiencies/{proficiencyname}")
    Call<proficiencies> getproficiency(@Path("proficiencyname") String proficiencyname);

    @GET("races/{racename}")
    Call<races> getrace(@Path("racename") String racename);

    @GET("skills/{skillname}")
    Call<skills> getskill(@Path("skillname") String skillname);

    @GET ("subclasses/{subclassname}")
    Call<subclasses> getsubclass(@Path("subclassname") String subclassname);

    //@GET("spells/{spell}")
}
