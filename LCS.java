import java.util.*;

public class LCS {
    public static void main(String[] args) {
        // String X[] = {"A","B","C","B","D","A","B"};
        // String Y[] = {"B","D","C","A","B","A"};
        // LCS_Lenght(X, Y);

        Scanner in = new Scanner(System.in);
        System.out.println("Input X : ");
        String Input_X = in.nextLine();
        System.out.println("Input Y : ");
        String Input_Y = in.nextLine();
        
        String X[] = Input_X.split("");
        String Y[] = Input_Y.split("");
        LCS_Lenght(X, Y);   
    }

    public static void LCS_Lenght(String InputX[], String InputY[]){
        int m = InputX.length;
        int n = InputY.length;
        int c[][] = new int[m+1][n+1];
        String b[][] = new String[m+1][n+1];
        
        for(int i = 1; i <= m;i++){
            c[i][0] = 0;
        }
        for(int j = 1; j <= n;j++){
            c[0][j] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(InputX[i-1].equals(InputY[j-1])){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = "\\";
                }else if(c[i-1][j]>= c[i][j-1]){
                    c[i][j] =  c[i-1][j];
                    b[i][j] = "^";
                }else{
                    c[i][j] = c [i][j-1];
                    b[i][j] = "<-";
                }
            }
        }

        for(int i = 0 ; i < c.length ; i++){
            for(int j = 0; j < c[i].length ; j++){
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }

        for(int i = 0 ; i < b.length; i++){
            for(int j = 0; j < b[i].length ; j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
