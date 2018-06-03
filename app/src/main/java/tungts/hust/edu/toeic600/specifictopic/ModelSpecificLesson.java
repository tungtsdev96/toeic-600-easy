package tungts.hust.edu.toeic600.specifictopic;

import android.content.Context;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.database.DatabaseHelper;
import tungts.hust.edu.toeic600.entity.Vocabulary;

public class ModelSpecificLesson extends DatabaseHelper implements MVPSpecificLesson.IModelSpecificLesson {


    public ModelSpecificLesson(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Vocabulary> getListSpecificTopic(int id_lesson) {
        ArrayList<Vocabulary> vocabularies = new ArrayList<>();
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        vocabularies.add(new Vocabulary());
        return vocabularies;
    }

    @Override
    public void close() {
        super.close();
    }
}
