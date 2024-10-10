public class Money {
    private long hryvnias; // Гривні
    private byte kopecks;  // Копійки

    // Конструктор для створення об'єкта Money
    public Money(long hryvnias, byte kopecks) {
        if (kopecks < 0 || kopecks > 99) {
            throw new IllegalArgumentException("Копiйки повиннi бути вiд 0 до 99");
        }
        this.hryvnias = hryvnias + kopecks / 100; // Додаємо копійки до гривень
        this.kopecks = (byte) (kopecks % 100);    // Залишаємо тільки копійки
    }

    // Метод для додавання двох Money
    public Money add(Money other) {
        long totalKopecks = (this.hryvnias * 100 + this.kopecks) + (other.hryvnias * 100 + other.kopecks);
        return new Money(totalKopecks / 100, (byte) (totalKopecks % 100));
    }

    // Метод для віднімання двох Money
    public Money subtract(Money other) {
        long totalKopecks = (this.hryvnias * 100 + this.kopecks) - (other.hryvnias * 100 + other.kopecks);
        if (totalKopecks < 0) {
            throw new IllegalArgumentException("Результат не може бути вiд'ємним");
        }
        return new Money(totalKopecks / 100, (byte) (totalKopecks % 100));
    }

    // Метод для ділення Money на ціле число
    public Money divide(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Не можна дiлити на нуль");
        }
        long totalKopecks = (this.hryvnias * 100 + this.kopecks);
        return new Money(totalKopecks / divisor / 100, (byte) (totalKopecks / divisor % 100));
    }

    // Метод для порівняння Money
    public int compareTo(Money other) {
        long thisTotalKopecks = this.hryvnias * 100 + this.kopecks;
        long otherTotalKopecks = other.hryvnias * 100 + other.kopecks;
        return Long.compare(thisTotalKopecks, otherTotalKopecks);
    }

    // Метод для виведення Money у вигляді рядка
    @Override
    public String toString() {
        return hryvnias + "," + String.format("%02d", kopecks); // Форматування копійок
    }

    // Головний метод для тестування класу
    public static void main(String[] args) {
        Money money1 = new Money(10, (byte) 50); // 10 грн 50 коп
        Money money2 = new Money(5, (byte) 75);   // 5 грн 75 коп

        Money sum = money1.add(money2);
        System.out.println("Сума: " + sum); // Виведе: 16,25

        Money difference = money1.subtract(money2);
        System.out.println("Рiзниця: " + difference); // Виведе: 4,75

        Money divided = money1.divide(2);
        System.out.println("Дiлення на 2: " + divided); // Виведе: 5,25

        int comparison = money1.compareTo(money2);
        if (comparison > 0) {
            System.out.println("money1 бiльше money2");
        } else if (comparison < 0) {
            System.out.println("money1 менше money2");
        } else {
            System.out.println("money1 дорiвнює money2");
        }
    }
}
