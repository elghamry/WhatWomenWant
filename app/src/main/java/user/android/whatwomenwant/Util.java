package user.android.whatwomenwant;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ELGHAMRY on 13/07/2016.
 */
public class Util {

    public static String encodeSearchVal(String searchVal) {
        return searchVal.replace(" ", "+");
    }


}
