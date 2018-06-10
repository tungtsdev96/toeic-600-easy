package tungts.hust.edu.toeic600.main.home.lesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.LessonGridAdapter;
import tungts.hust.edu.toeic600.customview.GirdSpacingItemDecoration;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.main.MainActivity;
import tungts.hust.edu.toeic600.specificlesson.SpecificLessonActivity;
import tungts.hust.edu.toeic600.utils.Constant;
import tungts.hust.edu.toeic600.utils.Utils;

public class LessonFragment extends BaseFragment implements MVPLesson.IViewLesson, RecycleViewItemClick {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rcv_lesson)
    RecyclerView rcv;
    ArrayList<Lesson> arrLessons;
    LessonGridAdapter lessonAdapter;
    MVPLesson.IPresentLesson presentLesson;

    public static LessonFragment newInstance(){
        return new LessonFragment();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_lesson;
    }

    @Override
    protected void onViewCreating() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).setUpDrawerLayout(toolbar);
        presentLesson = new PresenterLesson(getContext(), this);
        presentLesson.showListLesson();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_home_fragment, menu);
    }

    private void innitRcv() {
        lessonAdapter = new LessonGridAdapter(getContext(), arrLessons, rcv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcv.addItemDecoration(new GirdSpacingItemDecoration(3, Utils.convertdpTopx(5, getContext()), false));
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setLayoutManager(gridLayoutManager);
        lessonAdapter.setOnRecycleViewItemClick(this);
//        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setAdapter(lessonAdapter);
    }

    @Override
    public void displayLesson(ArrayList<Lesson> lessons) {
        arrLessons = lessons;
        innitRcv();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presentLesson.closeModel();
    }

    @Override
    public void itemClick(int pos) {
        Lesson lesson = arrLessons.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.KEY_BUNDLE_LESSON, lesson);
        Intent intent = new Intent(getActivity(), SpecificLessonActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
