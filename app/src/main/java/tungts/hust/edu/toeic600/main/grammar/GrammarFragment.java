package tungts.hust.edu.toeic600.main.grammar;

import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.BaseFragment;

public class GrammarFragment extends BaseFragment {

    String TAG;

    public static GrammarFragment newInstance(String TAG){
        GrammarFragment grammarFragment = new GrammarFragment();
        grammarFragment.TAG = TAG;
        return grammarFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_grammar;
    }

    @Override
    protected void onViewCreating() {

    }
}
