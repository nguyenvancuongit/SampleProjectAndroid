package com.app.temp.features.home.repolist.view;

import com.app.temp.features.home.repolist.model.repository.Repository;

import java.util.List;

public interface IRepoListView {
    void loadGithubReposResult(List<Repository> repositories);
}
