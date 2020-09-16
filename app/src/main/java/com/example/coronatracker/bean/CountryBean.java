package com.example.coronatracker.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryBean {

    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public class Country {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("iso2")
        @Expose
        private String iso2;
        @SerializedName("iso3")
        @Expose
        private String iso3;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso2() {
            return iso2;
        }

        public void setIso2(String iso2) {
            this.iso2 = iso2;
        }

        public String getIso3() {
            return iso3;
        }

        public void setIso3(String iso3) {
            this.iso3 = iso3;
        }

    }
}
