package tungts.hust.edu.toeic600.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.utils.Constant;
import tungts.hust.edu.toeic600.utils.GlideHelper;
import tungts.hust.edu.toeic600.utils.Utils;

public class LessonGridAdapter extends RecyclerView.Adapter<LessonGridAdapter.LessonHolder>{

    Context context;
    ArrayList<Lesson> arrLessons;
    LayoutInflater layoutInflater;
    RecyclerView rcv;
    RecycleViewItemClick onRecycleViewItemClick;

    public LessonGridAdapter(Context context, ArrayList<Lesson> arrLessons, RecyclerView rcv) {
        this.context = context;
        this.arrLessons = arrLessons;
        this.rcv = rcv;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LessonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LessonHolder(layoutInflater.inflate(R.layout.item_rcv_lesson_grid,null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final LessonHolder holder, int position) {
        final Lesson lesson = arrLessons.get(position);
        int idRes = Utils.convertNameToResId(context, lesson.getImageName(), Constant.DRAWABLE_FOLDER);
        GlideHelper.loadImageDrawable(context, idRes, holder.img_lesson);
        holder.lessonNameEnglish.setText(lesson.getLessonNameEnglish());
        holder.btn_like.setText(
                lesson.isFavorite() ? "UNLIKE" : "LIKE"
        );
    }

    @Override
    public int getItemCount() {
        return arrLessons.size();
    }

    public RecycleViewItemClick getOnRecycleViewItemClick() {
        return onRecycleViewItemClick;
    }

    public void setOnRecycleViewItemClick(RecycleViewItemClick onRecycleViewItemClick) {
        this.onRecycleViewItemClick = onRecycleViewItemClick;
    }

    protected class LessonHolder extends BaseViewHolder{

        @BindView(R.id.img_lesson)
        ImageView img_lesson;
        @BindView(R.id.lessonNameEnglish)
        TextView lessonNameEnglish;
        @BindView(R.id.progress_percent_lesson)
        ProgressBar progress_percent_lesson;
        @BindView(R.id.tv_like)
        TextView btn_like;
        @BindView(R.id.item_lesson)
        View item_lesson;

        public LessonHolder(View itemView) {
            super(itemView);
            item_lesson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecycleViewItemClick != null){
                        onRecycleViewItemClick.itemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

}
