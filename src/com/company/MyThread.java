package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyThread extends Thread {


    @Override
    public void run() {
        String bodyPath = "src/soapXml.xml";
        String endPoint = "http://localhost:8080/world";
        Zapros zapros = new Zapros(bodyPath, endPoint);
        try {
            zapros.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("запрос "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" "+Thread.currentThread().getName()+ " i = "+i);
            try {
                zapros.action();
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

