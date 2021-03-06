package be.kdg.kandoe.kandoeandroid.api;

import java.util.List;

import be.kdg.kandoe.kandoeandroid.pojo.response.Deelname;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 *  interface om de deelname web api aan te spreken
 */
public interface DeelnameAPI {
    @POST("/api/cirkelsessies/{id}/deelnames")
    Call<Void> doeDeelname(@Path("id") String Id);

    @GET("/api/gebruikers/{id}/deelnames")
    Call<List<Deelname>> getDeelnamesGebruiker(@Path("id") String id);

    @GET("/api/cirkelsessies/{id}/deelnames")
    Call<List<Deelname>> getDeelnamesVanCirkelsessie(@Path("id") String id);
}
