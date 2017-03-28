import java.util.ArrayList;
import java.util.Scanner;


public class Problem11_13 {

    public static void main(String[] args) {

        System.out.print("Enter 10 integers: ");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(input.nextInt());

        System.out.println("Removing duplicates...");
        removeDuplicate(list);
        System.out.println("Displaying list...");
        System.out.println(list);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(temp);

    }
}