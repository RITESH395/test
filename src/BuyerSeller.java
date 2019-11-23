import Helper.HelperUtil;
import Pojo.Order;
import Service.DataProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyerSeller
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter orders to process : (Type,Price,Quantity)");
        String input = null;
        List<Order> orderList = new ArrayList<>();
        while(!(input = scanner.nextLine()).equalsIgnoreCase("stop"))
        {
            try
            {
                String[] splitArray = input.split(",");
                String orderType = splitArray[0];
                int price = Integer.parseInt(splitArray[1]);
                int quantity = Integer.parseInt(splitArray[2]);

                Order order = new Order(orderType, price, quantity);
                orderList.add(order);

                System.out.println("Provide Next Order or Type \"stop\" if there are no Orders : ");
            }
            catch (Exception e)
            {
                System.out.println("Invalid Input (Example : Buy,1000,10) Try Again : " );
            }
        }

        HelperUtil.display(orderList);
        List<Order> remainings = DataProcessing.processOrders(orderList);
        System.out.println(HelperUtil.convertToOutputFormat(remainings) );
    }
}