package com.vinaylogics.learnadvancejava.servlets;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class DemoCookieExample {

    public static void main(String[] args) throws IOException {
        String urlString = "https://www.facebook.com";

        // Create a default system-wide CookieManager
        CookieManager cookieManager = new CookieManager();

        CookieHandler.setDefault(cookieManager);

        // Open a connection for the given URL
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        urlConnection.getContent();

        // Get CookieStore which is the default internal in-memory
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Retrieve all stored HttpCookies from CookieStore
        List<HttpCookie> cookies = cookieStore.getCookies();

        int cookieIdx = 0;

        // Iterate HttpCookie object
        for (HttpCookie ck : cookies) {

            System.out.println("------ Cookie." + ++cookieIdx + " -------");

            // Get the cookie name
            System.out.println("Cookie name: " + ck.getName());

            // Get the domain set for the cookie
            System.out.println("Domain: " + ck.getDomain());

            // Get the max age of the cookie
            System.out.println("Max age: " + ck.getMaxAge());

            // Get the path of the server
            System.out.println("Server path: " + ck.getPath());

            // Get boolean if the cookie is being restricted to a secure
            // protocol
            System.out.println("Is secured: " + ck.getSecure());

            // Gets the value of the cookie
            System.out.println("Cookie value: " + ck.getValue());

            // Gets the version of the protocol with which the given cookie is
            // related.
            System.out.println("Cookie protocol version: " + ck.getVersion());

        }
    }
}
