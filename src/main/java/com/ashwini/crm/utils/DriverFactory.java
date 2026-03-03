package com.ashwini.crm.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class DriverFactory {
    private static final ThreadLocal<WebDriver> tl=new ThreadLocal<>();
    public static WebDriver getDriver(){return tl.get();}
    public static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions o=new ChromeOptions();
        o.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage");
        WebDriver d=new ChromeDriver(o); d.manage().window().maximize(); tl.set(d);
    }
    public static void quit(){if(tl.get()!=null){tl.get().quit();tl.remove();}}
}
