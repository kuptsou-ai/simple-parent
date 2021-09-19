package org.sonatype.mavenbook.weather;

import java.io.InputStream;

public class WeatherService {
    public String retrieveForecast(String cityName) throws Exception {
// Retrieve Data
        InputStream dataIn = new OpenWeatherRetriever().retrieve(cityName);
// Parse Data
        Weather weather = new OpenWeatherParser().parse(dataIn);
// Format (Print) Data
        return new WeatherFormatter().format(weather);
    }
}