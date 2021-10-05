package com.example.retrofitpostdataexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText nameEdt, jobEdt;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (nameEdt.getText().toString().isEmpty() && jobEdt.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(nameEdt.getText().toString(), jobEdt.getText().toString());
            }
        });
    }

    private void postData(String name, String job) {

        loadingPB.setVisibility(View.VISIBLE);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://reqres.in/api/").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitAPI retrofitAPI=retrofit.create(RetrofitAPI.class);
        DataModal modal=new DataModal(name,job);

        Call<DataModal> call=retrofitAPI.createPost(modal);

        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);

                jobEdt.setText("");
                nameEdt.setText("");

                DataModal responseFromAPI=response.body();

                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();

                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {

                responseTV.setText("Error found is : " + t.getMessage());

            }
        });
    }
}