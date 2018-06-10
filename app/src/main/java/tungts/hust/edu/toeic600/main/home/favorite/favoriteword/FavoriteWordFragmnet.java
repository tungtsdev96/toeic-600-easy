package tungts.hust.edu.toeic600.main.home.favorite.favoriteword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.ItemVovabularyAdapter;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Vocabulary;
import tungts.hust.edu.toeic600.specificlesson.ClickFavAndSound;
import tungts.hust.edu.toeic600.specificvocabulary.SpecificVocabularyActivity;
import tungts.hust.edu.toeic600.utils.Constant;

public class FavoriteWordFragmnet extends BaseFragment implements MVPFavoriteWord.IView, RecycleViewItemClick, ClickFavAndSound {

    @BindView(R.id.rcv)
    RecyclerView rcv_favorite_lesson;
    ItemVovabularyAdapter itemVovabularyAdapter;
    ArrayList<Vocabulary> arrVocabularies;
    MVPFavoriteWord.IPresent present;

    @BindView(R.id.text)
    TextView text;

    public static FavoriteWordFragmnet newInstance(){
        FavoriteWordFragmnet favoriteWordFragmnet = new FavoriteWordFragmnet();
        return favoriteWordFragmnet;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_rcv;
    }

    @Override
    protected void onViewCreating() {
        present = new PresentFavoriteWord(getContext(), this);
        present.displayListFavoriteLessons();
    }

    @Override
    public void displayListFavoriteVocabularies(ArrayList<Vocabulary> vocabularies) {
        this.arrVocabularies = vocabularies;
        if (arrVocabularies.isEmpty()) {
            text.setVisibility(View.VISIBLE);
            text.setText(getString(R.string.no_vocabulary_favorite));
            return;
        }
        text.setText("");
        itemVovabularyAdapter = new ItemVovabularyAdapter(getContext(), arrVocabularies, rcv_favorite_lesson);
        rcv_favorite_lesson.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_favorite_lesson.setAdapter(itemVovabularyAdapter);
        itemVovabularyAdapter.setOnRecycleViewItemClick(this);
        itemVovabularyAdapter.setOnClickFavAndSound(this);
    }

    @Override
    public void itemClick(int pos) {
        Vocabulary vocabulary = arrVocabularies.get(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.KEY_BUNDLE_VOCABULARY, vocabulary);
        Intent intent = new Intent(getActivity(), SpecificVocabularyActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void clickFavorite(int pos) {
        present.clickUnlike(arrVocabularies.get(pos).getId(), pos);
    }

    @Override
    public void clickFavoriteVocabCallback(int pos) {
        arrVocabularies.remove(pos);
        itemVovabularyAdapter.notifyItemRemoved(pos);
        if (arrVocabularies.isEmpty()) {
            text.setVisibility(View.VISIBLE);
            text.setText(R.string.no_vocabulary_favorite);
        }
    }

    @Override
    public void clickSound(int pos) {

    }
}
