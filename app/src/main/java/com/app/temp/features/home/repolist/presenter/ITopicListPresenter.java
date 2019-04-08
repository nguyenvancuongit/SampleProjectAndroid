package com.app.temp.features.home.repolist.presenter;

import com.app.temp.network.API;

public interface ITopicListPresenter {
    void loadGithubRepos(API api, String userName);
}
