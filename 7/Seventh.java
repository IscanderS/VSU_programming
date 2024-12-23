import java.util.HashSet;
import java.util.Scanner;

public class Seventh {
    public static void main(String[] args) {
    
        int[][] testArrays = {
            {1, 2, 3, 4, 5, 1, 2, 3},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 5, 6, 7},
            {1, 2, 3, 4, 5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 2, 1, 4, 5, 6},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5}
        };

        
        for (int i = 0; i < testArrays.length; i++) {
            System.out.print("Тест " + (i + 1) + ": ");
            printArray(testArrays[i]);
            Result result = solution(testArrays[i]);
            System.out.println("Позиция первого элемента: " + result.index + ", Количество элементов: " + result.length);
        }

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] userArray = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            userArray[i] = scanner.nextInt();
        }

        Result userResult = solution(userArray);
        System.out.print("Ваш массив: ");
        printArray(userArray);
        System.out.println("Позиция первого элемента: " + userResult.index + ", Количество элементов: " + userResult.length);
    }

    
    static Result solution(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        int startIndex = -1;
        int lastStartIndex = -1;

        for (int i = 0; i < array.length; i++) {
            set.clear();
            int currentLength = 0;
            for (int j = i; j < array.length; j++) {
                if (!set.contains(array[j])) {
                    set.add(array[j]);
                    currentLength++;
                } else {
                    break;
                }
            }

            if (currentLength >= maxLength) {
                maxLength = currentLength;
                lastStartIndex = i;
            }
        }

        return new Result(lastStartIndex, maxLength);
    }

    
    static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    
    static class Result {
        int index;
        int length;

        Result(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }
}