import java.util.Scanner;

public class Baloon {
    private int x;
    private int y;
    private int z;
    private int radius;

    public Baloon(int x, int y, int z, int radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    public static double calculateVolume(int radius) {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public static double calculateIntersectionVolume(Baloon b1, Baloon b2) {
        double distance = Math.sqrt(Math.pow(b1.x - b2.x, 2) +
                                     Math.pow(b1.y - b2.y, 2) +
                                     Math.pow(b1.z - b2.z, 2));

        // Якщо кулі не перетинаються
        if (distance >= b1.radius + b2.radius) {
            return 0;
        }

        // Якщо одна куля повністю в середині іншої
        if (distance <= Math.abs(b1.radius - b2.radius)) {
            return calculateVolume(Math.min(b1.radius, b2.radius));
        }

        // Обчислення об'єму перетину двох куль
        double r1 = b1.radius;
        double r2 = b2.radius;

        double volume = (Math.PI * (r1 + r2 - distance) *
                         (r1 + r2 - distance) *
                         (r1 + r2 - distance)) / (12 * distance);
        
        return volume;
    }

    public static double calculateUnionVolume(Baloon b1, Baloon b2) {
        double volume1 = calculateVolume(b1.radius);
        double volume2 = calculateVolume(b2.radius);
        double intersectionVolume = calculateIntersectionVolume(b1, b2);
        return volume1 + volume2 - intersectionVolume;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введiть координати i радiус першої кулi (x1 y1 z1 r1):");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();
            int r1 = scanner.nextInt();

            System.out.println("Введiть координати i радiус другої кулi (x2 y2 z2 r2):");
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int z2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            Baloon balloon1 = new Baloon(x1, y1, z1, r1);
            Baloon balloon2 = new Baloon(x2, y2, z2, r2);

            double intersectionVolume = calculateIntersectionVolume(balloon1, balloon2);
            double unionVolume = calculateUnionVolume(balloon1, balloon2);

            System.out.printf("Об'єм перетину: %.2f%n", intersectionVolume);
            System.out.printf("Об'єм об'єднання: %.2f%n", unionVolume);
        }
    }
}
