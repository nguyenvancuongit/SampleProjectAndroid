package com.app.temp.features.home.repolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.temp.R;
import com.app.temp.base.fragment.BaseFragment;
import com.app.temp.features.home.detail.RepoDetailActivity;
import com.app.temp.pojo.Repository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepoListFragment extends BaseFragment {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.btn_search)
    ImageView btnSearch;
    @BindView(R.id.rc_list)
    RecyclerView rcList;

    private RepositoryAdapter adapter;

    public static RepoListFragment newInstance() {
        RepoListFragment fragment = new RepoListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSearch.setOnClickListener(view1 -> {
            if (edtName.getText().toString().trim().isEmpty()) {
                showMessage("Searching an empty content.");
            } else {
                hideSoftKeyboard();
                loadGithubRepos(edtName.getText().toString().trim());
            }
        });
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        adapter = new RepositoryAdapter(repository -> RepoDetailActivity.start(getContext(), repository.getOwner().getAvatarUrl()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void updateRecyclerData(List<Repository> repositories) {
        adapter.setRepositories(repositories);
        adapter.notifyDataSetChanged();
    }

    private void loadGithubRepos(String userName) {
        disposable = getApi().publicRepositories(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositoriesResponse -> {
                    setupRecyclerView(rcList);
                    updateRecyclerData(repositoriesResponse.getRepositories());
                }, Throwable::printStackTrace);
    }
}
