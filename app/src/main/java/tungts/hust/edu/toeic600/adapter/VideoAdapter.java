package tungts.hust.edu.toeic600.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import tungts.hust.edu.toeic600.R;
import tungts.hust.edu.toeic600.entity.Lesson;
import tungts.hust.edu.toeic600.entity.youtube.ItemVideo;
import tungts.hust.edu.toeic600.utils.GlideHelper;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewholder> {

    Context context;
    ArrayList<ItemVideo> itemVideos;
    RecyclerView rcv;
    LayoutInflater layoutInflater;

    public VideoAdapter(Context context, ArrayList<ItemVideo> itemVideos, RecyclerView rcv){
        this.context = context;
        this.itemVideos = itemVideos;
        this.rcv = rcv;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VideoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewholder(layoutInflater.inflate(R.layout.item_video, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewholder holder, int position) {
        ItemVideo itemVideo = itemVideos.get(position);
        GlideHelper.loadImageUrl(context, itemVideo.getSnippet().getThumbnails().getMedium().getUrl(), holder.img_video);
    }

    @Override
    public int getItemCount() {
        return itemVideos.size();
    }


    protected class VideoViewholder extends BaseViewHolder{

        @BindView(R.id.img_video)
        ImageView img_video;

        public VideoViewholder(View itemView) {
            super(itemView);
        }
    }

}
