package android.app.tempapplication.fragments;

import android.app.tempapplication.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Show2stFragment extends Fragment {

    public static Show2stFragment newInstance() {
        Show2stFragment fragment = new Show2stFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_2st, container, false);
    }
}
