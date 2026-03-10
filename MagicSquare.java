import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[][] mat = new int[3][3];

        System.out.println("--- Magic Square Checker (3x3) ---");

        // Input Phase
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("Enter value for position [" + r + "][" + c + "]: ");
                mat[r][c] = scn.nextInt();
            }
            System.out.println();
        }

        // Calculate the target sum using the first row
        int mSum = mat[0][0] + mat[0][1] + mat[0][2];
        boolean magic = true;

        // Row and Column Check
        for (int r = 0; r < 3; r++) {
            int rSum = 0;
            int cSum = 0;

            for (int c = 0; c < 3; c++) {
                rSum += mat[r][c];
                cSum += mat[c][r];
            }

            if (rSum != mSum || cSum != mSum) {
                magic = false;
                break;
            }
        }

        // Diagonal Check
        if (magic) {
            int d1 = mat[0][0] + mat[1][1] + mat[2][2];
            int d2 = mat[0][2] + mat[1][1] + mat[2][0];

            if (d1 != mSum || d2 != mSum) {
                magic = false;
            }
        }

        // Output Result
        if (magic) {
            System.out.println("Result: This IS a Magic Square (Sum = " + mSum + ")");
        } else {
            System.out.println("Result: This is NOT a Magic Square.");
        }

        scn.close();
    }
}