package com.dagestan.airline;

import com.dagestan.airline.config.LoggerConfiguration;
import com.dagestan.airline.constant.Airline;
import com.dagestan.airline.constant.City;
import com.dagestan.airline.constant.FlightClass;
import com.dagestan.airline.handler.FlightRequestHandler;
import com.dagestan.airline.handler.ViewHandler;
import com.dagestan.airline.model.Flight;
import com.dagestan.airline.repository.FlightsRepository;
import com.dagestan.airline.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Enclosed.class)
public class ServerTest {
    private static final String BASE_URL_PATTERN = "http://localhost:%d%s";
    private static OkHttpClient client;
    private static Server httpServer;
    private static int port;

    private static List<Flight> flightsList;

    @BeforeClass
    public static void setUp() throws Exception {
        LoggerConfiguration.init();

        client = new OkHttpClient();
        port = (int) (8000 + (Math.random() * 80));
        httpServer = new Server(port, 0);
        httpServer.start();


        Flight testFlightMoscowLondon = Flight.newBuilder()
                .setPrice(new BigDecimal("9999999"))
                .setAirline(Airline.AEROFLOT)
                .setDepartAirport(City.LONDON)
                .setArriveAirport(City.MOSCOW)
                .setDepartDate(LocalDate.parse("2021-10-19"))
                .setArriveDate(LocalDate.parse("2021-10-20"))
                .setFlightClass(FlightClass.BUSINESS)
                .build();

        Flight testFlightLondonDubai = Flight.newBuilder()
                .setPrice(new BigDecimal("9999999"))
                .setAirline(Airline.EMIRATES)
                .setDepartAirport(City.LONDON)
                .setArriveAirport(City.DUBAI)
                .setDepartDate(LocalDate.parse("2021-10-19"))
                .setArriveDate(LocalDate.parse("2021-10-20"))
                .setFlightClass(FlightClass.BUSINESS)
                .build();


        flightsList = new ArrayList<>();
        flightsList.add(testFlightLondonDubai);
        flightsList.add(testFlightMoscowLondon);
    }

    public static class SingleTests {

        @Test
        public void testSuccessServerResponseOnTicketsSearchRequest() throws IOException {
            httpServer.createContext("/tickets/search", new FlightRequestHandler(new FlightService(new FlightsRepository())));

            Request request = new Request.Builder()
                    .url(String.format(BASE_URL_PATTERN, port, "/tickets/search"))
                    .build();
            Response response = client.newCall(request).execute();

            assertThat(response.code()).isEqualTo(200);
        }

        @Test
        public void testSuccessServerResponseOnTicketsRequest() throws IOException {
            httpServer.createContext("/tickets", new ViewHandler());
            Request request = new Request.Builder()
                    .url(String.format(BASE_URL_PATTERN, port, "/tickets"))
                    .build();
            Response response = client.newCall(request).execute();

            assertThat(response.code()).isEqualTo(200);
        }

    }

    @RunWith(Parameterized.class)
    public static class ParametrizedTests {

        @Parameterized.Parameter()
        public Object input;

        @Parameterized.Parameters
        public static Collection data() {
            return Arrays.asList(new Object[][]{
                    {"/tickets/search&departAirport=london"},
                    {"/tickets/search&departAirport=london&airlines=Emirates"},
                    {"/tickets/search&departAirport=london&airlines=Emirates&price=9999999"},
                    {"/tickets/search&departAirport=london&airlines=Emirates&price=9999999&arriveAirport=Dubai"},
                    {"/tickets/search&departAirport=london&airlines=Emirates&price=9999999&" +
                            "arriveAirport=Dubai&flightClass=business"},
            });
        }

        @Test
        public void testResponseBodyWithParametrizedData() throws IOException {

            httpServer.createContext("/tickets/search", new FlightRequestHandler(new FlightService(new FlightTest(flightsList))));

            URL url = new URL(String.format(BASE_URL_PATTERN, port, input));
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            Flight flight = (mapper.readValue(url, Flight[].class)[0]);

            assertThat(flight).isEqualTo(flightsList.get(0));

//        assertThat(flight.getDepartAirport()).isEqualTo(City.LONDON);
//        assertThat(flight.getAirline()).isEqualTo(Airline.EMIRATES);
//        assertThat(flight.getPrice()).isEqualTo(new BigDecimal("9999999"));
//        assertThat(flight.getPrice()).isEqualTo(new BigDecimal("9999999"));
//        assertThat(flight.getArriveAirport()).isEqualTo(City.DUBAI);
//        assertThat(flight.getFlightClass()).isEqualTo(FlightClass.BUSINESS);
//        assertThat(flight.getDepartDate()).isEqualTo(LocalDate.parse("2021-10-19"));
//        assertThat(flight.getDepartDate()).isEqualTo(LocalDate.parse("2021-10-20"));
        }
    }

    @AfterClass
    public static void tearDown() {
        httpServer.stop(0);
    }
}