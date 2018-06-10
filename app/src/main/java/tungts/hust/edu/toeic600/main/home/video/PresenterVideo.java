package tungts.hust.edu.toeic600.main.home.video;

import android.util.Log;

import tungts.hust.edu.toeic600.entity.youtube.PlayListYoutube;

public class PresenterVideo implements MVPVideo.IPresent, MVPVideo.OnFinishedLoadDataListener {

    MVPVideo.IView view;
    MVPVideo.IModel model;

    public PresenterVideo(MVPVideo.IView view) {
        this.view = view;
        model = new ModelVideo();
    }

    @Override
    public void showListVideo(String idPlayList, String pageToken) {
        view.showProgressBar();
        model.getPlayListYoutube(idPlayList, this, pageToken);
    }

    @Override
    public void onFinished(PlayListYoutube playListYoutube) {
        view.hideProgressBar();
        view.showListVideo(playListYoutube);
    }

    @Override
    public void onFailure(Throwable t) {
        view.hideProgressBar();
        Log.e("youtube", t.getMessage());
    }

}
