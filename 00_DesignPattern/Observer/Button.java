package com.company.design.observer;

public class Button {

    private String name;
    private IButtonListener iButtonListener;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        iButtonListener.clickEvent(message);
    }

    public void addListener(IButtonListener iButtonListener) {
        this.iButtonListener = iButtonListener;
    }
}
