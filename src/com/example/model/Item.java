package com.example.model;

import java.util.regex.Pattern;

public class Item {
	    private int qty;
	    private String details;
	    private Double price;
	    private Boolean isImport = false;
	    private Boolean isExempt = false;
	    private Double withTax;
	    
		public Item(int qty, String details, Double price, Boolean isImport, Boolean isExempt, Double withTax) {
			super();
			this.qty = qty;
			this.details = details;
			this.price = price;
			this.isImport = isImport;
			this.isExempt = isExempt;
			this.withTax = withTax;
		}
		
		 public Item(int qty, String details, Double price){
		        this.qty = qty;
		        this.details = details;
		        this.price = price;
		        setSaleType(details);
		    }

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Boolean getIsImport() {
			return isImport;
		}

		public void setIsImport(Boolean isImport) {
			this.isImport = isImport;
		}

		public Boolean getIsExempt() {
			return isExempt;
		}

		public void setIsExempt(Boolean isExempt) {
			this.isExempt = isExempt;
		}

		public Double getWithTax() {
			return withTax;
		}

		public void setWithTax(Double afterTax) {
			this.withTax = afterTax;
		}
		
	    private void setSaleType(String details){
	        Pattern exemptPattern = Pattern.compile("pills|chocolate|book|wine");
	        Pattern importPattern = Pattern.compile("import");
	        if (exemptPattern.matcher(details).find()) {
	            this.isExempt = true;
	        }

	        if (importPattern.matcher(details).find()) {
	            this.isImport = true;
	        }
	    }
	    
}