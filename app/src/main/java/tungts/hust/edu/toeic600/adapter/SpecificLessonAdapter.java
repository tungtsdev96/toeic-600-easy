package tungts.hust.edu.toeic600.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Vocabulary;

public class SpecificLessonAdapter extends RecyclerView.Adapter<SpecificLessonAdapter.SpecificLessonViewHolder>{

    Context context;
    ArrayList<Vocabulary> arrVocabularies;
    LayoutInflater layoutInflater;
    RecyclerView rcv;
    RecycleViewItemClick onRecycleViewItemClick;

    public SpecificLessonAdapter(Context context, ArrayList<Vocabulary> arrVocabularies, RecyclerView rcv) {
        this.context = context;
        this.arrVocabularies = arrVocabularies;
        this.rcv = rcv;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SpecificLessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpecificLessonViewHolder(layoutInflater.inflate(R.layout.item_word, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificLessonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrVocabularies.size();
    }

    protected class SpecificLessonViewHolder extends BaseViewHolder{

        public SpecificLessonViewHolder(View itemView) {
            super(itemView);
        }
    }
}
