package com.company.design.aop;

import com.company.design.proxy.Html;
import com.company.design.proxy.IBrowser;

import java.util.PrimitiveIterator;

public class AopBrowser implements IBrowser  {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if(html == null) {
            this.html = new Html(url);
            System.out.println("AopBrowser loading html from: " + url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();

        System.out.println("AopBrowser use cache from: " + url);
        return html;
    }
}
