package user.android.whatwomenwant;

/**
 * Created by ELGHAMRY on 22/07/2016.
 */
public class SearchItem {


    String title , link , snippet , thumb;

    public SearchItem(String title, String link, String snippet, String thumb) {
        this.title = title;
        this.link = link;
        this.snippet = snippet;
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }


}
