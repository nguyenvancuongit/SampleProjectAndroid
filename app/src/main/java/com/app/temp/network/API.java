package com.app.temp.network;

import com.app.temp.pojo.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nguyen_van_cuong on 08/11/2017.
 */

public interface API {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
