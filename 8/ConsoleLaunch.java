import java.util.*;

public class ConsoleLaunch {
    public static void main(String[] args) {
        InputArgs inputArgs = parseCmdArgs(args);
        if (inputArgs == null) {
            System.err.println("Ошибка: Не указаны входные и выходные файлы.");
            System.exit(1);
        }

        // Чтение данных из входного файла
        List<Integer[]> data = ConsoleData.readDataFromFile(inputArgs.inputFile);
        if (data.isEmpty()) {
            System.err.println("Ошибка: Не удалось прочитать входной файл или файл пуст.");
            System.exit(1);
        }

        // Обработка данных
        List<Integer> resultList = ConsoleData.createNewList(Arrays.asList(data.get(0)), Arrays.asList(data.get(1)));

        // Запись результатов в выходной файл
        ConsoleData.writeDataToFile(inputArgs.outputFile, Collections.singletonList(resultList.toArray(new Integer[0])));
    }

    public static InputArgs parseCmdArgs(String[] args) {
        String inputFile = null;
        String outputFile = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i") || args[i].startsWith("--input-file=")) {
                inputFile = args[i].contains("=") ? args[i].split("=")[1] : args[++i];
            } else if (args[i].equals("-o") || args[i].startsWith("--output-file=")) {
                outputFile = args[i].contains("=") ? args[i].split("=")[1] : args[++i];
            }
        }

        if (inputFile == null || outputFile == null) {
            return null;
        }

        return new InputArgs(inputFile, outputFile);
    }
}