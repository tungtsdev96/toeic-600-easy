package tungts.hust.edu.toeic600.main.home.lesson;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.entity.Lesson;

public class MVPLesson {

    public interface IViewLesson{
        void displayLesson(ArrayList<Lesson> lessons);
    }

    public interface IPresentLesson{
        void showListLesson();
        void closeModel();
    }

    public interface IModelLesson{
        ArrayList<Lesson> getListLesson();
        void close();
    }

}
