package com.company.design;

import com.company.design.decorator.*;

import java.security.spec.ECField;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        //decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
    }
}