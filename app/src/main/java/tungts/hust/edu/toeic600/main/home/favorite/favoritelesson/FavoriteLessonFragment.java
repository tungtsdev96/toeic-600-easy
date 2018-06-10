package tungts.hust.edu.toeic600.main.home.favorite.favoritelesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.LessonGridAdapter;
import tungts.hust.edu.toeic600.adapter.LessonLinearAdapter;
import tungts.hust.edu.toeic600.customview.GirdSpacingItemDecoration;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.main.MainActivity;
import tungts.hust.edu.toeic600.specificlesson.SpecificLessonActivity;
import tungts.hust.edu.toeic600.utils.Constant;
import tungts.hust.edu.toeic600.utils.Utils;

public class FavoriteLessonFragment extends BaseFragment implements MVPFavoriteLesson.IView, RecycleViewItemClick, ClickUnlikeLesson {

    @BindView(R.id.rcv)
    RecyclerView rcv_favorite_lesson;
    LessonGridAdapter lessonGridAdapter;
    ArrayList<Lesson> arrLessons;
    MVPFavoriteLesson.IPresent present;

    @BindView(R.id.text)
    TextView text;

    public static FavoriteLessonFragment newInstance(){
        FavoriteLessonFragment favoriteLessonFragment = new FavoriteLessonFragment();
        return favoriteLessonFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_rcv;
    }

    @Override
    protected void onViewCreating() {
        present = new PresentFavoriteLesson(getContext(), this);
        present.displayListFavoriteLessons();
    }

    @Override
    public void displayListFavoriteLessons(ArrayList<Lesson> lessons) {
        this.arrLessons = lessons;
        if (arrLessons.isEmpty()) {
            text.setText(getString(R.string.no_lesson_favorite));
            text.setVisibility(View.VISIBLE);
            return;
        }
        text.setText("");
        lessonGridAdapter = new LessonGridAdapter(getContext(), lessons, rcv_favorite_lesson);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcv_favorite_lesson.addItemDecoration(new GirdSpacingItemDecoration(3, Utils.convertdpTopx(5, getContext()), false));
        rcv_favorite_lesson.setItemAnimator(new DefaultItemAnimator());
        rcv_favorite_lesson.setLayoutManager(gridLayoutManager);
        rcv_favorite_lesson.setAdapter(lessonGridAdapter);
        lessonGridAdapter.setOnRecycleViewItemClick(this);
        lessonGridAdapter.setOnClickUnlikeLesson(this);
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

    @Override
    public void clickUnlike(int pos) {
        present.clickUnlike(arrLessons.get(pos).getId(), pos);
    }

    @Override
    public void clickUnlikeSuccess(int pos) {
        arrLessons.remove(pos);
        lessonGridAdapter.notifyItemRemoved(pos);
        if (arrLessons.isEmpty()) {
            text.setVisibility(View.VISIBLE);
            text.setText(R.string.no_lesson_favorite);
        }
    }

}
