package com.tonymaces.picturesword.restApi.model;

import com.tonymaces.picturesword.model.User;

import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 14/08/2016.
 */
public class UserResponse {

    ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
