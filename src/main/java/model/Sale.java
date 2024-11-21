package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items = new ArrayList<>();
    private String paymentMethod;

    public void addSaleItem(SaleItem item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (SaleItem saleItem : items) 
            total += saleItem.getSubtotal();
        
        return applyPaymentAdjustment(total);
    }

    private double applyPaymentAdjustment(double total) {
        if (paymentMethod.equals("Cartao de Credito")) {
            return total * 1.05; // 5% de juros
        } else if (paymentMethod.equals("Dinheiro/Pix")) {
            return total * 0.95; // 5% de desconto
        }
        return total; // Cartão de Débito sem alteração
    }

    public List<SaleItem> getItems() {
        return new ArrayList<>(items);
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
