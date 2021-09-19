package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeatherServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cityName = request.getParameter("city");
        WeatherService weatherService = new WeatherService();
        PrintWriter out = response.getWriter();
        try {
            out.println(weatherService.retrieveForecast(cityName));
        } catch (Exception e) {
            out.println("Error Retrieving Forecast: " + e.getMessage());
        }
        out.flush();
        out.close();
    }
}