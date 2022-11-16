import java.io.File;
import java.io.IOException;

import com.example.model.BillAmount;
import com.example.model.Item;
import com.example.model.PurchasedGoods;
import com.example.model.ReceiptConsole;
import com.example.model.ReceiptScanner;

public class Receipt {
    public static void main(String[] totalCarts) throws IOException {
        String[] defaultCarts = {
                "assets/cart1.txt",
                "assets/cart2.txt",
                "assets/cart3.txt",
        };

        String[] cartFiles = (totalCarts.length > 0) ?
                totalCarts : defaultCarts;

        for (String cart : cartFiles) {
            if (new File(cart).exists()){
                ReceiptScanner receiptScanner = new ReceiptScanner(cart);
                PurchasedGoods purchase = receiptScanner.getPurchase();
                BillAmount calculate = new BillAmount(purchase.getInventory());
                ReceiptConsole display = new ReceiptConsole();
                for(Item item: purchase.getInventory()){
                    display.purchaseList(item);
                }
                display.lineBreak();
                display.salesTax(calculate.getTaxTotal());
                display.totalSale(calculate.getSaleTotal());
            }else {
            	System.out.println("Hello");
            }
        }
    }

}
