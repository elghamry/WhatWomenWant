package user.android.whatwomenwant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ELGHAMRY on 07/08/2016.
 */
public class SelectionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.selection_fragment, container, false);


        ImageView Fifa , NBA , NHL , USopen , USAboxing , MLB , Nascar , NFL , UFC ;
        Fifa = (ImageView)rootView.findViewById(R.id.fifa);
        NBA = (ImageView) rootView.findViewById(R.id.nba);
        NHL = (ImageView) rootView.findViewById(R.id.nhl);
        USopen = (ImageView)rootView.findViewById(R.id.usopen);
        USAboxing = (ImageView)rootView.findViewById(R.id.usaboxing);
        MLB = (ImageView)rootView.findViewById(R.id.mlb);
        Nascar = (ImageView) rootView.findViewById(R.id.nascar);
        NFL=(ImageView)rootView.findViewById(R.id.nfl);
        UFC=(ImageView)rootView.findViewById(R.id.ufc);

        Fifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+fifa";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        NBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+NBA";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });


        NHL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+NHL";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        USAboxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+USA+boxing";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        USopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+US+open";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        MLB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+MLB";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        Nascar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+Nascar";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        NFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+NFL";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });

        UFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter="+UFC";
                Intent i = new Intent(getActivity(),VoiceRecognitionActivity.class);
                i.putExtra("filter",filter);
                startActivity(i);
            }
        });






        return rootView;
    }
}
