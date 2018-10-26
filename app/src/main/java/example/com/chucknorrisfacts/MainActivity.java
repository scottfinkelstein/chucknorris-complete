package example.com.chucknorrisfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getRandomFact();
            }
        });
        getRandomFact();
    }

    private void getRandomFact() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.icndb.com/jokes/").addConverterFactory(GsonConverterFactory.create()).build();
        ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
        Call<ChuckNorrisFact> call = service.getFact();

        call.enqueue(new Callback<ChuckNorrisFact>() {
            @Override
            public void onResponse(Call<ChuckNorrisFact> call, Response<ChuckNorrisFact> response) {
                ChuckNorrisFact chuckNorrisFact = response.body();
                mTextView.setText(chuckNorrisFact.value.joke);
            }

            @Override
            public void onFailure(Call<ChuckNorrisFact> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting joke", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
