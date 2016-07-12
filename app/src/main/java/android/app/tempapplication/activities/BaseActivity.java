package android.app.tempapplication.activities;

import android.app.tempapplication.R;
import android.app.tempapplication.adapters.MenuAdapter;
import android.app.tempapplication.views.ToolbarView;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Windows 7 on 7/11/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

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
    HashMap<String, String> mFragmentName;

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
    }

    /**
     * setting data for mFragmentName. This is list fragment name
     */
    public abstract void initFragmentsName();

    /**
     * setup data for navigation left menu
     */
    public abstract void initMenuData();

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
            int size = getSupportFragmentManager().getBackStackEntryCount();
            if (fragmentList != null && size > 0) {
                setUI(getCurrentlyFragment());
            } else {
                super.onBackPressed();  // if activity doesn't attach any fragment, finish the activity
            }
        }
    }

    /**
     * replace fragment
     *
     * @param fragment fragment for replace
     */
    public void transactionFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_content, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
            setUI(fragment);
        }
    }

    /**
     * set title for toolbar from list fragment name
     *
     * @param fragment currently fragment
     */
    private void setUI(Fragment fragment) {
        if (fragment != null) {
            toolbar.setTitle(getFragmentName(fragment.getClass().getSimpleName()));
        }
    }

    /**
     * use to get toolbar title from mFragmentName (list fragment name're saved)
     *
     * @param simpleName fragment class name
     * @return fragment title
     */
    private String getFragmentName(String simpleName) {
        for (Object name : mFragmentName.keySet()) {
            String title = mFragmentName.get(name);
            if (name.equals(simpleName)) {
                return title;
            }
        }
        return "Missing Name";
    }

    /**
     * @return currently fragment
     */
    public Fragment getCurrentlyFragment() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        int size = getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentList != null && size > 0) {
            return fragmentList.get(size - 1);
        } else {
            return null;
        }
    }
}
