package tungts.hust.edu.toeic600.main.home.favorite.favoriteword;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Vocabulary;

public class MVPFavoriteWord {

    public interface IView {
        void displayListFavoriteVocabularies(ArrayList<Vocabulary> vocabularies);
        void clickFavoriteVocabCallback(int pos);
    }

    public interface IPresent {
        void displayListFavoriteLessons();
        ArrayList<Vocabulary> getListFavoriteVocabularies();
        void clickUnlike(int id_vocab, int pos);
    }

    public interface IModel {
        ArrayList<Vocabulary> getListFavoriteVocabulary();
        int clickUnlike(int id_vocab);
    }


}
