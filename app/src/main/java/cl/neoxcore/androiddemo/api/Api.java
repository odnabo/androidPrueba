package cl.neoxcore.androiddemo.api;

import java.util.List;

import cl.neoxcore.androiddemo.api.entity.FilmEntity;
import cl.neoxcore.androiddemo.api.entity.LocationEntity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Fabian Baez on 08-06-15.
 * www.neoxcore.cl
 */
public class Api {

    public ApiInterface apiInterface;

    private static Api instance;


    public static Api getInstance(Retrofit restAdapter) {
        if (instance == null)
            instance = new Api(restAdapter);
        return instance;
    }

    public Api(Retrofit restAdapter) {
        apiInterface = restAdapter.create(ApiInterface.class);
    }


    public interface ApiInterface {


        @GET("films")
        Call<List<FilmEntity>> getFilms();

        @GET("locations")
        Call<List<LocationEntity>> getLocations();

    }
}
