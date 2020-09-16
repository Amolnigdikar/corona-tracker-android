package com.example.coronatracker.activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.daasuu.cat.CountAnimationTextView;
import com.example.coronatracker.R;
import com.example.coronatracker.bean.CountryBean;
import com.example.coronatracker.bean.CovidRecordBean;
import com.example.coronatracker.network.CoronaApiService;
import com.example.coronatracker.network.RetrofitClientInstance;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private CardView infected, recovered, deaths;
    private CountAnimationTextView infected_cases, recovered_cases, death_cases;
    private TextView lastUpdatedInnfected, lastUpdatedRecovered, lastUpdatedDeath;
    private ProgressDialog progressDialog;
    private CoronaApiService service;
    private Spinner spinner;
    private List<String> countries=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infected = findViewById(R.id.confirmed_card_view);
        recovered = findViewById(R.id.recovered_card_view);
        deaths = findViewById(R.id.deaths_card_view);

        infected_cases = findViewById(R.id.confirmed_cases);
        recovered_cases = findViewById(R.id.recovered_cases);
        death_cases = findViewById(R.id.death_cases);
        spinner=findViewById(R.id.country_spinner);
        spinner.setOnItemSelectedListener(this);

        lastUpdatedInnfected = findViewById(R.id.last_updated_date);
        lastUpdatedRecovered = findViewById(R.id.last_updated_date_recovered);
        lastUpdatedDeath = findViewById(R.id.last_updated_date_deaths);
        getCountries();
        getCovidData();
        progressDialog.dismiss();
    }

    private void getCountries() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        service = RetrofitClientInstance.getRetrofitInstance().create(CoronaApiService.class);

        Call<CountryBean> response = service.getCountries();

        response.enqueue(new Callback<CountryBean>() {
            @Override
            public void onResponse(Call<CountryBean> call, Response<CountryBean> response) {
                progressDialog.dismiss();
                loadSpinner(response.body());
            }

            @Override
            public void onFailure(Call<CountryBean> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSpinner(CountryBean body) {
        countries.add("Global");
        for(CountryBean.Country country:body.getCountries()){
            countries.add(country.getName());
        }

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countries);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
    }

    private void getCovidData() {
        progressDialog.show();
        service = RetrofitClientInstance.getRetrofitInstance().create(CoronaApiService.class);

        Call<CovidRecordBean> response = service.getCovidData();

        response.enqueue(new Callback<CovidRecordBean>() {
            @Override
            public void onResponse(Call<CovidRecordBean> call, Response<CovidRecordBean> response) {
                progressDialog.dismiss();
                if (response.body() != null) {
                    fillUi(response.body());
                }
            }

            @Override
            public void onFailure(Call<CovidRecordBean> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillUi(CovidRecordBean body) {

        infected_cases.setDecimalFormat(new DecimalFormat("###,###,###")).setAnimationDuration(3000).countAnimation(0, body.getConfirmed().getValue());
        recovered_cases.setDecimalFormat(new DecimalFormat("###,###,###")).setAnimationDuration(3000).countAnimation(0, body.getRecovered().getValue());
        death_cases.setDecimalFormat(new DecimalFormat("###,###,###")).setAnimationDuration(3000).countAnimation(0, body.getDeaths().getValue());


        lastUpdatedInnfected.setText(body.getLastUpdate().split("T")[0]);
        lastUpdatedRecovered.setText(body.getLastUpdate().split("T")[0]);
        lastUpdatedDeath.setText(body.getLastUpdate().split("T")[0]);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(!parent.getItemAtPosition(position).toString().equals("Global")){
            String country = parent.getItemAtPosition(position).toString();
            progressDialog.show();

            Call<CovidRecordBean> response=service.getCountryCovidRecord(country);
            response.enqueue(new Callback<CovidRecordBean>() {
                @Override
                public void onResponse(Call<CovidRecordBean> call, Response<CovidRecordBean> response) {
                    progressDialog.dismiss();
                    fillUi(response.body());
                }

                @Override
                public void onFailure(Call<CovidRecordBean> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            getCovidData();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}