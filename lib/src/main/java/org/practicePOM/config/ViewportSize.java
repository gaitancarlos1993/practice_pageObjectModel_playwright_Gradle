package org.practicePOM.config.*;
public enum ViewportSize {
    DESKTOP(1920,1080),
    TABLET(768,1024),
    MOBILE(390,844);

// Valores fijos y estaticos para width y height
    private final int width;
    private final int height;

    ViewportSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}