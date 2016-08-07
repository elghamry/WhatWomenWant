package user.android.whatwomenwant;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SearchViewActivity extends AppCompatActivity   {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);




        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().add(R.id.searchview_fragment,new SearchViewFragment()).commit();





    }



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // Check if the key event was the Back button and if there's history
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
//            myWebView.goBack();
//           // myWebView.loadUrl("http://order.redrooster.com.au/");
//            return true;
//        }
//        // If it wasn't the Back key or there's no web page history, bubble up to the default
//        // system behavior (probably exit the activity)
//        myWebView.loadUrl("http://order.redrooster.com.au/");
//        return true;
//    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SearchViewActivity.this, VoiceRecognitionActivity.class)
                ;

        startActivity(intent);
        finish();

        super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    protected void onStart() {


        super.onStart();
    }

    protected void onStop() {



        super.onStop();
    }



    //check the network
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }



}
