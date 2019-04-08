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
import com.app.temp.features.home.repolist.adapter.TopicAdapter;
import com.app.temp.features.home.repolist.model.repository.Topic;
import com.app.temp.features.home.repolist.presenter.ITopicListPresenter;
import com.app.temp.features.home.repolist.presenter.TopicListPresenter;
import com.app.temp.features.home.repolist.view.ITopicListView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class TopicListFragment extends BaseFragment implements ITopicListView {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.btn_search)
    ImageView btnSearch;
    @BindView(R.id.rc_list)
    RecyclerView rcList;

    private ITopicListPresenter repoListPresenter;

    private TopicAdapter adapter;

    public static TopicListFragment newInstance() {
        TopicListFragment fragment = new TopicListFragment();
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

        // Init
        repoListPresenter = new TopicListPresenter(this);

        // Event
        btnSearch.setOnClickListener(view1 -> {
            if (edtName.getText().toString().trim().isEmpty()) {
                showMessage("Searching an empty content.");
            } else {
                hideSoftKeyboard();
                repoListPresenter.loadGithubRepos(getApi(), edtName.getText().toString().trim());
            }
        });
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        adapter = new TopicAdapter(repository -> RepoDetailActivity.start(getContext(), repository.getOwner().getAvatarUrl()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void updateRecyclerData(List<Topic> repositories) {
        adapter.setRepositories(repositories);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadGithubReposResult(List<Topic> repositories) {
        setupRecyclerView(rcList);
        updateRecyclerData(repositories);
    }
}
