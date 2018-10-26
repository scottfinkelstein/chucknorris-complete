package example.com.chucknorrisfacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChuckNorrisService {
    @GET("random")
    Call<ChuckNorrisFact> getFact();
}
