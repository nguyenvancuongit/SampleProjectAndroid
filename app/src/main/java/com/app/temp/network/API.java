package com.app.temp.network;

import com.app.temp.network.model.PostsResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by nguyen_van_cuong on 08/11/2017.
 */

public interface API {
    @GET("/posts")
    Flowable<PostsResponse> getPosts();
}
