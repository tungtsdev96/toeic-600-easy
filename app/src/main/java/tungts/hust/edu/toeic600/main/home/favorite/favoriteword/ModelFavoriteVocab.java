package tungts.hust.edu.toeic600.main.home.favorite.favoriteword;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.database.DatabaseConstant;
import tungts.hust.edu.toeic600.database.DatabaseHelper;
import tungts.hust.edu.toeic600.entity.Vocabulary;

public class ModelFavoriteVocab extends DatabaseHelper implements MVPFavoriteWord.IModel {

    public ModelFavoriteVocab(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Vocabulary> getListFavoriteVocabulary() {
        ArrayList<Vocabulary> vocabularies = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseConstant.TABLE_VOCABULARY + " WHERE " + DatabaseConstant.VOCABULARY_FAVORITE + "=1";
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()){
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setId(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_ID)));
            vocabulary.setVocabulary_type(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_TYPE)));
            vocabulary.setExample_en(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXAMPLE_EN)));
            vocabulary.setVocabulary_vi(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXAMPLE_VI)));
            vocabulary.setLession_id(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_LESSON_ID)));
            vocabulary.setPronunciation(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_PRONUNCIATION)));
            vocabulary.setVocabulary_en(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EN)));
            vocabulary.setVocabulary_vi(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_VI)));
            vocabulary.setExplantion(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXPLANTION)));
            vocabulary.setRemind(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_REMIND)));
            vocabulary.setScore(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_SCORE)));
            vocabulary.setFavorite(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_FAVORITE)) == 1 ? true : false);
            vocabularies.add(vocabulary);
        }
        c.close();
        return vocabularies;
    }

    @Override
    public int clickUnlike(int id_vocab) {
        return updateFavoriteWord(id_vocab, false);
    }
}
