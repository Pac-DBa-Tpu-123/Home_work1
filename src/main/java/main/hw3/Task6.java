package main.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {

    interface StockMarket {
        /** Добавить акцию */
        void add(Stock stock);

        /** Удалить акцию */
        void remove(Stock stock);

        /** Самая дорогая акция */
        Stock mostValuableStock();
    }

    static class Stock {
        private String name;
        private double price;

        Stock(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Stock{" + "name='" + name + '\'' + ", price=" + price + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Stock stock = (Stock) o;

            if (Double.compare(stock.price, price) != 0) {
                return false;
            }
            return name != null ? name.equals(stock.name) : stock.name == null;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = name != null ? name.hashCode() : 0;
            temp = Double.doubleToLongBits(price);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    static class StockMarketImpl implements StockMarket {
        private PriorityQueue<Stock> stockQueue;

        StockMarketImpl() {
            this.stockQueue = new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice).reversed());
        }

        @Override
        public void add(Stock stock) {
            stockQueue.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            stockQueue.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            return stockQueue.peek();
        }
    }
}
