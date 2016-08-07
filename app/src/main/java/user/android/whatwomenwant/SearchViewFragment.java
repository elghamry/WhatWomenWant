package user.android.whatwomenwant;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by ELGHAMRY on 07/08/2016.
 */



public class SearchViewFragment extends Fragment {
    boolean mIntentInProgress;
    private final String BaseURL = "https://www.googleapis.com/customsearch/v1";
    RecyclerAdapter recAdap;
    ArrayList<SearchItem> ListData = new ArrayList<SearchItem>();

    private final String Key = "key";
    private final String Query="q";

    String searchVal;
    //* Request code used to invoke sign in user interactions. */
    private static final int RC_SIGN_IN = 0;
    private LocationManager locationManager;
    RecyclerView recSearch ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.searchview_fragment,container,false);
        recSearch = (RecyclerView)rootView.findViewById(R.id.search_view);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());


        recSearch.setLayoutManager(mLayoutManager);
        recSearch.setItemAnimator(new DefaultItemAnimator());


        recSearch.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));



        searchVal= Util.encodeSearchVal(getActivity().getIntent().getStringExtra("result"))+"+Sport";


        CustomSearchAsync asyn = new CustomSearchAsync();
        asyn.execute();
//        final Animation animAlpha2 = AnimationUtils.loadAnimation(this, R.anim.);

        recSearch.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recSearch, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                SearchItem item = ListData.get(position);
//                view.startAnimation(animAlpha2);
//send implicit intent to the browser or youtube app
                String url = item.getLink();
                Intent i = new Intent(getActivity(),searchActivity.class);
                i.putExtra("url",url);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return  rootView;
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
    String  JsonStr = null;
    public class CustomSearchAsync extends AsyncTask<Void, Void, Integer>

    {
        @Override

        protected Integer doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.

            Log.d("TAG", "doInBackground: ");


            Integer result = 0;
            try {

                Uri uribuilt = Uri.parse(BaseURL).buildUpon().appendQueryParameter(Key, "AIzaSyDj_wFLHy55Jf7jY_G2h4Slv5Jdpp1i9u0").appendQueryParameter("cx","004019765984473061859:amugdbzvngs").build();
                URL url = new URL(uribuilt.toString()+"&q="+searchVal);

                Log.d("TAG", "doInBackground: "+url);
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                JsonStr = buffer.toString();
                Log.d("searchAct", "onPostExecute: "+JsonStr);

                urlConnection.disconnect();

            } catch (IOException e) {


                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {

                    }
                }
            }

            parseSearchItems(JsonStr);
            result = 1;


            return result;
        }


        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI

            if (result == 1) {

                // successful json parsing



                recAdap= new RecyclerAdapter(ListData);
                recSearch.setAdapter(recAdap);






            } else {
                Toast.makeText(getActivity(), "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }


        }

        private void parseSearchItems(String result) {
            try {
                JSONObject result_data = new JSONObject(result);
                JSONArray posts = result_data.getJSONArray("items");

                for (int i = 0; i < posts.length(); i++) {
                    JSONObject post = posts.optJSONObject(i);
                    String title = post.getString("title");
                    String link = post.getString("link");
                    String snippet = post.getString("snippet");
                    JSONObject thumbJson = post.getJSONObject("pagemap");
                    JSONArray thumbJson1=thumbJson.getJSONArray("cse_image");
                    JSONObject thumbObj = thumbJson1.optJSONObject(0);

                    String thumb = thumbObj.getString("src");
//String thumb = "http://ask.fm/AbdElrahmanMohamedElghamry/avatar";
                    SearchItem item;
                    item = new SearchItem(title,link,snippet,thumb);

                    Log.d("welcome", "parseSearchItems: "+snippet);
                    ListData.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }
}
