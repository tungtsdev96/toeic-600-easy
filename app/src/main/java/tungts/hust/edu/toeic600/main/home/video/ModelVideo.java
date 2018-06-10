package tungts.hust.edu.toeic600.main.home.video;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tungts.hust.edu.toeic600.entity.youtube.PlayListYoutube;
import tungts.hust.edu.toeic600.internet.ApiFactory;
import tungts.hust.edu.toeic600.internet.BaseCallBack;
import tungts.hust.edu.toeic600.internet.ConfigApi;

public class ModelVideo implements MVPVideo.IModel {

    @Override
    public void getPlayListYoutube(String idPlayList, final MVPVideo.OnFinishedLoadDataListener listener, String pageToken) {
        ApiFactory.getApiGoogleMaps().getListVideo(idPlayList, ConfigApi.API_KEY, pageToken).enqueue(new Callback<PlayListYoutube>() {
            @Override
            public void onResponse(Call<PlayListYoutube> call, Response<PlayListYoutube> response) {
                listener.onFinished(response.body());
//                Log.e("youtube", new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<PlayListYoutube> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    @Override
    public void getInforVideoById(String idVideo) {
    }


}
