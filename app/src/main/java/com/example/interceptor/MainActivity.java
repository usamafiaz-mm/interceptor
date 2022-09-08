package com.example.interceptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Api.getClient().getResults().enqueue(new Callback<Quote>() {
    @Override
    public void onResponse(Call<Quote> call, Response<Quote> response) {
        System.out.println(" in on response \n\n\n" +  response.headers());
    }

    @Override
    public void onFailure(Call<Quote> call, Throwable t) {

    }
});
            }
        });

    }
}