package com.app.temp.features.home.repolist.presenter;

import android.annotation.SuppressLint;

import com.app.temp.features.home.repolist.view.ITopicListView;
import com.app.temp.network.API;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopicListPresenter implements ITopicListPresenter {

    private ITopicListView iTopicListView;

    public TopicListPresenter(ITopicListView iTopicListView) {
        this.iTopicListView = iTopicListView;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadGithubRepos(API api, String userName) {
        api.publicRepositories(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositoriesResponse -> iTopicListView.loadGithubReposResult(repositoriesResponse.getRepositories()), Throwable::printStackTrace);
    }
}
