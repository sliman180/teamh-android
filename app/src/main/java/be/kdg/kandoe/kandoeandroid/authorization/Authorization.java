package be.kdg.kandoe.kandoeandroid.authorization;

import android.app.Activity;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import be.kdg.kandoe.kandoeandroid.R;
import be.kdg.kandoe.kandoeandroid.helpers.SharedPreferencesMethods;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class Authorization {
    public static Retrofit authorize(Activity activity){
        final String token = SharedPreferencesMethods.getFromSharedPreferences(activity, activity.getString(R.string.token));
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(  new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request newRequest =
                        chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + token).build();
                return chain.proceed(newRequest);
            }
        });

        return new Retrofit.Builder()
                .baseUrl("http://teamh-spring.herokuapp.com").client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
