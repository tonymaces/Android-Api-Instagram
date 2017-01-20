package com.tonymaces.picturesword.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tonymaces.picturesword.restApi.ConstantRestApi;
import com.tonymaces.picturesword.restApi.EndpointsApi;
import com.tonymaces.picturesword.restApi.deserialize.UserDeserialize;
import com.tonymaces.picturesword.restApi.model.UserResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tony Macavilca Estrada on 14/08/2016.
 */
public class RestApiAdapter {
    public EndpointsApi conectionRestApiInstagram(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) // fa la serialization de forma general
                .build();

        return  retrofit.create(EndpointsApi.class);
    }

    public EndpointsApi conectionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) // fa la serialization de forma especifica
                .build();

        return  retrofit.create(EndpointsApi.class);
    }

    public Gson buildGsonDeserializeMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse.class, new UserDeserialize());
        Gson gson = gsonBuilder.create();
        return  gson;
    }

}
