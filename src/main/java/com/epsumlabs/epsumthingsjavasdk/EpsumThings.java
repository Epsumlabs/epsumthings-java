/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epsumlabs.epsumthingsjavasdk;

import java.util.HashMap;
import java.net.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Epsum Labs Private Limited
 */
public class EpsumThings {

    private static final String BaseUrl = "http://things.epsumlabs.com/api";
    private static HashMap<String, String> serverResponse = new HashMap<>();

    /**
     * This function is used to Display EpsumThings Profile
     *
     * @param user object of the Account class
     * @return the HashMap of the user profile details
     * 
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap userProfile(Account user) throws IOException, MalformedURLException, ParseException {
        URL url = new URL(BaseUrl + "/world/user/profile?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This function is used to update user profile 
     *
     * @param user object of the Account class
     * @param fields stores the fields which are to be updated
     * example:-phone,social
     * @param parameter HashMap of the user profile to update example:-
     * {"phone": "8328857891"}
     * 
     * 
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     * 
     * @return HashMap of the request
     */
    public static HashMap updateProfile(Account user, String fields, HashMap parameter) throws IOException, MalformedURLException, ParseException {
        URL url = new URL(BaseUrl + "/world/user/updateprofile?app_id=" + user.getAppId() + "&fields=" + fields);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(parameter.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to add user configuration
     *
     * @param user object of the Account class
     * @param configure HashMap of the configure user example:- {"homes":"test"}
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
   /* public static HashMap settings(Account user, HashMap configure) throws IOException, MalformedURLException, ParseException {
        URL url = new URL(BaseUrl + "/world/user/settings?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(configure.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }*/

    /**
     * This is used to get user configuration
     *
     * @param user object of the Account class
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    /*public static HashMap getSettings(Account user) throws IOException, MalformedURLException, ParseException {
        URL url = new URL(BaseUrl + "/world/user/settings?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }*/

    /**
     * This is used to get user configuration 
     *
     * @param user object of the Account class
     * @param configure store the HashMap of the Thing Configuration
     * example:-{"thingid": "string","thingname": "string"}
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap configureThings(Account user, HashMap configure) throws IOException, MalformedURLException, ParseException {
        URL url = new URL(BaseUrl + "/world/thing/config?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(configure.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to Update Password
     *
     * @param user object of the Account class
     * @param newpassword store the New Password
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap updatePassword(Account user, String newpassword) throws IOException, MalformedURLException, ParseException {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("password", newpassword);
        URL url = new URL(BaseUrl + "/world/updatepassword?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(body.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to send the OTP to the user 
     *
     * @param email stores the user email
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap forgotPasswordStep1(String email) throws IOException, MalformedURLException, ParseException {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("email", email);
        URL url = new URL(BaseUrl + "/world/forgot1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(body.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to set new password
     *
     * @param email stores the user email
     * @param token stores the token
     * @param newpassword stores the new password
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     * 
     */
    public static HashMap forgotPasswordStep2(String email, String token, String newpassword) throws MalformedURLException, IOException, ParseException 
    {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("email", email);
        body.put("token", token);
        body.put("newpassword", newpassword);
        URL url = new URL(BaseUrl + "/world/forgot2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(body.toString().getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to get the activity log of the user
     *
     * @param user object of the Account Class
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap activity(Account user) throws MalformedURLException, IOException, ParseException {
        URL url = new URL(BaseUrl + "/world/activity?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to control Thing
     *
     * @param user object of the Account Class
     * @param thingid stores the thing id
     * @param control stores the HashMap of the thing configuration
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap controlThing(Account user, String thingid, HashMap control) throws MalformedURLException, IOException, ParseException {
        URL url = new URL(BaseUrl + "/world/thing/rw/" + thingid + "?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        String s="{\"config\":[{\"name\":\"pin1\", \"type\":\"analog\", \"desc\":\"sensor\"}], \"thingid\":\"EP0008\"}";
        System.out.print(s);
        os.write(s.getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }

    /**
     * This is used to thing Details
     *
     * @param user object of the Account Class
     * @param thingid stores the thing id
     * 
     * @return HashMap of the request
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public static HashMap thingDetails(Account user, String thingid) throws MalformedURLException, IOException, ParseException {
        URL url = new URL(BaseUrl + "/world/thing/rw/" + thingid + "?app_id=" + user.getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", user.getUserName() + ";" + user.getAccessToken());
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject) parser.parse(response.toString());
        serverResponse = (JSONObject) jobj;
        return serverResponse;
    }
}
