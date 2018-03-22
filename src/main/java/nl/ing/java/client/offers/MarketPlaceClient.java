package nl.ing.java.client.offers;

import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.CustomerClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.io.IOException;

public class MarketPlaceClient {

    private static MarketPlaceClient instance;
    private final Retrofit retrofit;

    public MarketPlaceClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public OfferResponse getOffers(String destination) throws IOException {
        OfferService service = retrofit.create(OfferService.class);
        Call<OfferResponse> action = service.getOffers(destination);
        Response<OfferResponse> result = action.execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        throw new IllegalStateException("execution error");
    }

    public OfferResponse allOffers() throws IOException {
        OfferService service = retrofit.create(OfferService.class);
        Call<OfferResponse> action = service.allOffers();
        Response<OfferResponse> result = action.execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        throw new IllegalStateException("execution error");
    }

    public static MarketPlaceClient build(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instance = new MarketPlaceClient(retrofit);
        return instance;
    }

    public interface OfferService {
        @GET("market/api/offers")
        @Headers({"content-type: application/json"})
        Call<OfferResponse> allOffers();

        @GET("market/api/offers/{destination}")
        @Headers({"content-type: application/json"})
        Call<OfferResponse> getOffers(@Path("destination") String destination);
    }
}
