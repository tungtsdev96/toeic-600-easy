package tungts.hust.edu.toeic600.main.home.favorite.favoritelesson;

import android.content.Context;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Lesson;

public class PresentFavoriteLesson implements MVPFavoriteLesson.IPresent {

    Context context;
    MVPFavoriteLesson.IView view;
    MVPFavoriteLesson.IModel model;

    public PresentFavoriteLesson(Context context, MVPFavoriteLesson.IView view) {
        this.view = view;
        this.context = context;
        model = new ModelFavoriteLesson(context);
    }

    @Override
    public void displayListFavoriteLessons() {
        view.displayListFavoriteLessons(getListFavoriteLessons());
    }

    @Override
    public ArrayList<Lesson> getListFavoriteLessons() {
        return model.getListFavoriteLessons();
    }

    @Override
    public void clickUnlike(int id_lesson, int pos) {
        if (model.clickUnlike(id_lesson) != 0){
            view.clickUnlikeSuccess(pos);
        }
    }
}
