package com.company;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Zapros {
    private  String bodyPath;
    private  String endPoint;
    private  String body;

    int Zp;
    String Name;
    int Id;
    int transfer;
    String body3;

    public void fillBody(){

        Random r = new Random();
        Client kl7 = new Client(r.nextInt(10000));
        Zp = kl7.getZp();
        Name = kl7.getName();
        Id = kl7.getId();
        transfer = kl7.getPer();

        DomParser domParser = new DomParser();
        domParser.parse(bodyPath, transfer);
        body = DomParser.body2;

        body = body.replace("ZP",  String.valueOf(kl7.getZp()));
        body = body.replace("NAME", kl7.getName());
        body = body.replace("ID", String.valueOf(kl7.getId()));
        body3 = body;

    }

    public  void init() throws IOException {
        body = Read.read(bodyPath);

    }
    public void action() throws IOException{

        fillBody();
        String responseString = "";
        String outputString = "";
        URL url = new URL(getEndPoint());
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput = body3;
//        System.out.println("проверка перед отправкой1 "+Thread.currentThread().getName()+body3);
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "getUserDetails";
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(isr);

        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        System.out.println("ответ "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" "+Thread.currentThread().getName()+outputString);

    }
    public void end(){

    }
    public Zapros(String bodyPath, String endPoint ){
        this.bodyPath = bodyPath;
        this.endPoint = endPoint;
    }
    public String getBodyPath() {
        return bodyPath;
    }

    public String getEndPoint() {
        return endPoint;
    }

}