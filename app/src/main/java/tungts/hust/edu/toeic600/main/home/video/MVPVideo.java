package tungts.hust.edu.toeic600.main.home.video;

import tungts.hust.edu.toeic600.entity.youtube.PlayListYoutube;

public class MVPVideo {

    public interface IView {
        void showProgressBar();
        void hideProgressBar();
        void showListVideo(PlayListYoutube playListYoutube);
    }

    public interface IPresent {
        void showListVideo(String idPlayList,String pageToken);
    }

    public interface IModel {
        void getPlayListYoutube(String idPlayList, OnFinishedLoadDataListener listener, String pageToken);
        void getInforVideoById(String idVideo);
    }

    interface OnFinishedLoadDataListener {
        void onFinished(PlayListYoutube playListYoutube);
        void onFailure(Throwable t);
    }

}
