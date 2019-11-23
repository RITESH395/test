package Service;

import Pojo.Order;
import Pojo.OrderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessing
{
    public static List<Order> processOrders(List<Order> orders)
    {
        List<Order> buyOrders = new ArrayList<>();
        List<Order> sellOrders = new ArrayList<>();
        Map<Integer, Order> mapOfOrder = new HashMap<>();
        List<Order> leftOverOrder = new ArrayList<>();

        for(Order order : orders)
        {
            if(order.getOrderType() == OrderType.Buy)
                buyOrders.add(order);
            else if(order.getOrderType() == OrderType.Sell)
                sellOrders.add(order);
            mapOfOrder.put(order.getOrderNumber(), order);
        }
        for(Order buyOrder : buyOrders)
        {
            for(Order sellOrder : sellOrders)
            {
                int buyQuantity = buyOrder.getQuantity();
                int buyPrice = buyOrder.getPrice();
                int sellQuantity = sellOrder.getQuantity();
                int sellPrice = sellOrder.getPrice();

                if(buyQuantity > 0  && buyPrice >= sellPrice)
                {
                    buyOrder.setQuantity(buyQuantity < sellQuantity ? 0 : buyQuantity - sellQuantity);
                    sellOrder.setQuantity(buyQuantity < sellQuantity ? sellQuantity - buyQuantity : 0);
                    mapOfOrder.put(buyOrder.getOrderNumber(), buyOrder);
                    mapOfOrder.put(sellOrder.getOrderNumber(), sellOrder);
                    System.out.println("Transaction success between BuyerId : "+
                            buyOrder.getOrderNumber()+ " & SellerId : "+ sellOrder.getOrderNumber()
                            +"for "+ (buyQuantity < sellQuantity ? buyQuantity : sellQuantity)+ " gold bar");
                }
            }
        }
        for(Integer key : mapOfOrder.keySet())
        {
            Order order = mapOfOrder.get(key);
            if(order.getQuantity() > 0)
            {
                leftOverOrder.add(order);
            }
        }
        return leftOverOrder;
    }
}
