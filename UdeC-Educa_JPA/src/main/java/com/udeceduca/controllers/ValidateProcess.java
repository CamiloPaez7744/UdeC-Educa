/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udeceduca.controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author RAF
 */
public class ValidateProcess {

    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    public static final String secreto = "6LcUA4YaAAAAAKYUmyYQV_JU0myA6-fElVnhDftR";
    private final static String USER_AGENT = "Mozilla/5.0";

    public static boolean verificar(String gRecaptchaResponse) throws IOException {
        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        } else {
            return true;
        }
    }
}
