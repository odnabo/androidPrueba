package cl.neoxcore.androiddemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.neoxcore.androiddemo.R;
import cl.neoxcore.androiddemo.api.entity.LocationEntity;

/**
 * Created by ob_barbara on 20-01-18.
 */

public class LocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public List<LocationEntity> listLoc =new ArrayList<>();

    public LocationAdapter() { }

    @Override
    public int getItemCount() {
        return listLoc.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loc_item, parent, false);
        ViewHolderMatch holder = new ViewHolderMatch(view);

        holder.v = view;
        holder.txtId = view.findViewById(R.id.txtId);
        holder.txtName = view.findViewById(R.id.txtName);
        holder.txtClimate = view.findViewById(R.id.txtClimate);
        holder.txtTerrain = view.findViewById(R.id.txtTerrain);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ViewHolderMatch h = (ViewHolderMatch) holder;
        h.txtId.setText(listLoc.get(position).id);
        h.txtName.setText(listLoc.get(position).name);
        h.txtClimate.setText(listLoc.get(position).climate);
        h.txtTerrain.setText(listLoc.get(position).terrain);
    }


    public void setData(List<LocationEntity> listaLoc) {
        this.listLoc.addAll(listaLoc);

    }

    class ViewHolderMatch extends RecyclerView.ViewHolder {

        public View v;
        public TextView txtId, txtName, txtClimate, txtTerrain;


        public ViewHolderMatch(View itemView) {
            super(itemView);
        }
    }
}
