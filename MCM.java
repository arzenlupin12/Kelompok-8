import java.util.*;
import java.util.stream.Stream;

public class MCM{

    static char name = 'A';
    //Algortima Matrix Chain Multiplication
    public static ArrayList MatrixChainOrder(Integer p[]){
        //Inisialisasi n dan Array m,s
        Integer n = p.length-1;
        Integer m [][] = new Integer[n+1][n+1];
        Integer s [][] = new Integer[n+1][n+1];

        //buat nilai awal matrix untuk [i,i] menjadi 0
        for(int i = 1; i <= n; i++){
            m[i][i] = 0; 
        }

        //start dari 2 karena nilai 1 sudah bernilai 0
        for(int l = 2; l <= n ; l++){
            for(int i = 1; i <= n-l+1;i++){
                Integer j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k <= j-1;k++){
                    Integer q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
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

    public static void PrintOptimalParent(Integer s[][], int i, int j){
        if(i==j){
            System.out.print(name++);
        }else{
            System.out.print("(");
            PrintOptimalParent(s, i, s[i][j]);
            PrintOptimalParent(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set <Integer> inputUser = new LinkedHashSet<>();
        try{
            System.out.print("Masukan Jumlah Matrix yang Akan Dihitung : ");
            Integer jumlahMatrix = in.nextInt();
            in.nextLine();
            String input[] = new String[jumlahMatrix];  
            for (int i = 0; i < jumlahMatrix; i++) {
                System.out.print("Matrix ke "+(i+1)+" (Contoh Input : 30x35) :  ");               
                String str = in.nextLine();
                str = str.replaceAll("[a-zA-Z]", " ");
                input[i] = str;
            }
            for (int i = 0; i < input.length; i++) {
                String tmp = input[i];
                String spliited[] = tmp.split(" ");
                inputUser.add(Integer.parseInt(spliited[0]));
                inputUser.add(Integer.parseInt(spliited[1]));
            }         
            Integer[] values = new Integer[inputUser.size()];
            inputUser.toArray(values);
            ArrayList <Integer[][]> arr2 = MatrixChainOrder(values);
            Integer a[][] = arr2.get(0);
            Integer b[][] = arr2.get(1);
            System.out.println("=============================================================");
            System.out.println("\nMatrix Jumlah Perkalian : ");
            for(int i = 1 ; i < a.length ; i++){
                for(Integer j = 1; j < a[i].length ; j++){
                    if(a[i][j]==null){
                        System.out.print(0+"\t");
                    }else{
                        System.out.print(a[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println("=============================================================");
            System.out.println("\nTabel K : ");
            for(Integer i = 1 ; i < b.length ; i++){
                for(Integer j = 1; j < b[i].length ; j++){
                    if(b[i][j]==null){
                        System.out.print(0+"\t");
                    }else{
                        System.out.print(b[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println("=============================================================");
            System.out.print("Optimal Parent : ");
            PrintOptimalParent(b, 1, b.length-1);
            System.out.println("=============================================================");
            in.close();
                
        }finally{

        }
        
    }
}