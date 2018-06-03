package tungts.hust.edu.toeic600.main;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.BaseActivity;
import tungts.hust.edu.toeic600.database.DatabaseConstant;
import tungts.hust.edu.toeic600.main.favoritelesson.FavoriteLessonFragment;
import tungts.hust.edu.toeic600.main.grammar.GrammarFragment;
import tungts.hust.edu.toeic600.main.home.HomeFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_GRAMMAR = "English Grammar";
    private static final String TAG_FAVORITE_LESSON = "Favorite Lesson";
    public static String CURRENT_TAG = TAG_HOME;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void addControl(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        mHandler = new Handler();
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                coordinator.setTranslationX(slideX);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadFragment();
        }

        processCoppyDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress){
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0){
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navi_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                break;
            case R.id.navi_favorite_lesson:
                navItemIndex = 1;
                CURRENT_TAG = TAG_FAVORITE_LESSON;
                break;
            case R.id.navi_grammar:
                CURRENT_TAG = TAG_GRAMMAR;
                navItemIndex = 2;
                break;
            case R.id.navi_learn_by_video:
                break;
            case R.id.navi_read_pharagraph:
                break;
            case R.id.navi_quiz:
                break;
            case R.id.navi_quiz_favorite:
                break;
            case R.id.navi_feedback:
                break;
            case R.id.navi_setting:
                break;

        }

        item.setChecked(true);
        loadFragment();
        return true;
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadFragment() {
        // selecting appropriate nav menu item
//        navigationView.getMenu().getItem(navItemIndex).setChecked(true);

        //setToolbar Title

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null){
            drawerLayout.closeDrawers();

            // show or hide the fab button
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.container, fragment, CURRENT_TAG);
                ft.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.postDelayed(mPendingRunnable, 350);
        }

        //Closing drawer on item click
        drawerLayout.closeDrawers();
    }

    private Fragment getFragment() {
        switch (navItemIndex){
            case 0:
                return HomeFragment.newInstance(TAG_HOME);
            case 1:
                return FavoriteLessonFragment.newInstance(TAG_FAVORITE_LESSON);
            case 2:
                return GrammarFragment.newInstance(TAG_GRAMMAR);
            default:
                return HomeFragment.newInstance(TAG_HOME);
        }
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void processCoppyDatabase() {
        File dbFile = getDatabasePath(DatabaseConstant.DATABASE_NAME);
        if (!dbFile.exists()){
            copyDataBaseFromAsset();
        }
    }

    private void copyDataBaseFromAsset() {
        try {
            InputStream inputStream;
            inputStream = getAssets().open(DatabaseConstant.DATABASE_NAME);
            String outFileName = getDatabaseDirectory();
            File f = new File(getApplicationInfo().dataDir + DatabaseConstant.DB_PATH_SUFFIX);
            if (!f.exists()){
                f.mkdir();
            }
            FileOutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0 , length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDatabaseDirectory() {
        return getApplicationInfo().dataDir + DatabaseConstant.DB_PATH_SUFFIX + DatabaseConstant.DATABASE_NAME;
    }

}
