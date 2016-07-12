package android.app.tempapplication.activities;

import android.app.tempapplication.R;
import android.app.tempapplication.adapters.MenuAdapter;
import android.app.tempapplication.fragments.Show1stFragment;
import android.app.tempapplication.fragments.Show2stFragment;
import android.app.tempapplication.fragments.Show3stFragment;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initFragmentsName();
        initMenuData();

        // init first screen
        transactionFragment(Show1stFragment.newInstance());
    }

    @Override
    public void initFragmentsName() {
        mFragmentName = new HashMap<>();
        mFragmentName.put(Show1stFragment.class.getSimpleName(), getString(R.string.fragment_1));
        mFragmentName.put(Show2stFragment.class.getSimpleName(), getString(R.string.fragment_2));
        mFragmentName.put(Show3stFragment.class.getSimpleName(), getString(R.string.fragment_3));
    }

    @Override
    public void initMenuData() {
        List<String> menuList = new ArrayList<>();
        menuList.add(getString(R.string.fragment_1));
        menuList.add(getString(R.string.fragment_2));
        menuList.add(getString(R.string.fragment_3));
        menuAdapter = new MenuAdapter(this, menuList);
        lvMenu.setAdapter(menuAdapter);

        // set menu click event
        lvMenu.setOnItemClickListener((adapterView, view, position, id) -> {
            if (menuAdapter.getItem(position).equals(getString(R.string.fragment_1))) {
                transactionFragment(Show1stFragment.newInstance());
            } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_2))) {
                transactionFragment(Show2stFragment.newInstance());
            } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_3))) {
                transactionFragment(Show3stFragment.newInstance());
            }
            drawer.closeDrawer(GravityCompat.START);
        });
    }
}
