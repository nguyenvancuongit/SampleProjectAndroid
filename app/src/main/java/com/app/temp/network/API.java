package com.app.temp.network;

import com.app.temp.features.home.repolist.model.repository.RepositoryResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nguyen_van_cuong on 08/11/2017.
 */

public interface API {
    @GET("users/{username}/repos")
    Flowable<RepositoryResponse> publicRepositories(@Path("username") String username);
}
