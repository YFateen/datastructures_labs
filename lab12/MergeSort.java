import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> toReturn = new Queue<Queue<Item>>();
        if (items.isEmpty()) {
            return toReturn;
        }
        for (Item x: items) {
            Queue<Item> tempQueue = new Queue<Item>();
            tempQueue.enqueue(x);
            toReturn.enqueue(tempQueue);
        }
        return toReturn;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2;
        } else if (q2.isEmpty()) {
            return q1;
        }
        Queue<Item> toReturn = new Queue<Item>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            toReturn.enqueue(getMin(q1, q2));
        }
        return toReturn;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        if (items.size() == 1) {
            return items;
        }
        Queue<Queue<Item>> idk = makeSingleItemQueues(items);
        Queue<Item> halfOne = new Queue<Item>();
        Queue<Item> halfTwo = new Queue<Item>();

        int itemsSize = idk.size() / 2;
        while (itemsSize != 0) {
            halfOne.enqueue(idk.dequeue().dequeue());
            itemsSize--;
        }
        while (!idk.isEmpty()) {
            halfTwo.enqueue(idk.dequeue().dequeue());
        }
        return mergeSortedQueues(mergeSort(halfOne), mergeSort(halfTwo));


    }

    public static void main(String[] args) {
        Queue<String> students = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        students.enqueue("Max");
        students.enqueue("Billy");
        System.out.println(students.toString());

        Queue<String> toReturn = mergeSort(students);

        System.out.println(students.toString());
        System.out.println(toReturn.toString());

//        Queue<Integer> int1 = new Queue<Integer>();
//        int1.enqueue(1);
//        int1.enqueue(2);
//        int1.enqueue(3);
//        int1.enqueue(4);
//
//        Queue<Integer> int2 = new Queue<Integer>();
//        int2.enqueue(5);
//        int2.enqueue(6);
//        int2.enqueue(7);
//        int2.enqueue(8);
//
//        System.out.println(MergeSort.mergeSortedQueues(int2, int1).toString());

    }
}
