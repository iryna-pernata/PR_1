import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення об'єктів класу Product
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);

        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);


        // Виведення інформації про товари
//        System.out.println(product1);
//        System.out.println(product2);
//        System.out.println(product3);

        // Створення кошика
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        UserHistory history = new UserHistory();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Пошук товарів");
            System.out.println("7 - Переглянути історію замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int addId = scanner.nextInt();
                    if (addId == 1) cart.addProduct(product1);
                    else if (addId == 2) cart.addProduct(product2);
                    else if (addId == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    if (removeId == 1) cart.removeProduct(product1);
                    else if (removeId == 2) cart.removeProduct(product2);
                    else if (removeId == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        history.addOrder(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    System.out.println("Введіть назву товару або категорію для пошуку:");
                    scanner.nextLine();
                    String query = scanner.nextLine();
                    searchProduct(query, product1, product2, product3);
                    break;
                case 7:
                    System.out.println(history);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }

        }
    }
    public static void searchProduct(String query, Product... products) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(query) || product.getCategory().getName().equalsIgnoreCase(query)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товар не знайдено.");
        }
    }
}
