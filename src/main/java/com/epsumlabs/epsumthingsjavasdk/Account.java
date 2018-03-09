/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epsumlabs.epsumthingsjavasdk;

import java.net.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Epsum Labs
 */
public class Account {
       private String userName;
   private String secretKey;
   private String accessToken=null;
   private String appId;
    public Account(String username,String secretkey,String appid) throws IOException, MalformedURLException, ParseException{
        this.userName = username;
        this.secretKey = secretkey;
        this.appId = appid;
        login();
        
    }
    public String getUserName() 
    {
        return this.userName;
    }
    public void setusername(String user)
    {
        this.userName=user;
    }
    public String getSecretKey() 
    {
        return this.secretKey;
    }
    public void setSecretKey(String sectret)
    {
        this.secretKey=sectret;
    }
    public String getAccessToken()
    {
        return this.accessToken;
    }
    public void setAccessToken(String auth)
    {
        this.accessToken=auth;
    }
    public String getAppId()
    {
        return this.appId;
    }
    public void setAppId(String aid)
    {
        this.appId=aid;
    }
    /**
     * This is used to login to the system and generate access token
     *
     * 
     * @return access token of the user
     * 
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     */
    public String login() throws MalformedURLException, IOException, ParseException
    {
        URL url = new URL("http://things.epsumlabs.com/api/world/user/login?app_id="+getAppId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("user", getUserName());
        con.setRequestProperty("secret", getSecretKey());
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) 
        {
            response.append(inputLine);
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject jobj = (JSONObject)parser.parse(response.toString());
        this.accessToken=jobj.get("access_token").toString();
        return this.accessToken;
    }
}
