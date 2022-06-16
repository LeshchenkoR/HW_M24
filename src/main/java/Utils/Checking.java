package Utils;

import java.util.List;

public class Checking {
    public Checking() {
    }

    public static void checkSize(List arr1, List arr2) {
        System.out.println();
        System.out.println("Размеры массивов совпадают: " + String.valueOf(arr1.size() == arr2.size()) +"\n");
    }
}
