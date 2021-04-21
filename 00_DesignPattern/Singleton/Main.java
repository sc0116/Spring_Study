package com.company.design;

import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

import java.security.spec.ECField;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
        System.out.println("aClazz의 객체: " + aClient);
        System.out.println(("bClazz의 객체: " + bClient));
    }
}
