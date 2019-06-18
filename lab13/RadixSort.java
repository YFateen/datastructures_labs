import java.util.Map;
import java.util.HashMap;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra
 * @version 1.4 - April 14, 2016
 *
 **/
public class RadixSort
{

    /**
     *  Does Radix sort on the passed in array with the following restrictions:
     *  The array can only have ASCII Strings (sequence of 1 byte characters)
     *  The sorting is stable and non-destructive
     *  The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     **/

    /*
     * DISCLAIMER: I spent 4-5 hours trying to get this method to work and I failed miserably. The following
     * implementation is based entirely on the staff solution shown at the end of lab.
     *
     **/
    public static String[] sort(String[] asciis) {
//        int max = Integer.MIN_VALUE;
//        for (String i : asciis) {
//            if (i.length() > max) {
//                max = i.length();
//            }
//        }
//        String[] toReturn = new String[asciis.length];
//        for (int i = 0; i < asciis.length; i++) {
//            toReturn[i] = asciis[i];
//        }
        String[] sortedArray = new String[asciis.length];
        System.arraycopy(asciis, 0, sortedArray, 0, asciis.length);
        sortHelper(sortedArray, 0, asciis.length, 0);
        return sortedArray;
    }

    /**
     * Radix sort helper function that recursively calls itself to achieve the sorted array
     *  destructive method that changes the passed in array, asciis
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelper(String[] asciis, int start, int end, int index) {
        if (start + 1 >= end) {
            return;
        }

        int[]countArray = new int[258];
        for (int i = start; i < end; i++) {
            int thePosition;
            if (index < asciis[i].length()) {
                thePosition = asciis[i].charAt(index) + 2;
            } else {
                thePosition = 1;
            }
            countArray[thePosition]++;
        }

        for (int i =0; i < countArray.length - 1; i++) {
            countArray[i+1] += countArray[i];
        }

        String[] sortingArray = new String[asciis.length];

        for (int i=start; i <end; i++) {
            int thePosition;
            if (index < asciis[i].length()) {
                thePosition = asciis[i].charAt(index) + 1;
            } else {
                thePosition = 0;
            }
            sortingArray[countArray[thePosition]] = asciis[i];
            countArray[thePosition]++;
        }

        System.arraycopy(sortingArray, 0, asciis, start, end - start);

        for (int i =0; i < countArray.length-1; i++) {
            sortHelper(asciis, start + countArray[i], start + countArray[i + 1], index + 1);
        }

    }

//    public static void main(String[] args) {
//        String[] toppings = new String[10];
//
//        toppings[0] = "cheese";
//        toppings[1] = "pepperoni";
//        toppings[2] = "blackOlives";
//        toppings[3] = "bellpeppars";
//        toppings[4] = "apples";
//        toppings[5] = "delimeats";
//        toppings[6] = "extracheese";
//        toppings[7] = "pineapple";
//        toppings[8] = "tomatoes";
//        toppings[9] = "fuckme";
//
//        String[] newArray = sort(toppings);
//
//        for (String i: toppings) {
//            System.out.println(i.toString());
//        }
//
//        System.out.println();
//        System.out.println();
//
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.println(newArray[i] + ", ");
//        }
//    }
}
