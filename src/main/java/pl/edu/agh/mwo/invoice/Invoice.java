package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new LinkedHashMap<>();
    
    public void addProduct(Product product) {
        products.put(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
    	if(quantity <= 0) {
    		throw new IllegalArgumentException("Product quantity is not valid");
    	}
    	
    	products.put(product, quantity);
    
    }

    public BigDecimal getSubtotal() {
    	BigDecimal total = new BigDecimal(0); 
    	
    	for (Product p : products.keySet()) {
    		Integer quantity = products.get(p);
    		total = total.add(p.getPrice().multiply(new BigDecimal(quantity)));
    	}
    	
        return total;
    }

    public BigDecimal getTax() {
    	BigDecimal total = BigDecimal.ZERO; 
    	
    	for (Product p : products.keySet()) {
    		total = total.add(p.getPrice().multiply(p.getTaxPercent()));
    	}
    	
        return total;
    }

    public BigDecimal getTotal() {
    	BigDecimal total = BigDecimal.ZERO; 
    	
    	for (Product p : products.keySet()) {
    		Integer quantity = products.get(p);
    		total = total.add(p.getPriceWithTax().multiply(new BigDecimal(quantity)));
    	}
    	
        return total;
    }
}
