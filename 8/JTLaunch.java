import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTLaunch {
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

class JTableVariation extends JFrame {
    private JTable table;
    private JLabel resultLabel;

    public JTableVariation(int rows, int cols) {
        // Установка заголовка окна
        setTitle("Таблица");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Центрирование окна

        // Создание модели таблицы
        DefaultTableModel model = new DefaultTableModel(rows, cols);
        table = new JTable(model);

        // Добавление таблицы в прокручиваемую панель
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Создание кнопки для проверки последовательности
        JButton checkButton = new JButton("Проверить последовательность");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSequence();
            }
        });

        // Создание метки для отображения результата
        resultLabel = new JLabel("Результат: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Добавление кнопки и метки в нижнюю панель
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(checkButton, BorderLayout.NORTH);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Отображение окна
        setVisible(true);
    }

    private void checkSequence() {
        int rows = table.getRowCount();
        int cols = table.getColumnCount();
        int[][] array = new int[rows][cols];

        // Считывание данных из таблицы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Object value = table.getValueAt(i, j);
                if (value == null || value.toString().trim().isEmpty()) {
                    resultLabel.setText("Результат: Введите корректные целые числа.");
                    return;
                }
                try {
                    array[i][j] = Integer.parseInt(value.toString());
                } catch (NumberFormatException e) {
                    resultLabel.setText("Результат: Введите корректные целые числа.");
                    return;
                }
            }
        }

        // Проверка последовательности
        Function function = new Function();
        boolean isFulfilling = function.isSequenceFulfilling(array);
        resultLabel.setText("Результат: " + (isFulfilling ? "Последовательность соблюдается." : "Последовательность не соблюдается."));
    }
}