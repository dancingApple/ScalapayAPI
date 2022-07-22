package operation;

import pojo.GetOrder;
import pojo.Item;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class OrderCalculation {

     public static float calculateTotal(GetOrder order) {
         String orderCurrency = order.getTotalAmount().getCurrency();
         List<Item> orderedItems = order.getOrderDetails().getItems();
         float totalAmount = 0;

         for(int i=0;i<orderedItems.size();i++) {
             //Verified if the item currency is correct.
            assertEquals("Item " + i + ", "
                    + orderedItems.get(i).getName() + " is not in correct currency",
                    orderCurrency,orderedItems.get(i).getPrice().getCurrency());
            float itemTot = orderedItems.get(i).getPrice().getAmount()*orderedItems.get(i).getQuantity();
            totalAmount = totalAmount + itemTot;
         }

        assertEquals("Tax is not in correct currency",
                orderCurrency,order.getOrderDetails().getTaxAmount().getCurrency());

        totalAmount = totalAmount + order.getOrderDetails().getTaxAmount().getAmount();

        assertEquals("Shipping price is not in correct currency",
                orderCurrency,order.getOrderDetails().getShippingAmount().getCurrency());
        totalAmount = totalAmount + order.getOrderDetails().getShippingAmount().getAmount();
        return totalAmount;
     }
}
