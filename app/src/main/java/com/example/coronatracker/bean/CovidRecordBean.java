package com.example.coronatracker.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CovidRecordBean {

    @SerializedName("confirmed")
    @Expose
    private Confirmed confirmed;
    @SerializedName("recovered")
    @Expose
    private Recovered recovered;
    @SerializedName("deaths")
    @Expose
    private Deaths deaths;
    @SerializedName("dailySummary")
    @Expose
    private String dailySummary;
    @SerializedName("dailyTimeSeries")
    @Expose
    private DailyTimeSeries dailyTimeSeries;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("countries")
    @Expose
    private String countries;
    @SerializedName("countryDetail")
    @Expose
    private CountryDetail countryDetail;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;

    public Confirmed getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Confirmed confirmed) {
        this.confirmed = confirmed;
    }

    public Recovered getRecovered() {
        return recovered;
    }

    public void setRecovered(Recovered recovered) {
        this.recovered = recovered;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public String getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(String dailySummary) {
        this.dailySummary = dailySummary;
    }

    public DailyTimeSeries getDailyTimeSeries() {
        return dailyTimeSeries;
    }

    public void setDailyTimeSeries(DailyTimeSeries dailyTimeSeries) {
        this.dailyTimeSeries = dailyTimeSeries;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public CountryDetail getCountryDetail() {
        return countryDetail;
    }

    public void setCountryDetail(CountryDetail countryDetail) {
        this.countryDetail = countryDetail;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public class Deaths {

        @SerializedName("value")
        @Expose
        private Integer value;
        @SerializedName("detail")
        @Expose
        private String detail;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

    }

    public class Confirmed {

        @SerializedName("value")
        @Expose
        private Integer value;
        @SerializedName("detail")
        @Expose
        private String detail;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

    }

    public class CountryDetail {

        @SerializedName("pattern")
        @Expose
        private String pattern;
        @SerializedName("example")
        @Expose
        private String example;

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

    }

    public class DailyTimeSeries {

        @SerializedName("pattern")
        @Expose
        private String pattern;
        @SerializedName("example")
        @Expose
        private String example;

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

    }

    public class Recovered {

        @SerializedName("value")
        @Expose
        private Integer value;
        @SerializedName("detail")
        @Expose
        private String detail;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

    }
}
