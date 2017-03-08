package com.cyberha4;

/**
 * Created by admin on 07.03.2017.
 */
//Ленивое решение - потокобезопасное
public class Singleton2 {
    private Singleton2(){}

    static class SingletonHolder {
        private static Singleton2 INSTANCE = new Singleton2();

        public Singleton2 getInstance(){
            return INSTANCE;
        }
    }

}
