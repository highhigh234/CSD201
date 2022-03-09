
public class Main {

    public static void main(String[] args) {
        int[][] input ={
            {0, 7, 9, 99, 99, 14},
            {7, 0, 10, 15, 99, 99},
            {9, 10, 0, 11, 99, 2},
            {99, 15, 11, 0, 6, 99},
            {99, 99, 99, 6, 0, 9},
            {14, 99, 2, 99, 9, 0}};
        MyGraph mg = new MyGraph();
        mg.setData(input);
        mg.display();
        mg.breadth();
        mg.depth(0);
        
    }
 
//    {
//                    {0,1,1,0,0,0},
//                    {1,0,0,1,0,0},
//                    {1,0,0,0,0,0},
//                    {0,1,0,0,0,0},
//                    {0,0,0,0,0,1},
//                    {0,0,0,0,1,0}};
    

}
