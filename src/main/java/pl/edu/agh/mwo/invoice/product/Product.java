package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
    	if(name == null || name.isEmpty()) {
    		throw new IllegalArgumentException("Product name is not valid, is null or empty");
    	}
    	
    	if(price == null || price.signum() == -1) {
    		throw new IllegalArgumentException("Product price " + price + " is not valid");
    	}
    	
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return this.price.multiply(taxPercent).add(price);
    }
}
