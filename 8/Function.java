public class Function {
    public boolean isSequenceFulfilling(int[][] array) {
        int expectedValue = 0;
        int rows = array.length;
        int cols = array[0].length;
        int x = 0, y = 0;
        int direction = 0;
        int cellIndex = 1;

        while (cellIndex <= rows * cols) {
            if (x < 0 || x >= rows || y < 0 || y >= cols) {
                return true;
            }

            if (array[x][y] < expectedValue) {
                return false;
            }

            if (x == 0 && y == 0) {
                expectedValue = array[0][0];
            }
            expectedValue++;
            cellIndex++;

            if (x == 0) {
                y++;
                direction = 0;
            } else if (x == rows - 1) {
                y++;
                direction = 1;
            } else if (y == 0) {
                x++;
                direction = 1;
            } else if (y == cols - 1) {
                x++;
                direction = 0;
            }

            switch (direction) {
                case 0:
                    x++;
                    y--;
                    break;
                case 1:
                    x--;
                    y++;
                    break;
            }
        }
        return true;
    }
}

