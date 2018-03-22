package nl.ing.java.client.customer;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.io.IOException;

public class CustomerClient {
    private static CustomerClient instance;
    private final Retrofit retrofit;

    public CustomerClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public CustomerResponse getContainersByEmail(String email) throws IOException {
        CustomerService service = retrofit.create(CustomerService.class);
        Call<CustomerResponse> action = service.getContainersByEmail(email);
        Response<CustomerResponse> result = action.execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        throw new IllegalStateException("execution error");

    }

    public Container containerDetail(String email, String containerId) throws IOException {
        CustomerService service = retrofit.create(CustomerService.class);
        Call<Container> action = service.getContainerDetails(email, containerId);
        Response<Container> result = action.execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        throw new IllegalStateException("execution error");

    }

    public boolean changeStatus(String email, String containerId, String newStatus) throws IOException {
        CustomerService service = retrofit.create(CustomerService.class);
        Call<Void> action = service.changeStatus(email, containerId, newStatus);
        Response<Void> result = action.execute();
        return result.isSuccessful();
    }

    public static CustomerClient build(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instance = new CustomerClient(retrofit);
        return instance;
    }

    public interface CustomerService {
        @GET("customers/{email}")
        @Headers({"content-type: application/json"})
        Call<CustomerResponse> getContainersByEmail(@Path("email") String email);

        @GET("customers/{email}/containers/{containerId}")
        @Headers({"content-type: application/json"})
        Call<Container> getContainerDetails(@Path("email") String email, @Path("containerId") String containerId);

        @PUT("customers/{email}/containers/{containerId}/{newStatus}")
        @Headers({"content-type: application/json"})
        Call<Void> changeStatus(@Path("email") String email, @Path("containerId") String containerId,
                                     @Path("newStatus") String newStatus);

    }
}
