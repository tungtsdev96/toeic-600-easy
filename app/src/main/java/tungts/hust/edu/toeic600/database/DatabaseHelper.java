package tungts.hust.edu.toeic600.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    protected SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DatabaseConstant.DATABASE_NAME, null, DatabaseConstant.DATABASE_VERSION);
        db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void close(){
        if (db != null && db.isOpen()){
            db.close();
        }
    }

    protected int updateFavoriteLesson(int id_lesson, boolean fav){
        db = getWritableDatabase();
        int favorite = fav ? 1 : 0;
        ContentValues values = new ContentValues();
        values.put(DatabaseConstant.LESSON_FAVORITE, favorite);
        return db.update(DatabaseConstant.TABLE_LESSON, values, DatabaseConstant.LESSON_ID  + " = ?", new String[]{String.valueOf(id_lesson)});
    }

    protected int updateFavoriteWord(int id_vocab, boolean fav){
        db = getWritableDatabase();
        int favorite = fav ? 1 : 0;
        ContentValues values = new ContentValues();
        values.put(DatabaseConstant.VOCABULARY_FAVORITE, favorite);
        return db.update(DatabaseConstant.TABLE_VOCABULARY, values, DatabaseConstant.VOCABULARY_ID  + " = ?", new String[]{String.valueOf(id_vocab)});
    }

}
