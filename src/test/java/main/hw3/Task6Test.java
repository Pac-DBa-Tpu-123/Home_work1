package main.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    @Test
    public void testAddAndMostValuableStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("Apple", 150.0);
        Task6.Stock stock2 = new Task6.Stock("Google", 2700.0);
        Task6.Stock stock3 = new Task6.Stock("Microsoft", 300.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        assertEquals("Google", stockMarket.mostValuableStock().getName());
    }

    @Test
    public void testRemoveAndMostValuableStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("Apple", 150.0);
        Task6.Stock stock2 = new Task6.Stock("Google", 2700.0);
        Task6.Stock stock3 = new Task6.Stock("Microsoft", 300.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        stockMarket.remove(stock2);

        assertEquals("Microsoft", stockMarket.mostValuableStock().getName());
    }

    @Test
    public void testEmptyStockMarket() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        assertNull(stockMarket.mostValuableStock());
    }

    @Test
    public void testAddAndRemoveSameStock() {
        Task6.StockMarket stockMarket = new Task6.StockMarketImpl();

        Task6.Stock stock1 = new Task6.Stock("Apple", 150.0);

        stockMarket.add(stock1);
        stockMarket.remove(stock1);

        assertNull(stockMarket.mostValuableStock());
    }
}
