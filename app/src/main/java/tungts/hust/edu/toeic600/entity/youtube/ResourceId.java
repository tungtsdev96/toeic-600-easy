package tungts.hust.edu.toeic600.entity.youtube;

public class ResourceId {

    private String kind;
    private String videoId;

    public ResourceId() {
    }

    public ResourceId(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
