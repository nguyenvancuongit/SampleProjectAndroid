package android.app.tempapplication.activities;

import android.app.tempapplication.R;
import android.app.tempapplication.adapters.MenuAdapter;
import android.app.tempapplication.views.ToolbarView;
import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows 7 on 7/11/2016.
 */
public class BaseActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    /**
     * UI
     */
    ToolbarView toolbar;
    DrawerLayout drawer;
    ListView lvMenu;

    /**
     * store
     */
    MenuAdapter menuAdapter;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
        initNavigationView();
    }

    private void initToolbar() {
        // set UI
        toolbar = (ToolbarView) findViewById(R.id.toolbar);

        // listener
        toolbar.getImgMenu().setOnClickListener(view -> {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    private void initNavigationView() {
        // set UI
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        lvMenu = (ListView) findViewById(R.id.lv_menu);

        // set up menu data
        List<String> menuList = new ArrayList<>();
        menuList.add(getString(R.string.fragment_1));
        menuList.add(getString(R.string.fragment_2));
        menuList.add(getString(R.string.fragment_3));
        menuAdapter = new MenuAdapter(this, menuList);
        lvMenu.setAdapter(menuAdapter);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (menuAdapter.getItem(position).equals(getString(R.string.fragment_1))) {

        } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_2))) {

        } else if (menuAdapter.getItem(position).equals(getString(R.string.fragment_3))) {

        }
    }
}
