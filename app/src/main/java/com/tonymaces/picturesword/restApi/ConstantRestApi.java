package com.tonymaces.picturesword.restApi;

/**
 * Created by Tony Macavilca Estrada on 13/08/2016.
 */
public class ConstantRestApi {
    public static final  String VERSION = "/v1/";
    public static final  String ROOT_URL ="https://api.instagram.com" + VERSION;
    public static final  String ACCESS_TOKEN ="3577816078.46fbe9b.a6fe6a84b60d46d38eedc5feddfaa8eb";
    public static final  String KEY_ACCESS_TOKEN ="?access_token=";
    public static final  String KEY_GET_RECENT_MEDIA_USER ="users/self/media/recent/";
    public static final  String URL_GET_RECENT_MEDIA_USER =  KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}
