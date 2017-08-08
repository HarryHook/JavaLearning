package com.designpatterns.observe;

public class WeatherStation {

    public static void main(String[] args) {
	WeatherData weatherData = new WeatherData();
	CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
	StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
	ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
	HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
	weatherData.setMeasurements(58, 72, 29.2f);
	weatherData.setMeasurements(80,  65,  30.4f);
	weatherData.setMeasurements(78, 98, 29.2f);
	
	weatherData.registerObserver(forecastDisplay);
	
    }

}
