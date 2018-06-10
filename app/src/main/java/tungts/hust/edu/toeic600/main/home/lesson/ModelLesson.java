package tungts.hust.edu.toeic600.main.home.lesson;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.database.DatabaseConstant;
import tungts.hust.edu.toeic600.database.DatabaseHelper;
import tungts.hust.edu.toeic600.entity.Lesson;

public class ModelLesson extends DatabaseHelper implements MVPLesson.IModelLesson {


    public ModelLesson(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Lesson> getListLesson(){
        ArrayList<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseConstant.TABLE_LESSON;
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()){
            Lesson lesson = new Lesson();
            lesson.setId(c.getInt(c.getColumnIndex(DatabaseConstant.LESSON_ID)));
            lesson.setLessonNameEnglish(c.getString(c.getColumnIndex(DatabaseConstant.LESSON_NAME_EN)));
            lesson.setLessonNameVietNamese(c.getString(c.getColumnIndex(DatabaseConstant.LESSON_NAME_VI)));
            lesson.setId_category(c.getInt(c.getColumnIndex(DatabaseConstant.LESSON_CATEGORY_ID)));
            lesson.setPercent_learned(c.getInt(c.getColumnIndex(DatabaseConstant.LESSON_PERCENT_LEARNED)));
            lesson.setNoteLessonEnglish(c.getString(c.getColumnIndex(DatabaseConstant.LESSON_NOTE)));
            lesson.setTimeNeedToLearn(c.getString(c.getColumnIndex(DatabaseConstant.LESSON_TIME_NEED_TO_LEARN)));
            lesson.setFavorite(c.getInt(c.getColumnIndex(DatabaseConstant.LESSON_FAVORITE)) == 1 ? true : false);
            lessons.add(lesson);
        }
        c.close();
        return lessons;
    }

    @Override
    public void close() {
        super.close();
    }

}
