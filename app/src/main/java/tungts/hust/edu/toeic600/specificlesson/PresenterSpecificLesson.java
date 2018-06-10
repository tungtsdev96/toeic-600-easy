package tungts.hust.edu.toeic600.specificlesson;

import android.content.Context;

public class PresenterSpecificLesson implements MVPSpecificLesson.IPresentSpecificLesson {

    Context context;
    MVPSpecificLesson.IViewSpecificLesson viewSpecificTopic;
    MVPSpecificLesson.IModelSpecificLesson modelSpecificTopic;

    public PresenterSpecificLesson(Context context, MVPSpecificLesson.IViewSpecificLesson viewSpecificTopic){
        this.context = context;
        this.viewSpecificTopic = viewSpecificTopic;
        modelSpecificTopic = new ModelSpecificLesson(context);
    }

    @Override
    public void showListSpecificTopic(int id_lesson) {
        viewSpecificTopic.displayListVocabulary(modelSpecificTopic.getListSpecificTopic(id_lesson));
    }

    @Override
    public void closeModel() {
        modelSpecificTopic.close();
    }

}
