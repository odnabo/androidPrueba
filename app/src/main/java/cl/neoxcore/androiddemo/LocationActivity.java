package cl.neoxcore.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cl.neoxcore.androiddemo.adapter.LocationAdapter;
import cl.neoxcore.androiddemo.api.NeoxCore;
import cl.neoxcore.androiddemo.api.entity.LocationEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        RecyclerView recyclerLoc = findViewById(R.id.recyclerLocation);
        final LocationAdapter adapterLoc = new LocationAdapter();
        recyclerLoc.setAdapter(adapterLoc);

        RecyclerView.LayoutManager managerLoc = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerLoc.setLayoutManager(managerLoc);

        Call<List<LocationEntity>> call = NeoxCore.getInstance().api.apiInterface.getLocations();

        call.enqueue(new Callback<List<LocationEntity>>() {

            @Override
            public void onResponse(Call<List<LocationEntity>> call, Response<List<LocationEntity>> response) {

                List<LocationEntity> lista= response.body();
                adapterLoc.setData(lista);
                adapterLoc.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<LocationEntity>> call, Throwable t) {

            }
        });
    }
}
