package tungts.hust.edu.toeic600.view.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.view.BaseFragment;
import tungts.hust.edu.toeic600.view.home.BottomNavigationBehavior;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.bottom_navi_home)
    BottomNavigationView bottomNavigationView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onViewCreating() {
        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
