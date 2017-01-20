package com.tonymaces.picturesword.restApi.deserialize;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.tonymaces.picturesword.model.User;
import com.tonymaces.picturesword.restApi.JsonKeys;
import com.tonymaces.picturesword.restApi.model.UserResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 15/08/2016.
 */
public class UserDeserialize implements JsonDeserializer<UserResponse> {

    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json,UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);  //this name data from json

        userResponse.setUsers(deserializeUserJson(userResponseData));
        return userResponse;
    }

    private ArrayList<User> deserializeUserJson(JsonArray userResponseData ){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i <userResponseData.size() ; i++) {

            JsonObject userResponseDataObject = userResponseData.get(i).getAsJsonObject();

            JsonObject userJson = userResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String fullName         = userJson.get(JsonKeys.USER_FULL_NAME).getAsString();

            JsonObject imageJson         = userResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTIONS);
            String urlImage              = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = userResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            User user = new User();
            user.setId(id);
            user.setFullName(fullName);
            user.setUrlImage(urlImage);
            user.setLikes(likes);

            users.add(user);
        }
        return  users;
    }
}
