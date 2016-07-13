package android.app.tempapplication.home;

import android.app.tempapplication.R;
import android.app.tempapplication.register.RegisterFragment;
import android.app.tempapplication.shared.activities.BaseActivity;
import android.app.tempapplication.shared.adapters.MenuAdapter;
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
        transactionFragment(HomeFragment.newInstance());
    }

    @Override
    public void initFragmentsName() {
        mFragmentName = new HashMap<>();
        mFragmentName.put(HomeFragment.class.getSimpleName(), getString(R.string.fragment_name_home));
        mFragmentName.put(Home2Fragment.class.getSimpleName(), getString(R.string.fragment_name_home_2));
        mFragmentName.put(RegisterFragment.class.getSimpleName(), getString(R.string.fragment_name_register));
    }

    @Override
    public void initMenuData() {
        List<String> menuList = new ArrayList<>();
        menuList.add(getString(R.string.fragment_name_home));
        menuList.add(getString(R.string.fragment_name_home_2));
        menuList.add(getString(R.string.fragment_name_register));
        menuAdapter = new MenuAdapter(this, menuList);
        lvMenu.setAdapter(menuAdapter);

        // set menu click event
        lvMenu.setOnItemClickListener((adapterView, view, position, id) -> {
            if (menuAdapter.getItem(position).equals(getString(R.string.fragment_name_home))) {
                transactionFragment(HomeFragment.newInstance());
            } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_name_home_2))) {
                transactionFragment(Home2Fragment.newInstance());
            } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_name_register))) {
                transactionFragment(RegisterFragment.newInstance());
            }
            drawer.closeDrawer(GravityCompat.START);
        });
    }
}
