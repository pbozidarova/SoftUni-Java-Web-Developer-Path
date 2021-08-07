package OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.add(new OrderItem("123-abc", 20));

        Order order = new OnlineOrder(cart, "email@gmail");

        order.getTotalAmount();

    }
}
