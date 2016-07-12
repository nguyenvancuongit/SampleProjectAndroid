package android.app.tempapplication.fragments;

import android.app.tempapplication.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Show3stFragment extends Fragment {

    public static Show3stFragment newInstance() {
        Show3stFragment fragment = new Show3stFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_3st, container, false);
    }
}
