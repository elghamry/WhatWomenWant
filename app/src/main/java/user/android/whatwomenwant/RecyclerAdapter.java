package user.android.whatwomenwant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ELGHAMRY on 31/07/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    private List<SearchItem> SearhItemsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView snippet;
        public ImageView thumb;


        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            snippet=(TextView)view.findViewById(R.id.snippet) ;
            thumb = (ImageView) view.findViewById(R.id.thumb);
        }
    }

    public RecyclerAdapter(List<SearchItem> SearhItemsList) {
        this.SearhItemsList = SearhItemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchItem searchItem = SearhItemsList.get(position);
        holder.title.setText(searchItem.getTitle());
        holder.snippet.setText(searchItem.getSnippet());
        Picasso.with(holder.thumb.getContext()).load(searchItem.getThumb()).into(holder.thumb);

    }

    @Override
    public int getItemCount() {
        return SearhItemsList.size();
    }

    public void setSearhItemsList(List<SearchItem> searhItemsList){

        this.SearhItemsList = searhItemsList;
        this.notifyDataSetChanged();
}


}
