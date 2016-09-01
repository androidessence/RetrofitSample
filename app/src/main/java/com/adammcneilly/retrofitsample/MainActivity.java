package com.adammcneilly.retrofitsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private PresidentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new PresidentAdapter(this, new Presidents());

        ListView listView = (ListView) findViewById(R.id.presidents_list_view);
        listView.setAdapter(adapter);

        getPresidents();
    }

    private void getPresidents() {
        PersonService service = PersonService.retrofit.create(PersonService.class);

        Call<Presidents> call = service.getPresidents();

        call.enqueue(new Callback<Presidents>() {
            @Override
            public void onResponse(Call<Presidents> call, Response<Presidents> response) {
                Log.v(LOG_TAG, "Received response: " + response.toString());
                adapter.swapPresidents(response.body());
            }

            @Override
            public void onFailure(Call<Presidents> call, Throwable t) {
                Log.v(LOG_TAG, t.getMessage());
            }
        });
    }
}
