package tungts.hust.edu.toeic600.entity.youtube;

import java.util.ArrayList;

public class PlayListYoutube {

    private String kind;
    private String etag;
    private String nextPageToken;
    private String prevPageToken;
    ArrayList<ItemVideo> items;

    public PlayListYoutube() {
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }

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

    public ArrayList<ItemVideo> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemVideo> items) {
        this.items = items;
    }
}
