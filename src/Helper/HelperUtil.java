package Helper;

import Pojo.Order;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HelperUtil
{
    public static void display(List<Order> orders)
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Order No" + "   |   "+ "Type" + "   |   "+ "Price" + "   |   "+ "Quantity" + "   |   "+ "Time");
        System.out.println("-----------------------------------------------------------------------------------");
        for(Order order : orders)
        {
            System.out.println(order.toString());
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static String convertToOutputFormat(List<Order> remainingOrders)
    {
        List<String> outputList = new ArrayList<>();
        for(Order order : remainingOrders)
        {
            outputList.add(  order.getOrderType() +","+ order.getPrice() +","+ order.getQuantity() );
        }
        return StringUtils.join(outputList, "#");
    }

}
