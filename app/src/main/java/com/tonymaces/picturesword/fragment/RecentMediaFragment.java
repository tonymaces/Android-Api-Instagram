package com.tonymaces.picturesword.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.tonymaces.picturesword.R;
import com.tonymaces.picturesword.adapter.UserAdapter;
import com.tonymaces.picturesword.model.User;
import com.tonymaces.picturesword.restApi.EndpointsApi;
import com.tonymaces.picturesword.restApi.adapter.RestApiAdapter;
import com.tonymaces.picturesword.restApi.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentMediaFragment extends Fragment {

    public static final String TAG = RecentMediaFragment.class.toString();
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    private ArrayList<User> mUsers;

    public RecentMediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recent_media, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rvRecentMedia);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        LoadRecentMediaCustom();
        IniAdapter();

        return  v;
    }

    private void LoadRecentMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter(); // esblece una conceccion con la api instagram
        EndpointsApi endpointsApi = restApiAdapter.conectionRestApiInstagram(); // ejecuta la llamada al servidor
        Call<UserResponse> userResponseCall =  endpointsApi.getRecentMedia();  // ejecuto la llamada al server

        // con esto controllamos el resultado della respuesta
        userResponseCall.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                //Usamos body por que lo que esta en "data": es decir la raiz del Json
                UserResponse userResponse = response.body(); // contiene el array del dato
                mUsers =  userResponse.getUsers();
                Log.d(TAG,"Tutto ok");

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),"Error load ",Toast.LENGTH_LONG);
                Log.e("Fallo la conexion", t.toString());
            }
        });


    }

    private  void  LoadRecentMediaCustom(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.buildGsonDeserializeMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.conectionRestApiInstagram(gson); // ejecuta la llamada al servidor
        Call<UserResponse> userResponseCall =  endpointsApi.getRecentMedia();  // ejecuto la llamada al server

        // con esto controllamos el resultado della respuesta
        userResponseCall.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                //Usamos body por que lo que esta en "data": es decir la raiz del Json
                UserResponse userResponse = response.body(); // contiene el array del dato
                mUsers =  userResponse.getUsers();
                if (mUsers != null){
                    for (int i = 0; i <mUsers.size() ; i++) {
                        mUserAdapter.SetUser(mUsers.get(i));
                    }
                }
                Log.d(TAG,"Tutto ok");
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),"Error load ",Toast.LENGTH_LONG);
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }

    public  void IniAdapter(){

        mUserAdapter = new UserAdapter(getActivity());

        mRecyclerView.setAdapter(mUserAdapter);
    }
}
