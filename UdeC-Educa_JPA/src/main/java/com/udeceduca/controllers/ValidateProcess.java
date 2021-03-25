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

public class ValidateProcess {

    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    public static final String secreto = "6LdGEoYaAAAAACoi6MLLpDSTxGfuTtlqDEySRIQx";
    private final static String USER_AGENT = "Chromium: 89.0.4389.90";

    public static boolean verificar(String gRecaptchaResponse) throws IOException {
        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        }
        try {

            //Creación de url
            URL obj = new URL(url);
            //Establece conexion al servidor
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            //Propiedades
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            String postParams = "secret=" + secreto + "&response=" + gRecaptchaResponse;
            con.setDoOutput(true);

            //Cuando se habla de "Stream" se refiere a un flujo de Beats
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            //Monitorear la respuesta
            int responseCode = con.getResponseCode();
            System.out.println("Enviando 'POST' peticion a URL : " + url);
            System.out.println("Parametros post : " + postParams);
            System.out.println("Codigo de respuesta : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer respuesta = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                respuesta.append(inputLine);
            }
            in.close();
            System.out.println(respuesta.toString());

            //La respuesta
            JsonReader jsonReader = Json.createReader(new StringReader(respuesta.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            //Comparacion con la peticion efectuada por el cliente
            return jsonObject.getBoolean("success");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
