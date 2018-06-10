package tungts.hust.edu.toeic600.main.home.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import io.realm.Progress;
import tungts.hust.edu.toeic600.BaseFragment;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.adapter.VideoAdapter;
import tungts.hust.edu.toeic600.entity.youtube.ItemVideo;
import tungts.hust.edu.toeic600.entity.youtube.PlayListYoutube;
import tungts.hust.edu.toeic600.internet.ApiFactory;
import tungts.hust.edu.toeic600.internet.ApiYouTube;
import tungts.hust.edu.toeic600.internet.BaseCallBack;
import tungts.hust.edu.toeic600.internet.ConfigApi;

public class VideoFragment extends BaseFragment implements MVPVideo.IView {

    PlayerVideoFragment yt_view;
    @BindView(R.id.rcv_list_video)
    RecyclerView rcv_list_video;
    VideoAdapter videoAdapter;

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    MVPVideo.IPresent present;

    PlayListYoutube playListYoutube;
    ArrayList<ItemVideo> items;

    public static VideoFragment newInstance(){
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void onViewCreating() {
        yt_view = (PlayerVideoFragment) getActivity().getFragmentManager().findFragmentById(R.id.yt_view);
        present = new PresenterVideo(this);
        present.showListVideo("UUbW18JZRgko_mOGm5er8Yzg","");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        PlayerVideoFragment yt_view = (PlayerVideoFragment) getActivity().getFragmentManager()
                .findFragmentById(R.id.yt_view);
        if (yt_view != null)
            getActivity().getFragmentManager().beginTransaction().remove(yt_view).commit();
    }

    @Override
    public void showProgressBar() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progress_bar.setVisibility(View.GONE);
    }

    @Override
    public void showListVideo(PlayListYoutube playListYoutube) {
        this.playListYoutube = playListYoutube;
        this.items = playListYoutube.getItems();
        Log.e("youtube", items.get(0).getSnippet().getThumbnails().getMedium().getUrl());
        videoAdapter = new VideoAdapter(getContext(), items, rcv_list_video);
        rcv_list_video.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_list_video.setAdapter(videoAdapter);
    }
}
