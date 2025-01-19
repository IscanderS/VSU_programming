import java.util.ArrayList;
import java.util.List;

public class SubsequenceFinder {
    public static List<Integer> findMaxSumSubsequence(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int maxLength = 0;
        int currentLength = 0;
        int startIndex = 0;
        int bestStartIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            currentSum += list.get(i);
            currentLength++;

            // Если текущая сумма больше максимальной, обновляем максимальные значения
            if (currentSum > maxSum || (currentSum == maxSum && currentLength < maxLength)) {
                maxSum = currentSum;
                maxLength = currentLength;
                bestStartIndex = startIndex;
            }

            // Если текущая сумма становится отрицательной, сбрасываем
            if (currentSum < 0) {
                currentSum = 0;
                currentLength = 0;
                startIndex = i + 1; // Начинаем новую подпоследовательность
            }
        }

        // Копируем элементы в результирующий список
        for (int i = bestStartIndex; i < bestStartIndex + maxLength; i++) {
            result.add(list.get(i));
        }

        return result;
    }
}