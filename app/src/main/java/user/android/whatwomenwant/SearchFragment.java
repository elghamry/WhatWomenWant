package user.android.whatwomenwant;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by ELGHAMRY on 07/08/2016.
 */
public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_fragment, container, false);
        WebView myWebView;

        myWebView = (WebView) rootView.findViewById(R.id.webview);

        myWebView.setWebViewClient(new MyAppWebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());


        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webSettings.setUseWideViewPort(true);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);


        String url = getActivity().getIntent().getStringExtra("url");
        if(isNetworkConnected()){
            myWebView.loadUrl(url);}
        else
        {
            Context context = getActivity().getApplicationContext();
            CharSequence text = "Please check the Internet connection ...";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }





        return rootView;

    }


    //check the network
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
