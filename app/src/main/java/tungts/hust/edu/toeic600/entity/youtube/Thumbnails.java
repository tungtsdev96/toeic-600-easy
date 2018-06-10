package tungts.hust.edu.toeic600.entity.youtube;

public class Thumbnails {


    ThumbnailsSize medium;

    public ThumbnailsSize getMedium() {
        return medium;
    }

    public void setMedium(ThumbnailsSize medium) {
        this.medium = medium;
    }

    public class ThumbnailsSize {
        String url;
        int width;
        int height;

        ThumbnailsSize(String url, int width, int height) {
            this.url = url;
            this.width = width;
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
