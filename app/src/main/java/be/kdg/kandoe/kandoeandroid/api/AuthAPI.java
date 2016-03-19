package be.kdg.kandoe.kandoeandroid.api;

import be.kdg.kandoe.kandoeandroid.pojo.Credentials;
import be.kdg.kandoe.kandoeandroid.pojo.RegisterDetails;
import be.kdg.kandoe.kandoeandroid.pojo.Token;
import be.kdg.kandoe.kandoeandroid.pojo.request.RegistratieRequest;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 *  interface om de auth web api aan te spreken
 */
public interface AuthAPI {
    @POST("auth/login")
    Call<Token> login(@Body Credentials credentials);

    @POST("auth/register")
    Call<Void> register(@Body RegistratieRequest registratieRequest);
}
