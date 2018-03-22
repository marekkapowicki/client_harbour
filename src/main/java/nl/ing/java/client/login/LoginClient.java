package nl.ing.java.client.login;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.io.IOException;

public class LoginClient {
    private final Retrofit retrofit;
    private static LoginClient instance;

    public LoginClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public LoginResponse login(String userName, String password) throws IOException {

        LoginService loginService = retrofit.create(LoginService.class);
        LoginRequest loginRequest = new LoginRequest(userName,password);
        Call<LoginResponse> login = loginService.login(loginRequest);

        Response<LoginResponse> pps = login.execute();
        if (pps.isSuccessful()) {
            return pps.body();
        }
        throw new RuntimeException();
    }

    public static LoginClient build(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instance = new LoginClient(retrofit);
        return instance;
    }

    public interface LoginService {
        @POST("login")
        Call<LoginResponse> login(@Body LoginRequest body);
    }

}
