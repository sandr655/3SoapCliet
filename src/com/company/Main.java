package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int perevod20;
    static int perevod50;
    static int zp300;
    static int zp500;
    static int zp600;

    public static void main(String[] args) throws IOException, InterruptedException {

        Client k1 = new Client(123);
//        System.out.println("id "+ k1.getId()+" Name "+k1.getName()+" Date "+ k1.getDate()+" zp "+ k1.getZp()+" perevod "+ k1.getPer());
        Client k2 = new Client(125);
//        System.out.println("id "+ k2.getId()+" Name "+k2.getName()+" Date "+ k2.getDate()+" zp "+ k2.getZp()+" perevod "+ k2.getPer());
        Client k3 = new Client(124);
//        System.out.println("id "+ k3.getId()+" Name "+k3.getName()+" Date "+ k3.getDate()+" zp "+ k3.getZp()+" perevod "+ k3.getPer());
        Client k4 = new Client(1);
//        System.out.println("id "+ k4.getId()+" Name "+k4.getName()+" Date "+ k4.getDate()+" zp "+ k4.getZp()+" perevod "+ k4.getPer());
        Client k5 = new Client(9999);
//        System.out.println("id "+ k5.getId()+" Name "+k5.getName()+" Date "+ k5.getDate()+" zp "+ k5.getZp()+" perevod "+ k5.getPer());
//        System.out.println("id "+ k1.getId()+" Name "+k1.getName()+" Date "+ k1.getDate()+" zp "+ k1.getZp()+" perevod "+ k1.getPer());

        for(int id = 1000; id <= 99000; id++){
            Client k6 = new Client(id);
            int p = k6.getPer();
            int z = k6.getZp();

            if (z < 300){
                zp300++;
            }
            else if(z > 499){
                zp600++;
            }
            else {
                zp500++;
            }

            if (p < 20) {
                perevod20++;
            }
            else {
                perevod50++;
            }
        }
//        System.out.println(zp300+" клиентов имеют зарплату до 300");
//        System.out.println(zp500+" клиентов имею зарплату от 300 до 500");
//        System.out.println(zp600+" клиентов имеют зарплату от 500 до 600");
//        System.out.println(perevod20+" переводов меньше 20");
//        System.out.println(perevod50+" переводов меньше 50");

//        Zapros c1 = new Zapros("src/soapXml.xml", "http://localhost:8080/world");

        new MyThread().start();
        Thread.sleep(1000);
        new MyThread().start();


    }
}