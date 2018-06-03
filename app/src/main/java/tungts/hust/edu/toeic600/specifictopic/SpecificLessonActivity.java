package tungts.hust.edu.toeic600.specifictopic;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseActivity;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.SpecificLessonAdapter;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.entity.Vocabulary;
import tungts.hust.edu.toeic600.utils.Constant;

public class SpecificLessonActivity extends BaseActivity implements MVPSpecificLesson.IViewSpecificLesson {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @BindView(R.id.rcv_specific_topic)
    RecyclerView rcv_specific_topic;
    ArrayList<Vocabulary> listVocabularys;
    SpecificLessonAdapter specificTopicAdapter;

    MVPSpecificLesson.IPresentSpecificLesson presentSpecificTopic;
    Lesson lesson;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_specific_lesson;
    }

    @Override
    protected void addControl(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presentSpecificTopic = new PresenterSpecificLesson(getApplicationContext(),this );
        lesson = (Lesson) getIntent().getExtras().getSerializable(Constant.KEY_BUNDLE_LESSON);
        presentSpecificTopic.showListSpecificTopic(lesson.getId());
    }

    @Override
    public void displayListVocabulary(ArrayList<Vocabulary> lessons) {
        listVocabularys = lessons;
        specificTopicAdapter = new SpecificLessonAdapter(this, listVocabularys, rcv_specific_topic);
        rcv_specific_topic.setLayoutManager(new LinearLayoutManager(this));
        rcv_specific_topic.setAdapter(specificTopicAdapter);
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
}
