package com.tonymaces.picturesword.restApi;

import com.tonymaces.picturesword.restApi.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Tony Macavilca Estrada on 14/08/2016.
 */
public interface EndpointsApi {
    @GET(ConstantRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<UserResponse> getRecentMedia();
}
