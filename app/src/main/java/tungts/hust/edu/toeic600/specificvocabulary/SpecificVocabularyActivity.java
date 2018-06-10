package tungts.hust.edu.toeic600.specificvocabulary;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseActivity;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.ViewPagerAdapter;
import tungts.hust.edu.toeic600.entity.Vocabulary;
import tungts.hust.edu.toeic600.utils.Constant;

public class SpecificVocabularyActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_specific_vocab)
    TabLayout tab_specific_vocab;
    @BindView(R.id.view_pager_specific_word)
    ViewPager view_pager_specific_word;
    ViewPagerAdapter viewPagerAdapter;
    Vocabulary vocabulary;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_specific_vocabulary;
    }

    @Override
    protected void addControl(Bundle savedInstanceState) {
        vocabulary = (Vocabulary) getIntent().getExtras().getSerializable(Constant.KEY_BUNDLE_VOCABULARY);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(VocabularyDetailFragmnet.newInstance("Detail Word"), "Word");
        viewPagerAdapter.addFragment(RecordsFragment.newInstance("Records Word"), "Records");
        viewPagerAdapter.addFragment(RecordsFragment.newInstance("Records Word"), "Records");
        view_pager_specific_word.setAdapter(viewPagerAdapter);
        tab_specific_vocab.setupWithViewPager(view_pager_specific_word);
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }
}
