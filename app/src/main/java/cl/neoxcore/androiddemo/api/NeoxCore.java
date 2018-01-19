package cl.neoxcore.androiddemo.api;


import cl.neoxcore.androiddemo.Sekai;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fabian Baez on 05-01-16.
 * www.neoxcore.cl
 */
public class NeoxCore {

    public Api api;

    private static Retrofit retrofit;

    private static NeoxCore instance;

    public static NeoxCore getInstance() {
        if (instance == null)
            instance = new NeoxCore();
        return instance;
    }

    /**
     *
     */
    public NeoxCore() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Sekai.apiBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = Api.getInstance(retrofit);

    }


    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
