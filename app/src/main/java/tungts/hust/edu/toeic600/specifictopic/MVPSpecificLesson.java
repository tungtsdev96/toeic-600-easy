package tungts.hust.edu.toeic600.specifictopic;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Vocabulary;

public class MVPSpecificLesson {

    public interface IViewSpecificLesson {
        void displayListVocabulary(ArrayList<Vocabulary> lessons);
    }

    public interface IPresentSpecificLesson {
        void showListSpecificTopic(int id_lesson);
        void closeModel();
    }

    public interface IModelSpecificLesson {
        ArrayList<Vocabulary> getListSpecificTopic(int id_lesson);
        void close();
    }

}
