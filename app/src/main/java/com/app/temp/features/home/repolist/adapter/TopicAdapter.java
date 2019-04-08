package com.app.temp.features.home.repolist.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.temp.R;
import com.app.temp.features.home.repolist.model.repository.Topic;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by nguyen_van_cuong on 05/12/2017.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.RepositoryViewHolder> {

    private List<Topic> repositories;
    private Callback callback;

    public TopicAdapter(Callback callback) {
        this.callback = callback;
        this.repositories = Collections.emptyList();
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        RepositoryViewHolder viewHolder = new RepositoryViewHolder(itemView);
        viewHolder.lnContent.setOnClickListener(view -> callback.onItemClick(viewHolder.topic));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        holder.setTopic(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void setRepositories(List<Topic> repositories) {
        this.repositories = repositories;
    }

    static class RepositoryViewHolder extends RecyclerView.ViewHolder {

        Topic topic;

        LinearLayout lnContent;
        TextView tvTitle;
        TextView tvWatchers;
        TextView tvStars;
        TextView tvForks;

        @SuppressLint("SetTextI18n")
        void setTopic(Topic topic) {
            this.topic = topic;

            tvTitle.setText(topic.getName());
            tvWatchers.setText(String.valueOf(topic.getWatchersCount()) + " watchers");
            tvStars.setText(String.valueOf(topic.getStargazersCount()) + " stars");
            tvForks.setText(String.valueOf(topic.getForksCount()) + " forks");
        }

        RepositoryViewHolder(View itemView) {
            super(itemView);

            lnContent = itemView.findViewById(R.id.ln_content);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvWatchers = itemView.findViewById(R.id.tv_watchers);
            tvStars = itemView.findViewById(R.id.tv_stars);
            tvForks = itemView.findViewById(R.id.tv_forks);
        }
    }

    public interface Callback {
        void onItemClick(Topic topic);
    }
}
