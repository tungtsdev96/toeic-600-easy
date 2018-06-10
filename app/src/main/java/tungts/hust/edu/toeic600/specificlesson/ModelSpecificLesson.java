package tungts.hust.edu.toeic600.specificlesson;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.database.DatabaseConstant;
import tungts.hust.edu.toeic600.database.DatabaseHelper;
import tungts.hust.edu.toeic600.entity.Vocabulary;

public class ModelSpecificLesson extends DatabaseHelper implements MVPSpecificLesson.IModelSpecificLesson {


    public ModelSpecificLesson(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Vocabulary> getListSpecificTopic(int id_lesson) {
        ArrayList<Vocabulary> arrVocabularies = new ArrayList<>();
        String sql = "SELECT * FROM " + DatabaseConstant.TABLE_VOCABULARY + " WHERE " + DatabaseConstant.VOCABULARY_LESSON_ID + "=?";
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(id_lesson)});
        while (c.moveToNext()){
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setId(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_ID)));
            vocabulary.setVocabulary_type(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_TYPE)));
            vocabulary.setExample_en(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXAMPLE_EN)));
            vocabulary.setVocabulary_vi(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXAMPLE_VI)));
            vocabulary.setLession_id(id_lesson);
            vocabulary.setPronunciation(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_PRONUNCIATION)));
            vocabulary.setVocabulary_en(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EN)));
            vocabulary.setVocabulary_vi(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_VI)));
            vocabulary.setExplantion(c.getString(c.getColumnIndex(DatabaseConstant.VOCABULARY_EXPLANTION)));
            vocabulary.setRemind(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_REMIND)));
            vocabulary.setScore(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_SCORE)));
            vocabulary.setFavorite(c.getInt(c.getColumnIndex(DatabaseConstant.VOCABULARY_FAVORITE)) == 1 ? true : false);
            arrVocabularies.add(vocabulary);
        }
        return arrVocabularies;
    }

    @Override
    public void close() {
        super.close();
    }
}
