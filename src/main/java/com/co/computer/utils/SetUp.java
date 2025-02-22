package com.co.computer.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SetUp {
    @Managed(driver = "appium")
    protected static AndroidDriver driver;

    private static EnvironmentVariables environmentVariables;

    public static AndroidDriver configureDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Configuración de capacidades para ejecutar Chrome en el emulador
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Cambia si usas un dispositivo real
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); // Indica que se usará el navegador Chrome
        capabilities.setCapability("chromedriverExecutable", "C:/chromedriver/chromedriver.exe"); // Ajusta la ruta correcta

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver; // Retornar el driver correctamente
    }
}
