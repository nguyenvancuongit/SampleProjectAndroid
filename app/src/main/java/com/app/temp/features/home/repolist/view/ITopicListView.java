package com.app.temp.features.home.repolist.view;

import com.app.temp.features.home.repolist.model.repository.Topic;

import java.util.List;

public interface ITopicListView {
    void loadGithubReposResult(List<Topic> repositories);
}
