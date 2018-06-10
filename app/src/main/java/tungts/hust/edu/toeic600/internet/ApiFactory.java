package tungts.hust.edu.toeic600.internet;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiFactory {

    private static Retrofit retrofitGoogleMapsApi;

    @NonNull
    public static ApiYouTube getApiGoogleMaps() {
        return getRetrofitYoutubeApi().create(ApiYouTube.class);
    }

    private static Retrofit getRetrofitYoutubeApi(){
        if (retrofitGoogleMapsApi == null){
            synchronized (ApiFactory.class){
                retrofitGoogleMapsApi = new Retrofit.Builder()
                        .baseUrl(ConfigApi.URL_YOUTUBE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient())
                        .build();
            }
        }
        return retrofitGoogleMapsApi;
    }

    @NonNull
    private static OkHttpClient okHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(ConfigApi.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ConfigApi.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(ConfigApi.WRITE_TIMEOUT, TimeUnit.SECONDS);
        return httpClient.build();
    }

}
