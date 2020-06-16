package com.company;

import java.util.Random;

class RanS {

    static String RS(int n, int id) {
        String[] lis = new String[]{"й","ц","у","к","е","н","г","ш","щ","з","х","ф","ы","в","а","п","р","о","л","д","ж","э","я","ч","с","м","и","т","б","ю","й","а","в","о","л","н","е","к","у","м"};
        // Создал StringBuffer для сохранения результата
        StringBuffer r = new StringBuffer(n);
        Random ra = new Random(id);
        int minR = 1;
        int maxR = 40;
        int im = minR + ra.nextInt(maxR - minR);

        for (int i = 0; i < n; i++) {
            int imi = 0;
            if (im < 30){
                imi = im+i;
            }
            else {
                imi = im-i;
            }

            // взять случайное значение между 97 и 122  39 от 0 так 40
            String nextRandomChar = lis[imi] ;

            // добавить символ в конце bs
            r.append((String) nextRandomChar);
        }
        return r.toString();
    }
}
