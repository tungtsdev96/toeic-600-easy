package tungts.hust.edu.toeic600.main.home.lesson;

import android.content.Context;
import android.util.Log;

public class PresenterLesson implements MVPLesson.IPresentLesson {

    Context context;
    MVPLesson.IViewLesson viewLesson;
    MVPLesson.IModelLesson modelLesson;

    public PresenterLesson(Context context, MVPLesson.IViewLesson viewLesson){
        this.context = context;
        this.viewLesson = viewLesson;
        modelLesson = new ModelLesson(context);
    }

    @Override
    public void showListLesson() {
        viewLesson.displayLesson(modelLesson.getListLesson());
    }

    @Override
    public void closeModel() {
        modelLesson.close();
    }

}
