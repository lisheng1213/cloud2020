package com.ls.springcloud;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author SGDBDS
 * @create 2020-05-25
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 4;
        for (int j = 0; j < 20; j++) {
//            int c = j%i;
//            System.out.println("c = " + c);
            int v = ThreadLocalRandom.current().nextInt(3);
            System.out.println("v = " + v);
        }
    }
}
