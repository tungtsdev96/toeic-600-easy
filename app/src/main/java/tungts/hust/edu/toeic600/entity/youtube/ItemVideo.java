package tungts.hust.edu.toeic600.entity.youtube;

public class ItemVideo {

    private String kind;
    private String etag;
    private String id;
    private SnippetVideo snippet;
    private ContentDetailVideo contentDetails;

    public ItemVideo() {}

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SnippetVideo getSnippet() {
        return snippet;
    }

    public void setSnippet(SnippetVideo snippet) {
        this.snippet = snippet;
    }

    public ContentDetailVideo getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetailVideo contentDetails) {
        this.contentDetails = contentDetails;
    }

}
