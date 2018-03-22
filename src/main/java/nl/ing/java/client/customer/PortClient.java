package nl.ing.java.client.customer;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.io.IOException;
import java.util.List;

public class PortClient {
    private static PortClient instance;
    private final Retrofit retrofit;

    public PortClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
    public List<Shipment> getAll() throws IOException {
        PortService service = retrofit.create(PortService.class);
        Call<List<Shipment>> action = service.getAll();
        Response<List<Shipment>> result = action.execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        throw new IllegalStateException("execution error");

    }

    public static PortClient build(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instance = new PortClient(retrofit);
        return instance;
    }
    public interface PortService {
        @GET("shipments")
        @Headers({"content-type: application/json"})
        Call<List<Shipment>> getAll();
    }
}
