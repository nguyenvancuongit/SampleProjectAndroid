package com.app.temp.features.home.repolist.presenter;

import android.annotation.SuppressLint;

import com.app.temp.features.home.repolist.view.IRepoListView;
import com.app.temp.network.API;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepoListPresenter implements IRepoListPresenter {

    private IRepoListView iRepoListView;

    public RepoListPresenter(IRepoListView iRepoListView) {
        this.iRepoListView = iRepoListView;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadGithubRepos(API api, String userName) {
        api.publicRepositories(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositoriesResponse -> iRepoListView.loadGithubReposResult(repositoriesResponse.getRepositories()), Throwable::printStackTrace);
    }
}
