package user.android.whatwomenwant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ELGHAMRY on 13/07/2016.
 */
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        TextView con = (TextView)findViewById(R.id.continuee);
        ImageView img = (ImageView)findViewById(R.id.img);
       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VoiceAct = new Intent(HomeActivity.this,Selection.class);
                startActivity(VoiceAct);
                finish();

            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VoiceAct = new Intent(HomeActivity.this,Selection.class);
                startActivity(VoiceAct);
                finish();

            }
        });


    }
}
