package Pojo;

import java.util.Date;

public class Order {

    static int orderCount = 1 ;/*Class Variable to assign unique vale to each order*/

    int orderNumber;
    OrderType orderType;
    int price;
    int quantity;
    Date timestamp;

    public Order(String orderType, int price, int quantity) throws Exception
    {
        this.orderNumber = orderCount++;
        if(orderType.equalsIgnoreCase("Buy")) this.orderType = OrderType.Buy;
        else if (orderType.equalsIgnoreCase("Sell")) this.orderType = OrderType.Sell;
        else throw new Exception("Unsupported Order Type (Supported: Buy/Sell)");
        this.price = price;
        this.quantity = quantity;
        this.timestamp = new Date();
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static void setOrderCount(int orderCount) {
        Order.orderCount = orderCount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return  orderNumber + "    |    "+ orderType + "    |    "+ price + "    |    "+ quantity + "    |    "+ timestamp;
    }
}
