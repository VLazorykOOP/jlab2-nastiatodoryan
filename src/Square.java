public class Square {
    private double side; // Сторона квадрата

    // Конструктор для створення квадрата
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата повинна бути позитивною");
        }
        this.side = side; // Зберігаємо довжину сторони
    }

    // Метод для обчислення периметра
    public double calculatePerimeter() {
        return 4 * side; // Периметр = 4 * сторона
    }

    // Метод для обчислення площі
    public double calculateArea() {
        return side * side; // Площа = сторона * сторона
    }

    // Метод для обчислення довжини діагоналі
    public double calculateDiagonal() {
        return side * Math.sqrt(2); // Діагональ = сторона * √2
    }

    // Головний метод для тестування класу
    public static void main(String[] args) {
        Square square = new Square(5); // Створюємо квадрат зі стороною 5

        double perimeter = square.calculatePerimeter();
        System.out.println("Периметр квадрата: " + perimeter); // Виведе: 20.0

        double area = square.calculateArea();
        System.out.println("Площа квадрата: " + area); // Виведе: 25.0

        double diagonal = square.calculateDiagonal();
        System.out.println("Довжина дiагоналi: " + diagonal); // Виведе: 7.0710678118654755
    }
}
