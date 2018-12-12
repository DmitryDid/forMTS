package dns.tests;

import dns.core.Core;
import org.junit.Assert;
import org.junit.Test;

public class dnsTest extends Core {

    @Test
    public void sorting_into_laptops_category() {
        logger.logInfo("Подготовка данных для теста:");

        menu.selectCategory("Ноутбуки и планшеты");
        menu.selectCategory("Ноутбуки и аксессуары");
        menu.selectSubCategory("Ноутбуки");

        filter.fillMinPrice("80000");
        filter.fillMaxPrice("85000");
        filter.selectProducer("ASUS");
        filter.apply();

        checkCatalogSort();
    }

    @Test
    public void sorting_into_other_category() {
        logger.logInfo("Подготовка данных для теста:");

        menu.selectCategory("Телевизоры и медиа");
        menu.selectCategory("Телевизоры и аксессуары");
        menu.selectSubCategory("Телевизоры");

        filter.fillMinPrice("25000");
        filter.fillMaxPrice("30000");
        filter.selectProducer("LG");
        filter.apply();

        checkCatalogSort();
    }
}