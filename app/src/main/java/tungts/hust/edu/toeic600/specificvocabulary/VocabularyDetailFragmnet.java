package tungts.hust.edu.toeic600.specificvocabulary;

import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import butterknife.BindView;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.entity.Vocabulary;

public class VocabularyDetailFragmnet extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.tvVocab)
    TextView tvVocab;
    @BindView(R.id.tvPronunciation)
    TextView tvPronunciation;
    @BindView(R.id.tvExplanation)
    TextView tvExplanation;
    @BindView(R.id.tvMeaning)
    TextView tvMeaning;
    @BindView(R.id.tvExampleLabel)
    TextView tvExampleLabel;
    @BindView(R.id.tvExample)
    TextView tvExample;
    @BindView(R.id.tvExampleTrans)
    TextView tvExampleTrans;
    @BindView(R.id.btnFav)
    ImageButton btnFav;
    @BindView(R.id.btnSound)
    ImageButton btnSound;

    Vocabulary vocabulary;

    String TAG;
    public static VocabularyDetailFragmnet newInstance(String TAG){
        VocabularyDetailFragmnet vocabularyDetailFragmnet = new VocabularyDetailFragmnet();
        vocabularyDetailFragmnet.TAG = TAG;
        return vocabularyDetailFragmnet;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_specific_vocabulary;
    }

    @Override
    protected void onViewCreating() {
        vocabulary = ((SpecificVocabularyActivity)getActivity()).getVocabulary();
        tvVocab.setText(vocabulary.getVocabulary_en());
        tvPronunciation.setText(vocabulary.getPronunciation());
        tvExplanation.setText(vocabulary.getExplantion());
        tvMeaning.setText(vocabulary.getVocabulary_vi());
        tvExampleLabel.setText(Html.fromHtml("<u>Example</u>"));
        tvExample.setText(vocabulary.getExample_en());
        tvExampleTrans.setText(vocabulary.getExample_vi());
        addEvents();
    }

    private void addEvents() {
        btnFav.setOnClickListener(this);
        btnSound.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFav:
                Toast.makeText(getContext(), "fav", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSound:
                Toast.makeText(getContext(), "sound", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
