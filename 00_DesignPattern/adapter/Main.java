package com.company.design;

import com.company.design.adapter.*;

import java.security.spec.ECField;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        //adapter
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        Airconditioner airconditioner = new Airconditioner();
        Electronic110V airAdapter = new SocketAdapter(airconditioner);
        connect(airAdapter);

    }
    //콘센트 - adapter
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
