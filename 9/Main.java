import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Запрос у пользователя количества строк и столбцов
        String rowsInput = JOptionPane.showInputDialog("Введите количество строк:");
        String colsInput = JOptionPane.showInputDialog("Введите количество столбцов:");

        int rows = Integer.parseInt(rowsInput);
        int cols = Integer.parseInt(colsInput);

        // Создание и отображение таблицы
        JTableVariation jTableVariation = new JTableVariation(rows, cols);
    }
}