package com.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;

import com.force.api.ApiConfig;
import com.force.api.Auth;
import com.force.api.AuthorizationRequest;
import com.force.api.ForceApi;
import com.force.api.ApiSession;
import com.force.api.Identity;
import com.force.api.http.HttpRequest;
import com.force.api.http.HttpRequest.Header;
import com.force.api.http.HttpRequest.ResponseFormat;
import com.force.api.http.HttpResponse;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.PostMethod;

public class SalesForceApi {
	
	   public static ForceApi forceApi;
	    private static Logger logger = Logger.getLogger(SalesForceApi.class);
	    public static String authToken = null;
	    public static String refreshToken = null;
	    public static ApiConfig config = null;
	    @SuppressWarnings("null")
	    public static ForceApi getForceApi() {
	        if (forceApi != null){
	            return forceApi;
	        }

	        ApiSession session = new ApiSession();
	        config = new ApiConfig();
	        config.setLoginEndpoint(System.getenv("LoginEndpoint"));
	        config.setUsername(System.getenv("username"));
	        config.setPassword(System.getenv("Password"));
	        config.setClientId(System.getenv("ClientId"));
	        config.setClientSecret(System.getenv("ClientSecret"));
	  
		    
	        forceApi = new ForceApi(config);
	        session = Auth.authenticate(config);
	        System.out.println("forceApi:::"+session.getAccessToken());
	        authToken = session.getAccessToken().toString();
	        return forceApi;

	    }
}
