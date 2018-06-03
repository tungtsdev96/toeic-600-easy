package tungts.hust.edu.toeic600.main.favoritelesson;

import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.main.grammar.GrammarFragment;

public class FavoriteLessonFragment extends BaseFragment {

    String TAG;

    public static FavoriteLessonFragment newInstance(String TAG){
        FavoriteLessonFragment favoriteLessonFragment = new FavoriteLessonFragment();
        favoriteLessonFragment.TAG = TAG;
        return favoriteLessonFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_favorite_lesson;
    }

    @Override
    protected void onViewCreating() {

    }
}
