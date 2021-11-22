package com.example.mylaundry.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mylaundry.API.APIRequestData;
import com.example.mylaundry.API.RetroServer;
import com.example.mylaundry.Adapter.AdapterData;
import com.example.mylaundry.Model.DataModel;
import com.example.mylaundry.Model.ResponseModel;
import com.example.mylaundry.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;
    private FloatingActionButton fabtambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        srlData = findViewById(R.id.swl_data);
        pbData = findViewById(R.id.pb_data);
        fabtambah = findViewById(R.id.fab_data);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }


            private void retrieveData() {
                pbData.setVisibility(View.VISIBLE);

                APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                Call<ResponseModel> tampildata = ardData.ardRetrieveData();

                tampildata.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        Toast.makeText(MainActivity.this, "Kode: " + kode + " | Pesan : " + pesan,
                                Toast.LENGTH_SHORT).show();

                        listData = response.body().getData();

                        adData = new AdapterData(MainActivity.this, listData);
                        rvData.setAdapter(adData);
                        adData.notifyDataSetChanged();

                        pbData.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Gagal Mengubungi Server",
                                Toast.LENGTH_SHORT).show();

                        pbData.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        fabtambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    private void retiveData() {
    }

}