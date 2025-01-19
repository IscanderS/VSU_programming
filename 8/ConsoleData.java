import java.io.*;
import java.util.*;

public class ConsoleData {
    public static List<Integer[]> readDataFromFile(String inputFile) {
        List<Integer[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split("\\s+"); // Разделение по пробелам
                Integer[] integers = Arrays.stream(values).map(Integer::parseInt).toArray(Integer[]::new);
                data.add(integers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<Integer> createNewList(List<Integer> list1, List<Integer> list2) {
        // Преобразуем списки в двумерный массив для проверки последовательности
        int[][] array = new int[2][];
        array[0] = list1.stream().mapToInt(i -> i).toArray();
        array[1] = list2.stream().mapToInt(i -> i).toArray();

        Function function = new Function();
        boolean isFulfilling = function.isSequenceFulfilling(array);

        // Возвращаем результат в виде списка
        return Collections.singletonList(isFulfilling ? 1 : 0); // 1 - последовательность соблюдается, 0 - не соблюдается
    }

    public static void writeDataToFile(String outputFile, List<Integer[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Integer[] integers : data) {
                bw.write(Arrays.toString(integers).replaceAll("[\\$$\\$$,]", "") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}