package cl.neoxcore.androiddemo.api;

import retrofit2.Retrofit;

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
/*

        @GET("films")
        void getInfo(Call<List<FilmEntity>> call);
*/


    }
}
