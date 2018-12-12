package dns.tests;

import dns.core.Core;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Draft extends Core {

    @Test
    public void draftTest() throws Exception {
        driver.findElement(By.partialLinkText("Ноутбуки и планшеты")).click();
        driver.findElement(By.partialLinkText("Ноутбуки и аксессуары")).click();
        driver.findElement(By.xpath("//a[@class='category-item-desktop']//span[text()='Ноутбуки']")).click();

        driver.findElement(By.xpath("//input[@data-name='min']")).click();
        driver.findElement(By.xpath("//input[@data-name='min']")).clear();
        driver.findElement(By.xpath("//input[@data-name='min']")).sendKeys("80000");

        driver.findElement(By.xpath("//input[@data-name='max']")).clear();
        driver.findElement(By.xpath("//input[@data-name='max']")).clear();
        driver.findElement(By.xpath("//input[@data-name='max']")).sendKeys("85000");

        driver.findElement(By.xpath("//input[@data-role='filter-items-search']")).click();
        driver.findElement(By.xpath("//input[@data-role='filter-items-search']")).clear();
        driver.findElement(By.xpath("//input[@data-role='filter-items-search']")).sendKeys("ASUS");
        driver.findElement(By.xpath("//input[@data-role='filter-items-search']")).sendKeys(Keys.ENTER);

        driver.findElement(By.partialLinkText("Показать")).click();

        driver.findElement(By.xpath("//div[@class='col'][1]//span[@class='title']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='По возрастанию цены']")).click();

        driver.navigate().to(driver.getCurrentUrl());

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='item' and @data-id]"));

        String productName = products.get(0).findElement(By.xpath("//h3")).getText();
        String productPrice = products.get(0).findElement(By.xpath("//span[@data-of='price-total']")).getText();

        driver.findElement(By.xpath("//div[@class='col'][1]//span[@class='title']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='По убыванию цены']")).click();

        products = driver.findElements(By.xpath("//div[@class='item' and @data-id]"));

        Assert.assertEquals(productName, products.get(products.size() - 1).findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(productPrice, products.get(products.size() - 1).findElement(By.xpath("//span[@data-of='price-total']")).getText());
    }
}