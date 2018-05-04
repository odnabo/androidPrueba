package cl.neoxcore.androiddemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.neoxcore.androiddemo.R;
import cl.neoxcore.androiddemo.api.entity.FilmEntity;

/**
 * Created by Fabian Baez on 20-01-18.
 * www.neoxcore.cl
 */

public class FilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<FilmEntity> arreglo =new ArrayList<>();


    public FilmAdapter() {
    }

    @Override
    public int getItemCount() {
        return arreglo.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        ViewHolderMatch holder = new ViewHolderMatch(view);

        holder.v = view;
        holder.txtId = view.findViewById(R.id.txtId);
        holder.txtTitle = view.findViewById(R.id.txtTitle);
        holder.txtDesc = view.findViewById(R.id.txtDesc);
        holder.txtDirector = view.findViewById(R.id.txtDirector);

        return holder;

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ViewHolderMatch h = (ViewHolderMatch) holder;
        h.txtId.setText(arreglo.get(position).id);
        h.txtTitle.setText(arreglo.get(position).title);
        h.txtDesc.setText(arreglo.get(position).description);
        h.txtDirector.setText(arreglo.get(position).director);

    }

    public void setData(List<FilmEntity> lista) {
        this.arreglo.addAll(lista);
    }


    class ViewHolderMatch extends RecyclerView.ViewHolder {

        public View v;
        public TextView txtId, txtTitle, txtDesc, txtDirector;


        public ViewHolderMatch(View itemView) {
            super(itemView);
        }
    }


}