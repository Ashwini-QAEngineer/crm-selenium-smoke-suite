package com.ashwini.crm.tests;
import com.ashwini.crm.utils.DriverFactory;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class SmokeTest {
    private static final String URL="https://opensource.demo.orangehrmlive.com";

    @BeforeMethod public void setUp() { DriverFactory.init(); }

    @Test(groups={"smoke"}, description="Login smoke - verify dashboard loads")
    public void testLoginSmoke() {
        WebDriver d = DriverFactory.getDriver();
        d.get(URL+"/web/index.php/auth/login");
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123");
        d.findElement(By.cssSelector("[type='submit']")).click();
        Assert.assertTrue(d.getCurrentUrl().contains("dashboard"),"Dashboard not loaded");
    }

    @Test(groups={"smoke"}, description="PIM module smoke - employee list loads")
    public void testPimSmoke() {
        WebDriver d = DriverFactory.getDriver();
        d.get(URL+"/web/index.php/auth/login");
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123");
        d.findElement(By.cssSelector("[type='submit']")).click();
        d.findElement(By.linkText("PIM")).click();
        Assert.assertTrue(d.getCurrentUrl().contains("pim"),"PIM not loaded");
    }

    @AfterMethod public void tearDown() { DriverFactory.quit(); }
}
