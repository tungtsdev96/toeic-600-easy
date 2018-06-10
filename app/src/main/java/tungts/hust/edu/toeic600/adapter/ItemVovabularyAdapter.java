package tungts.hust.edu.toeic600.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.customview.RecycleViewItemClick;
import tungts.hust.edu.toeic600.entity.Vocabulary;
import tungts.hust.edu.toeic600.specificlesson.ClickFavAndSound;

public class ItemVovabularyAdapter extends RecyclerView.Adapter<ItemVovabularyAdapter.SpecificLessonViewHolder>{

    Context context;
    ArrayList<Vocabulary> arrVocabularies;
    LayoutInflater layoutInflater;
    RecyclerView rcv;
    RecycleViewItemClick onRecycleViewItemClick;
    ClickFavAndSound onClickFavAndSound;

    public ItemVovabularyAdapter(Context context, ArrayList<Vocabulary> arrVocabularies, RecyclerView rcv) {
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
    public void onBindViewHolder(@NonNull final SpecificLessonViewHolder holder, final int position) {
        final Vocabulary vocabulary = arrVocabularies.get(position);
        holder.tvVocab.setText(vocabulary.getVocabulary_en());
        holder.tvTranslation.setText(vocabulary.getExplantion());
        holder.tvVocalPronunciation.setText(vocabulary.getPronunciation());
        holder.tvTranslation.setText(vocabulary.getVocabulary_vi());
        holder.imgFav.setImageResource(
                vocabulary.isFavorite() ? R.drawable.ic_fav_pink : R.drawable.ic_fav_border
        );

    }

    @Override
    public int getItemCount() {
        return arrVocabularies.size();
    }

    public RecycleViewItemClick getOnRecycleViewItemClick() {
        return onRecycleViewItemClick;
    }

    public void setOnRecycleViewItemClick(RecycleViewItemClick onRecycleViewItemClick) {
        this.onRecycleViewItemClick = onRecycleViewItemClick;
    }

    public ClickFavAndSound getOnClickFavAndSound() {
        return onClickFavAndSound;
    }

    public void setOnClickFavAndSound(ClickFavAndSound onClickFavAndSound) {
        this.onClickFavAndSound = onClickFavAndSound;
    }

    protected class SpecificLessonViewHolder extends BaseViewHolder{

        @BindView(R.id.item_vocabulary)
        LinearLayout item_vocabulary;
        @BindView(R.id.tvVocab)
        TextView tvVocab;
        @BindView(R.id.tvVocalPronunciation)
        TextView tvVocalPronunciation;
        @BindView(R.id.tvExplanation)
        TextView tvExplanation;
        @BindView(R.id.tvTranslation)
        TextView tvTranslation;
        @BindView(R.id.imgFav)
        ImageView imgFav;
        @BindView(R.id.imgSound)
        ImageView imgSound;

        public SpecificLessonViewHolder(View itemView) {
            super(itemView);
            item_vocabulary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecycleViewItemClick != null){
                        onRecycleViewItemClick.itemClick(getAdapterPosition());
                    }
                }
            });

            imgFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickFavAndSound != null){
                        onClickFavAndSound.clickFavorite(getAdapterPosition());
                    }
                }
            });

            imgSound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickFavAndSound != null){
                        onClickFavAndSound.clickSound(getAdapterPosition());
                    }
                }
            });
        }
    }
}
