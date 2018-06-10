package tungts.hust.edu.toeic600.main.home.favorite;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.adapter.ViewPagerAdapter;
import tungts.hust.edu.toeic600.main.MainActivity;
import tungts.hust.edu.toeic600.main.home.favorite.favoritelesson.FavoriteLessonFragment;
import tungts.hust.edu.toeic600.main.home.favorite.favoriteword.FavoriteWordFragmnet;

public class FavoriteFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager_favorite)
    ViewPager view_pager_favorite;
    @BindView(R.id.tabs)
    TabLayout tabs;
    String TAG;

    public static FavoriteFragment newInstance(String TAG){
        FavoriteFragment favoriteFragment = new FavoriteFragment();
        favoriteFragment.TAG = TAG;
        return favoriteFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_favorite;
    }

    @Override
    protected void onViewCreating() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).setUpDrawerLayout(toolbar);
        ((MainActivity)getActivity()).setTitle("Favorite");
        setUpviewPager();
    }

    private void setUpviewPager() {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(FavoriteLessonFragment.newInstance(), "Lesson");
        pagerAdapter.addFragment(FavoriteWordFragmnet.newInstance(), "Vocabulary");
        view_pager_favorite.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(view_pager_favorite);
    }
}
