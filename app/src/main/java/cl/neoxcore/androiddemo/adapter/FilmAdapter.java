package cl.neoxcore.androiddemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.neoxcore.androiddemo.R;

/**
 * Created by Fabian Baez on 20-01-18.
 * www.neoxcore.cl
 */

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public FilmAdapter() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        ViewHolderMatch holder = new ViewHolderMatch(view);

        holder.v = view;


        return holder;

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ViewHolderMatch h = (ViewHolderMatch) holder;

    }


    class ViewHolderMatch extends RecyclerView.ViewHolder {

        public View v;


        public ViewHolderMatch(View itemView) {
            super(itemView);
        }
    }


}