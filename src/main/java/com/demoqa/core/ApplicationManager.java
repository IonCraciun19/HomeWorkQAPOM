package com.demoqa.core;

import com.demoqa.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    String browser;
    protected static WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

//    public WebDriver startTest() {
//        switch (browser){
//            case "chrome" -> driver = new ChromeDriver();
//            case "edge" -> driver = new EdgeDriver();
//            case "firefox" -> driver = new FirefoxDriver();
//        }
//
//        WebDriverListener listener = new MyListener();
//        driver = new EventFiringDecorator<>(listener).decorate(driver);
//
//        driver.get("https://the-internet.herokuapp.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        System.out.println("Hello");
//        return driver;
//    }

    public WebDriver startTest() {
        ChromeOptions options = new ChromeOptions();

        // инкогнито — у Chrome не активен менеджер паролей
        options.addArguments("--incognito");

        // вырубаем фичи, которые триггерят окно
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManager,AutofillServerCommunication");

        // префы профиля
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // гасим Safe Browsing, чтобы детектор утечек не работал
        prefs.put("safebrowsing.enabled", false);
        prefs.put("safebrowsing.disable_download_protection", true);
        // (на некоторых версиях помогает и это)
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver = new EventFiringDecorator<>(new MyListener()).decorate(driver);

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }


    public void stopTest() {
        driver.quit();
    }
}
