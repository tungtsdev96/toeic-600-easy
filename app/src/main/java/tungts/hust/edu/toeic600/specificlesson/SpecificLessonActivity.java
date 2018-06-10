package tungts.hust.edu.toeic600.specificlesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseActivity;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.ItemVovabularyAdapter;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.entity.Vocabulary;
import tungts.hust.edu.toeic600.specificvocabulary.SpecificVocabularyActivity;
import tungts.hust.edu.toeic600.utils.Constant;

public class SpecificLessonActivity extends BaseActivity implements MVPSpecificLesson.IViewSpecificLesson, RecycleViewItemClick, ClickFavAndSound {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @BindView(R.id.rcv_specific_topic)
    RecyclerView rcv_specific_topic;
    ArrayList<Vocabulary> listVocabularys;
    ItemVovabularyAdapter specificTopicAdapter;

    MVPSpecificLesson.IPresentSpecificLesson presentSpecificTopic;
    Lesson lesson;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_specific_lesson;
    }

    @Override
    protected void addControl(Bundle savedInstanceState) {
        lesson = (Lesson) getIntent().getExtras().getSerializable(Constant.KEY_BUNDLE_LESSON);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(lesson.getLessonNameEnglish());
        presentSpecificTopic = new PresenterSpecificLesson(getApplicationContext(),this );
        presentSpecificTopic.showListSpecificTopic(lesson.getId());
    }

    @Override
    public void displayListVocabulary(ArrayList<Vocabulary> lessons) {
        listVocabularys = lessons;
        specificTopicAdapter = new ItemVovabularyAdapter(this, listVocabularys, rcv_specific_topic);
        rcv_specific_topic.setLayoutManager(new LinearLayoutManager(this));
        rcv_specific_topic.setAdapter(specificTopicAdapter);
        specificTopicAdapter.setOnClickFavAndSound(this);
        specificTopicAdapter.setOnRecycleViewItemClick(this);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentSpecificTopic.closeModel();
    }

    //click pos
    @Override
    public void itemClick(int pos) {
        Vocabulary vocabulary = listVocabularys.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.KEY_BUNDLE_VOCABULARY, vocabulary);
        Intent intent = new Intent(SpecificLessonActivity.this, SpecificVocabularyActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //click favorite vocab
    @Override
    public void clickFavorite(int pos) {

    }

    //click soound
    @Override
    public void clickSound(int pos) {

    }
}
