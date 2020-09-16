package com.example.coronatracker.network;

import com.example.coronatracker.bean.CountryBean;
import com.example.coronatracker.bean.CovidRecordBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoronaApiService {

    @GET("/api")
    Call<CovidRecordBean> getCovidData();

    @GET("api/countries")
    Call<CountryBean> getCountries();

    @GET("api/countries/{country}")
    Call<CovidRecordBean> getCountryCovidRecord(@Path("country") String country);
}
