package com.example.tapngo.Backend;

import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest {

    //This function is used to fetch data from server according to provided url
    public static List<StationData> executeGet() {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL("https://api.irishrail.ie/realtime/realtime.asmx/getStationDataByNameXML?StationDesc=Dublin%20Connolly");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set request headers
            connection.setRequestProperty("Cache-Control", "private, max-age=0");
            connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

            InputStream is;
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)
                is = connection.getErrorStream();
            else
                is = connection.getInputStream();


            Log.d("CheckLogin",connection.getResponseMessage()+"");

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            List<StationData> stationDataList = parseRes(response.toString());
            return stationDataList;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("fetchError","Error: " + e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static List<StationData> parseRes(String xmlResponse) {
        InputStream inputStream = new ByteArrayInputStream(xmlResponse.getBytes());
        XMLParser xmlParser = new XMLParser();
        List<StationData> stationDataList = new ArrayList<>();
        try {
            stationDataList = xmlParser.parse(inputStream);

            Log.d("listSize",stationDataList.size()+"");
            // Now you have a list of StationData objects, you can use them as needed
            for (StationData stationData : stationDataList) {
                Log.d("data",stationData.getOrigin()+",  "+stationData.getOrigintime()+",  "+ stationData.getDestination()+", "+stationData.getDestinationtime()+",  "+stationData.getTraindate());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
        }
        return stationDataList;
    }


    public static String executeGet2() {
        final String API_URL = "https://api.irishrail.ie/realtime/realtime.asmx/getStationDataByNameXML?StationDesc=Dublin%20Connolly";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(API_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set request headers
            connection.setRequestProperty("Cache-Control", "private, max-age=0");
            connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

            int status = connection.getResponseCode();
            Log.d("fetchStatus","Status: " + status);

            if (status == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                String errorMessage = "Failed to fetch data. HTTP status code: " + status;
                Log.d("fetchError", errorMessage);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("fetchError", "Error: " + e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}


