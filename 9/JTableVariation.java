import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class JTableVariation extends JFrame {
    private JTable table;
    private JLabel resultLabel;

    public JTableVariation(int rows, int cols) {
        // Установка заголовка окна
        setTitle("Введите массив");
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

        // Создание кнопки для загрузки данных из файла
        JButton loadButton = new JButton("Загрузить из файла");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });

        // Создание кнопки для сохранения массива и результата в файл
        JButton saveButton = new JButton("Сохранить в файл");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        // Создание метки для отображения результата
        resultLabel = new JLabel("Результат: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Добавление кнопок и метки в нижнюю панель
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 1));
        bottomPanel.add(checkButton);
        bottomPanel.add(loadButton);
        bottomPanel.add(saveButton);
        bottomPanel.add(resultLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        // Отображение окна
        setVisible(true);
    }

    private void checkSequence() {
        int rows = table.getRowCount();
        int cols = table.getColumnCount();
        List<Integer> list = new ArrayList<>();

        // Считывание данных из таблицы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Object value = table.getValueAt(i, j);
                if (value != null && !value.toString().trim().isEmpty()) {
                    try {
                        list.add(Integer.parseInt(value.toString()));
                    } catch (NumberFormatException e) {
                        resultLabel.setText("Результат: Введите корректные целые числа.");
                        return;
                    }
                }
            }
        }

        // Проверка последовательности
        List<Integer> result = SubsequenceFinder.findMaxSumSubsequence(list);
        resultLabel.setText("Результат: " + result);
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Очистка текущих данных
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\\s+"); // Разделение по пробелам
                    model.addRow(values);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Ошибка при загрузке файла: " + e.getMessage());
            }
        }
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rows = model.getRowCount();
                int cols = model.getColumnCount();

                // Сохранение данных таблицы
                for (int i = 0; i < rows; i++) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < cols; j++) {
                        row.append(model.getValueAt(i, j));
                        if (j < cols - 1) {
                            row.append(" "); // Разделение значений пробелом
                        }
                    }
                    bw.write(row.toString());
                    bw.newLine();
                }

                // Сохранение результата
                String resultText = resultLabel.getText().replace("Результат: ", "");
                bw.write("Результат: " + resultText);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Ошибка при сохранении файла: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTableVariation(5, 5)); // Пример с 5 строками и 5 столбцами
    }
}