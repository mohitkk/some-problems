package general;

public class SpiralMatrix {

    public static void main(String args[]){
        int [][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        int rows = input.length;
        int cols = input[0].length;

//        System.out.println(rows+" "+cols);

        int rowStart = 0;
        int rowEnd = rows-1;
        int colStart = 0;
        int colEnd = cols-1;


        System.out.println("------------------");
        for(int row=0;row<rows;row++){
            for(int col =0;col<cols;col++){
                System.out.print(input[row][col]+"          ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        while(rowStart<=rowEnd && colStart<=colEnd){
//            System.out.println("while");
            for(int i=colStart;i<=colEnd;i++){
                System.out.print(input[rowStart][i]+"@  ");
            }
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++){
                System.out.print(input[i][colEnd]+"# ");
            }
            colEnd--;
            if(rowStart<=rowEnd){
                for(int i=colEnd;i>=colStart;i--){
                    System.out.print(input[rowEnd][i]+"@  ");
                }
                rowEnd--;
            }
            if(colStart<=colEnd){
                for(int i=rowEnd;i>=rowStart;i--){
                    System.out.print(input[i][colStart]+"# ");
                }
                colStart++;
            }
        }
    }
}
