package com.example.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptScanner {
	
	private PurchasedGoods purchasedGoods;

    public ReceiptScanner(String cart) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(cart));
            String itemDetails;
            this.purchasedGoods = new PurchasedGoods();
            while ((itemDetails = reader.readLine()) != null) {
                this.purchasedGoods.addItem(
                        scanQty(itemDetails),
                        scanDetails(itemDetails),
                        scanPrice(itemDetails)
                );
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public PurchasedGoods getPurchase() {
        return this.purchasedGoods;
    }

    private int scanQty(String details) {
        Pattern p = Pattern.compile("^[\\d+]+");
        Matcher m = p.matcher(details);
        m.find();
        return Integer.parseInt(m.group(0));
    }

    private String scanDetails(String details) {
        Pattern p = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
        Matcher m = p.matcher(details);
        m.find();
        return  m.group(0);
    }

    private Double scanPrice(String details) {
        Pattern p = Pattern.compile("\\d+.\\d+$");
        Matcher m = p.matcher(details);
        m.find();
        return Double.parseDouble(m.group(0));
    }

}
