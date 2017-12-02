package src;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        src.MyArray<String> stringMyArray = new src.MyArray<>();
        stringMyArray.add("Hello");
        stringMyArray.add("World");
        stringMyArray.add("!!!");
        stringMyArray.printMyArray();
        stringMyArray.remove(2);
        System.out.println("After remove with index = 2, size = " + stringMyArray.size() + ", capacity = " + stringMyArray.capacity());
        stringMyArray.printMyArray();
        System.out.println("\n*******************\n");


        MyArray<Integer> myArray = new MyArray<>();
        myArray.add(3478);
        for (int i = 0; i < 5; i++)
            myArray.add(12);
        myArray.add(33);
        myArray.add(665);
        myArray.add(213);
        myArray.printMyArray();
        myArray.add(3, -100);
        myArray.printMyArray();
        myArray.remove(2);
        myArray.printMyArray();
        myArray.remove((Integer) 33);
        System.out.println("After remove size: " + myArray.size());
        System.out.println("After remove capacity: " + myArray.capacity());
        myArray.trimToSize();
        System.out.println("After trim size: " + myArray.size());
        System.out.println("After trim capacity: " + myArray.capacity());
//        Iterator<Integer> it = myArray.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        System.out.println("\n*******************\n");


        System.out.println(myArray.getIndexOfArray(12));
        System.out.println(myArray.getLastIndexOfMyArray(12));
        System.out.println("Initial size: " + myArray.size());
        System.out.println("Initial capacity: " + myArray.capacity());
        myArray.remove(1);
        System.out.println("After remove size: " + myArray.size());
        System.out.println("After remove capacity: " + myArray.capacity());
        myArray.printMyArray();
        myArray.trimToSize();
        System.out.println("After trim size: " + myArray.size());
        System.out.println("After trim capacity: " + myArray.capacity());
        myArray.set(2, -78);
        myArray.add(3);
        myArray.add(321);
        myArray.add(2);
        System.out.println("New capacity after added: " + myArray.capacity());
        System.out.println("New size after added: " + myArray.size());
        myArray.printMyArray();
        for (int i = 0; i < 4; i++)
            myArray.remove(1);
        myArray.printMyArray();
    }
}
