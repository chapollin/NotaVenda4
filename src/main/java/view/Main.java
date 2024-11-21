package view;

import controller.SaleController;
import model.Sale;
import model.SaleItem;

public class Main {
    public static void main(String[] args) {
        SaleController controller = new SaleController();
        Sale sale = controller.createSale();

        if (sale != null) {
            for (SaleItem item : sale.getItems())
                System.out.println(item);

            System.out.println(String.format("Forma de pagamento: %s", sale.getPaymentMethod()));
            System.out.println(String.format("Total a pagar: R$ %.2f", sale.getTotal()));
        } else {
            System.out.println("Venda não realizada devido à falta de estoque.");
        }
    }
}
