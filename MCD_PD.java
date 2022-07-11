import java.util.*;

public class MCD_PD{

    public static ArrayList MatrixChainOrder(int p[]){
        int n = p.length-1;
        int j;
        int m [][] = new int[n+1][n+1];
        int s [][] = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            m[i][i] = 0; 
        }

        for(int l = 2; l <= n ; l++){
            for(int i = 1; i <= n-l+1;i++){
                j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k <= j-1;k++){
                    int q = m[i][k] + m[k+1][j]+p[i-1]*p[k]+p[j];
                    if (q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        ArrayList arr = new ArrayList<>();
        arr.add(m);
        arr.add(s);

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukan Array p[] (Misal User Input = 5, 3, 8, 9, 19)");
        String input = in.nextLine();
        
        int p[] = {5, 3, 8, 9, 10, 35, 50,28};
        ArrayList <int[][]> arr2 = MatrixChainOrder(p);
        int a[][] = arr2.get(0);
        int b[][] = arr2.get(1);

        for(int i = 1 ; i < a.length-1 ; i++){
            for(int j = 1; j < a[i].length ; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(int i = 1 ; i < b.length-1 ; i++){
            for(int j = 1; j < b[i].length ; j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
       
    }
}