package controller;

import model.Product;
import model.Sale;
import model.SaleItem;

import java.util.Scanner;

public class SaleController {

    public Sale createSale() {
        Product rice = createProduct("Arroz Tatiana", 30, 10);
        Product beans = createProduct("Feijao Feijo", 20, 5);
        Product pasta = createProduct("Macarrao Santa Amalia", 15, 8);

        SaleItem itemRice = createSaleItem(rice, 2);
        SaleItem itemBeans = createSaleItem(beans, 1); 
        SaleItem itemPasta = createSaleItem(pasta, 6);

        Sale sale = new Sale();
        sale.addSaleItem(itemRice);
        sale.addSaleItem(itemBeans);
        sale.addSaleItem(itemPasta);

        String paymentMethod = choosePaymentMethod();
        sale.setPaymentMethod(paymentMethod);

        return sale;
    }

    private Product createProduct(String description, double price, int stock) {
        Product product = new Product();
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock); // Define o estoque do produto
        return product;
    }

    private SaleItem createSaleItem(Product product, int quantity) {
        if (product.isAvailable(quantity)) {
            product.reduceStock(quantity); // Reduz o estoque após a venda
            SaleItem item = new SaleItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            return item;
        } else {
            System.out.println("Produto " + product.getDescription() + " não disponível em estoque.");
            return null; // Produto não disponível
        }
    }

    private String choosePaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartao de Credito (5% de juros)");
        System.out.println("2 - Cartao de Debito (sem juros)");
        System.out.println("3 - Dinheiro/Pix (5% de desconto)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Cartao de Credito";
            case 2:
                return "Cartao de Debito";
            case 3:
                return "Dinheiro/Pix";
            default:
                return "Cartao de Debito";
        }
    }
}
