package android.app.tempapplication.home;

import android.app.tempapplication.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home2Fragment extends Fragment {

    public static Home2Fragment newInstance() {
        Home2Fragment fragment = new Home2Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_2st, container, false);
    }
}
