package cl.neoxcore.androiddemo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.List;
import cl.neoxcore.androiddemo.adapter.FilmAdapter;
import cl.neoxcore.androiddemo.api.NeoxCore;
import cl.neoxcore.androiddemo.api.entity.FilmEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recycler = findViewById(R.id.recycler);
        final FilmAdapter adapter = new FilmAdapter();
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);

        Call<List<FilmEntity>> call = NeoxCore.getInstance().api.apiInterface.getFilms();

        Button btn = findViewById(R.id.btnLocation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        });


        call.enqueue(new Callback<List<FilmEntity>>() {
            @Override
            public void onResponse(Call<List<FilmEntity>> call, Response<List<FilmEntity>> response) {

                List<FilmEntity> lista= response.body();
                adapter.setData(lista);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<FilmEntity>> call, Throwable t) {

                Log.d("API","nos fuimos a la B");

            }
        });
    }


}
