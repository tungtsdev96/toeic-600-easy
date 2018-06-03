package tungts.hust.edu.toeic600.database;

public class DatabaseConstant {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "toeic.db";
    public static final String DB_PATH_SUFFIX = "/databases/";

    //table vocabulary
    public static final String TABLE_VOCABULARY= "vocabulary";
    public static final String VOCABULARY_ID= "vocabulary_type";
    public static final String VOCABULARY_EXAMPLE_EN = "example_en";
    public static final String VOCABULARY_EXAMPLE_VI = "example_vi";
    public static final String VOCABULARY_LESSON_ID = "lession_id";
    public static final String VOCABULARY_IMAGE = "image";
    public static final String VOCABULARY_PRONUNCIATION = "pronunciation";
    public static final String VOCABULARY_EN = "vocabulary_en";
    public static final String VOCABULARY_VI = "vocabulary_vi";
    public static final String VOCABULARY_REMIND = "remind";
    public static final String VOCABULARY_SCORE = "score";

    //table category
    public static final String TABLE_CATEGORY = "Category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name_category";

    //table lesson
    public static final String TABLE_LESSON = "lesson";
    public static final String LESSON_ID = "id";
    public static final String LESSON_NAME_EN= "lessonNameEnglish";
    public static final String LESSON_NAME_VI = "lessonNameVietNamese";
    public static final String LESSON_CATEGORY_ID = "id_category";
    public static final String LESSON_PERCENT_LEARNED = "percent_learned";
    public static final String LESSON_NOTE= "noteLessonEnglish";
    public static final String LESSON_TIME_NEED_TO_LEARN = "timeNeedToLearn";
    public static final String LESSON_FAVORITE = "isFavorite";


}
