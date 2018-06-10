package tungts.hust.edu.toeic600.entity;

import java.io.Serializable;

public class Vocabulary implements Serializable{

    private int id;
    private String vocabulary_type;
    private String example_en;
    private String example_vi;
    private int lession_id;
    private String image;
    private String pronunciation;
    private String vocabulary_en;
    private String vocabulary_vi;
    private String explantion;
    private int remind;
    private int score;
    private boolean isFavorite;

    public Vocabulary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVocabulary_type() {
        return vocabulary_type;
    }

    public void setVocabulary_type(String vocabulary_type) {
        this.vocabulary_type = vocabulary_type;
    }

    public String getExample_en() {
        return example_en;
    }

    public void setExample_en(String example_en) {
        this.example_en = example_en;
    }

    public String getExample_vi() {
        return example_vi;
    }

    public void setExample_vi(String example_vi) {
        this.example_vi = example_vi;
    }

    public int getLession_id() {
        return lession_id;
    }

    public void setLession_id(int lession_id) {
        this.lession_id = lession_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getVocabulary_en() {
        return vocabulary_en;
    }

    public void setVocabulary_en(String vocabulary_en) {
        this.vocabulary_en = vocabulary_en;
    }

    public String getVocabulary_vi() {
        return vocabulary_vi;
    }

    public void setVocabulary_vi(String vocabulary_vi) {
        this.vocabulary_vi = vocabulary_vi;
    }

    public String getExplantion() {
        return explantion;
    }

    public void setExplantion(String explantion) {
        this.explantion = explantion;
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
        this.remind = remind;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
