import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите высоту");
        int h = scanner.nextInt();

        System.out.println("Введите ширину");
        int w = scanner.nextInt();

        printFigure(h, w);
    }

    public static void printFigure(int h, int w) {
        
        int sNum, sNumCur, pos, curPos, curStr;

        h = h -2;
        w = w -1;
        sNum = 1;
        sNumCur= 1;
        pos = 0;
        curPos = 0;
        curStr = 0;



        for (int i = 0; i < w; i++) {
            System.out.print("_"); 
        }

        System.out.println(); 

        while(curStr < h) {
            System.out.print("|"); 
            while (pos > 0) {
                System.out.print(" ");
                curPos += 1;
            }
            while (curPos < w && sNumCur > 0) {
                System.out.print("!");
                sNumCur -= 1;
                curPos += 1;
            }
            if (curPos == w && sNumCur > 0) {
                System.out.print("|");
                System.out.println();
                pos = 0;
                curPos = 0;
                curStr += 1;
            }
            if (curPos == w && sNumCur == 0) {
                System.out.print("|");
                System.out.println();
                pos = 0;
                curPos = 0;
                sNum += 1;
                sNumCur = sNum;
                curStr += 1;
            }
            if (curPos < w && sNumCur == 0) {
                pos = curPos;
                while (curPos < w) {
                    System.out.print(" ");
                    curPos += 1;
                }
                curPos = 0;
                System.out.print("|");
                System.out.println();  
                sNum += 1;
                sNumCur = sNum; 
                curStr += 1;
            }
        }
    } 
}  
