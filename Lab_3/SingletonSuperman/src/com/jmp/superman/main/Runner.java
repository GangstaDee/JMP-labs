package com.jmp.superman.main;

import com.jmp.superman.entity.Superman;

/**
 * Created by Dasha.Selyavko on 13.12.2015.
 */
public class Runner {
    public static void main(String[] args) {

        System.out.println("The war is started: we need a Superman!");

        Superman superman = Superman.getInstance();
        superman.run();
        superman.rescue();

        Superman anotherSuperman = Superman.getInstance();
        anotherSuperman.run();
        anotherSuperman.rescue();
    }
}
