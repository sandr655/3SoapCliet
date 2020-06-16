package com.company;

import java.text.DecimalFormat;
import java.util.Random;

public class FunctionForClient {

    public static int Perevod(int id) {
        int per = 0;
        Random r = new Random();
        int pe = r.nextInt(100);
        if (pe < 60) {
            int minR = 1;
            int maxR = 20;
            Random ran = new Random();
            per = minR + ran.nextInt(maxR - minR);
        }
        else {
            int minR = 20;
            int maxR = 51;
            Random ran = new Random();
            per = minR + ran.nextInt(maxR - minR);
        }
        return per;
    }

    public static String Date(int id){
        String date;
        DecimalFormat decimalFormat = new DecimalFormat("00");
        Random random = new Random(id);
        int minY = 1950;
        int maxY = 2020;
        int minD = 1;
        int maxD = 31;
        int minM = 1;
        int maxM = 13;
        int yyyy = minY + random.nextInt(maxY - minY);
        int dd = minD + random.nextInt(maxD - minD);
        int mm = minM + random.nextInt(maxM - minM);
        date = decimalFormat.format(dd)+"."+decimalFormat.format(mm)+"."+yyyy;
        return date;
    }

    public static int ZP(int id) {
        int zp = 0;
        Random r = new Random(id);
        int ra = r.nextInt(100);

        if ( ra < 70){
            int minR = 100;
            int maxR = 300;
            Random ran = new Random(id);
            zp = minR + ran.nextInt(maxR - minR);
        }
        else if (ra < 90) {
            int minR = 300;
            int maxR = 500;
            Random ran = new Random(id);
            zp = minR + ran.nextInt(maxR - minR);
        }
        else {
            int minR = 500;
            int maxR = 601;
            Random ran = new Random(id);
            zp = minR + ran.nextInt(maxR - minR);
        }

        return zp;
    }

    public static String Name(int id){
        String name;
        int c;
        int minR = 5;
        int maxR = 11;
        Random ran = new Random(id);
        c = minR + ran.nextInt(maxR - minR);

        RanS name2 = new RanS();
        name = RanS.RS(c,id);
        return name;
    }
}
