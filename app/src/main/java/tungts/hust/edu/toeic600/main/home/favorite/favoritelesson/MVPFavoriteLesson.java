package tungts.hust.edu.toeic600.main.home.favorite.favoritelesson;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Lesson;

public class MVPFavoriteLesson {

    public interface IView {
        void displayListFavoriteLessons(ArrayList<Lesson> lessons);
        void clickUnlikeSuccess(int pos);
    }

    public interface IPresent {
        void displayListFavoriteLessons();
        ArrayList<Lesson> getListFavoriteLessons();
        void clickUnlike(int id_lesson, int pos);
    }

    public interface IModel {
        ArrayList<Lesson> getListFavoriteLessons();
        int clickUnlike(int id_lesson);
    }

}