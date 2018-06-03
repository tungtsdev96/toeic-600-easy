package tungts.hust.edu.toeic600.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.main.home.lesson.LessonFragment;

public class HomeFragment extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navi_home)
    BottomNavigationView bottomNavigationView;

    String TAG;
    public static HomeFragment newInstance(String TAG){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.TAG = TAG;
        return homeFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onViewCreating() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // attaching bottom sheet behaviour - hide / show on scroll
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationBehavior());

        //load default fragment
        loadFragmnet(LessonFragment.newInstance());

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void loadFragmnet(Fragment fragment){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container_home, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.navi_lesson:
                loadFragmnet(LessonFragment.newInstance());
                break;
//            case R.id.navi_subject:
//                loadFragmnet(LessonFragment.newInstance());
//                break;
            case R.id.navi_favorite:
                loadFragmnet(LessonFragment.newInstance());
                break;
            case R.id.navi_profile:
                loadFragmnet(LessonFragment.newInstance());
                break;
        }
        return true;
    }
}
