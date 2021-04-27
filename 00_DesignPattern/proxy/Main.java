package com.company.design;

import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.security.spec.ECField;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        //proxy
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser iBrowser = new BrowserProxy("www.naver.com");
        iBrowser.show();
        iBrowser.show();
        iBrowser.show();
        iBrowser.show();

        //proxy
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    Long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time: " + end.get());

        aopBrowser.show();
        System.out.println("loading time: " + end.get());

    }
}
