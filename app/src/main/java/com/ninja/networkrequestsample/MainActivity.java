package com.ninja.networkrequestsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    private ListAdapter mListAdapter;
    private List<Repo> mRepos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = findViewById(R.id.rv_list);
        mListAdapter = new ListAdapter(mRepos);
        rv_list.setAdapter(mListAdapter);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        getDataFromNetwork();
    }

    private void getDataFromNetwork(){
        RetrofitManager.getService(Service.class).listRepos("nijandhan").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response != null && response.isSuccessful()){
                    mRepos.addAll(response.body());
                    mListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
