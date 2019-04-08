package com.app.temp.features.home.repolist.model.repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nguyen_van_cuong on 13/11/2017.
 */

public class TopicResponse {
    private List<Topic> repositories;

    public List<Topic> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Topic> repositories) {
        this.repositories = repositories;
    }

    public void add(Topic topic) {
        if (repositories == null) {
            repositories = new LinkedList<>();
        }
        repositories.add(topic);
    }
}
