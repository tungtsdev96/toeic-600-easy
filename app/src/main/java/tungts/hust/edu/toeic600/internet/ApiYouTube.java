package tungts.hust.edu.toeic600.internet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tungts.hust.edu.toeic600.entity.youtube.PlayListYoutube;

public interface ApiYouTube {

    @GET("/youtube/v3/playlistItems?part=snippet&maxResults=10")
    Call<PlayListYoutube> getListVideo(@Query("playlistId") String playlistId,
                                       @Query("key") String key,
                                       @Query("pageToken") String pageToken);

    @GET("/youtube/v3/videos?part=snippet,contentDetails")
    Call<PlayListYoutube> getVideoInforById(@Query("id") String id,
                                            @Query("key") String key);


}
