package user.android.whatwomenwant;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ELGHAMRY on 02/06/2016.
 */
public class MyAppWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}