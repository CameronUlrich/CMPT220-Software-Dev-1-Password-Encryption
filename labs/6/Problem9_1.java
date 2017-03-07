


public class Problem9_1 {

    public static void main(String[] args) {
    	MyRec2[] rectangles = new MyRec2[2];
        rectangles[0] = new MyRec2(4,40);
        rectangles[1] = new MyRec2(3.5, 35.9);


        

        for (int i = 0; i < 2; i++){
            System.out.println("MyRec2 " + (i+1) +":");
            System.out.print("Area = " + rectangles[i].getArea());
            System.out.println(" Perimeter = " +  rectangles[i].getPerimeter() +"\n");
        }
    }
}