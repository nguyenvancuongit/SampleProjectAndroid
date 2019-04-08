package com.app.temp.features.home.repolist.model.repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nguyen_van_cuong on 13/11/2017.
 */

public class RepositoryResponse {
    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public void add(Repository repository) {
        if (repositories == null) {
            repositories = new LinkedList<>();
        }
        repositories.add(repository);
    }
}
