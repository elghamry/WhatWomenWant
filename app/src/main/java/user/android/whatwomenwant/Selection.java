package user.android.whatwomenwant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ELGHAMRY on 23/07/2016.
 */
public class Selection extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.selection_activity);
        getSupportFragmentManager().beginTransaction().add(R.id.selection_fragment,new SelectionFragment()).commit();








    }
}
