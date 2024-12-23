
import java.util.Scanner;

public class Salvation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x: ");
        double x = scanner.nextDouble();
        System.out.println("Введите y: ");
        double y = scanner.nextDouble();

        printColorForPoint(x, y);

    

    }

    public static void printColorForPoint(double x, double y) { 
        if (Programm.getColor(x, y) == Colors.BLUE) {
            System.out.println("BLUE");
        }

        if (Programm.getColor(x, y) == Colors.ORANGE) {
            System.out.println("ORANGE");
        }

        if (Programm.getColor(x, y) == Colors.GREEN) {
            System.out.println("GREEN");
        }

        if (Programm.getColor(x, y) == Colors.YELLOW) {
            System.out.println("YELLOW");
        }

        if (Programm.getColor(x, y) == Colors.WHITE) {
            System.out.println("WHITE");
        }

        if (Programm.getColor(x, y) == Colors.GRAY) {
            System.out.println("GRAY");
        }
    }
}
