package tungts.hust.edu.toeic600.main.home.favorite.favoriteword;

import android.content.Context;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Vocabulary;

public class PresentFavoriteWord implements MVPFavoriteWord.IPresent {

    MVPFavoriteWord.IModel model;
    MVPFavoriteWord.IView view;
    Context context;

    public PresentFavoriteWord(Context context, MVPFavoriteWord.IView view) {
        this.view = view;
        this.context = context;
        model = new ModelFavoriteVocab(context);
    }

    @Override
    public void displayListFavoriteLessons() {
        view.displayListFavoriteVocabularies(getListFavoriteVocabularies());
    }

    @Override
    public ArrayList<Vocabulary> getListFavoriteVocabularies() {
        return model.getListFavoriteVocabulary();
    }

    @Override
    public void clickUnlike(int id_vocab, int pos) {
        if (model.clickUnlike(id_vocab) != 0){
            view.clickFavoriteVocabCallback(pos);
        }
    }

}
