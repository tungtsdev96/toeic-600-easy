package tungts.hust.edu.toeic600.entity;

import java.io.Serializable;

public class Lesson implements Serializable{

    private int id;
    private String lessonNameEnglish;
    private String lessonNameVietNamese;
    private int id_category;
    private String imageName;
    private String noteLessonEnglish;
    private String timeNeedToLearn;
    private boolean isFavorite;

    public Lesson() {}

    public Lesson(int id, String lessonNameEnglish, String lessonNameVietNamese, int id_category, String imageName, String noteLessonEnglish, String timeNeedToLearn, boolean isFavorite) {
        this.id = id;
        this.lessonNameEnglish = lessonNameEnglish;
        this.lessonNameVietNamese = lessonNameVietNamese;
        this.id_category = id_category;
        this.imageName = imageName;
        this.noteLessonEnglish = noteLessonEnglish;
        this.timeNeedToLearn = timeNeedToLearn;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonNameEnglish() {
        return lessonNameEnglish;
    }

    public void setLessonNameEnglish(String lessonNameEnglish) {
        this.lessonNameEnglish = lessonNameEnglish;
    }

    public String getLessonNameVietNamese() {
        return lessonNameVietNamese;
    }

    public void setLessonNameVietNamese(String lessonNameVietNamese) {
        this.lessonNameVietNamese = lessonNameVietNamese;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getImageName() {
        return "ls_" + this.id;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getNoteLessonEnglish() {
        return noteLessonEnglish;
    }

    public void setNoteLessonEnglish(String noteLessonEnglish) {
        this.noteLessonEnglish = noteLessonEnglish;
    }

    public String getTimeNeedToLearn() {
        return timeNeedToLearn;
    }

    public void setTimeNeedToLearn(String timeNeedToLearn) {
        this.timeNeedToLearn = timeNeedToLearn;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
