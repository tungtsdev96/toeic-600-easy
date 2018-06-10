package tungts.hust.edu.toeic600.specificvocabulary;

import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.R;

public class RecordsFragment extends BaseFragment {

    String TAG;
    public static RecordsFragment newInstance(String TAG){
        RecordsFragment recordsFragment = new RecordsFragment();
        recordsFragment.TAG = TAG;
        return recordsFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_records_vocabulary;
    }

    @Override
    protected void onViewCreating() {

    }
}
