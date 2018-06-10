package tungts.hust.edu.toeic600.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import tungts.hust.edu.toeic600.R;

public class GlideHelper {

    public static void loadImageDrawable(Context context, int idRes, ImageView img){
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_error)
                .error(R.drawable.ic_error);

        Glide.with(context)
                .load(idRes)
                .apply(options)
                .into(img);
    }

    public static void loadImageUrl(Context context, String url, ImageView img){
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.loading_thumbnail)
                .error(R.drawable.no_thumbnail);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(img);
    }

}
