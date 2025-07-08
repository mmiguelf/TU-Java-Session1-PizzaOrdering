package org.pizzaOrderingSystem.model;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaOrder {
    private ArrayList<String> pizzas = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public PizzaOrder () {}

    public void welcomeMenu() {
        boolean inUse = true;
        while (inUse) {
            String pizzaType;
            int quantity;
            int index;
            int newQuantity;

            System.out.println();
            System.out.println("Welcome to the Pizza Ordering System");
            System.out.println("1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Remove Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.printf("Choose option: ");
            int option = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.printf("Pizza Type: ");
                    pizzaType = scan.nextLine();
                    System.out.printf("Quantity: ");
                    quantity = scan.nextInt();
                    if (quantity <= 0) {
                        System.out.println("Quantity must be positive");
                    }
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.printf("Order number to update: ");
                    index = scan.nextInt();
                    System.out.printf("New quantity: ");
                    newQuantity = scan.nextInt();
                    if (newQuantity <= 0) {
                        System.out.println("Quantity must be positive");
                    }
                    updateOrder(quantities, --index, newQuantity);
                    break;
                case 3:
                    System.out.printf("Order number to remove: ");
                    index = scan.nextInt();
                    removeOrder(pizzas, quantities, --index);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    inUse = false;
                    break;
                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }
    }

    public void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        pizzas.remove(index);
        quantities.remove(index);
        System.out.println("Order removed successfully");
    }

    public void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        quantities.set(index, newQuantity);
        System.out.println("Order updated successfully");
    }

    public void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        pizzas.add(pizzaType);
        quantities.add(quantity);
        System.out.println("Order added successfully");
    }

    public void printOrders (ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        int count = 0;
        System.out.println("--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            String p = pizzas.get(i);
            int q = quantities.get(i);
            count++;
            System.out.println(count + ". " + p + " x " + q);
        }
    }
}
