package com.example.model;

import java.util.List;

public class BillAmount {
	private Double taxTotal = 0.00;
    private Double saleTotal = 0.00;
    private Double itemTotal = 0.00;

    public BillAmount(List<Item> items){
        for(Item item: items){
            this.itemTotal = this.itemTotal + (item.getPrice() * item.getQty());
            this.taxTotal = this.taxTotal + calculateSalesTax(item);
        }
        this.saleTotal = this.itemTotal + this.taxTotal;
    }

    private Double calculateSalesTax(Item item){
        Double tax = .10;
        if (item.getIsExempt()){
            tax = .00;
        }

        if (item.getIsImport()){
            tax = tax + .05;
        }
        Double rounded = roundAmount((item.getPrice()*tax) * item.getQty());
        item.setWithTax(rounded + (item.getPrice() * item.getQty()));
        return rounded;
    }

    public Double getTaxTotal() {
        return this.taxTotal;
    }

    public Double getSaleTotal() {
        return this.saleTotal;
    }

    private Double roundAmount(Double amount){
        return Math.ceil((amount * 20.0)) / 20.0;
    }

    private Double calculateTotalBillAmount(){
        return this.saleTotal = (this.taxTotal + this.itemTotal);
    }

}
