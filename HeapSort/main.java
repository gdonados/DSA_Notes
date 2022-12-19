import java.util.ArrayList;

public class main {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(7);
        list.add(1);
        list.add(32);
        list.add(16);
        list.add(4);
        list.add(9);
        list.add(55);
        list.add(70);
        list.add(3);
        list.add(82);
        list.add(99);
        list.add(8);
        list.add(63);
        list.add(0);
        list.add(45);

        System.out.println("Initial List: "+list.toString());
        heapify2(list);
        System.out.println("Heapified list: "+list.toString());
        heapSort(list);
        System.out.println("Heap sorted list: "+list.toString());
    }

    public static void heapify2(ArrayList<Integer> list)
    {
        int size = list.size();
        int largest = -1;
        int leftI, rightI = -1;
        int tmp, swap = -1;
        int j = -1;
        boolean done = false;
        for(int i = (size/2)-1; i >= 0; i--)
        {
            j = i;
            while(j < (size-1)/2 && !done)
            {
                leftI = 2 * j + 1;
                rightI = 2 * j + 2;

                if (leftI < size && list.get(leftI) > list.get(rightI)) {
                    largest = leftI;
                } else  {
                    largest = rightI;
                }

                if(list.get(j) > list.get(largest))
                {
                    done = true;
                }
                else
                {
                    swap = list.get(largest);
                    tmp = list.remove(j);
                    list.add(j, swap);
                    list.remove(largest);
                    list.add(largest, tmp);
                    j = largest;
                }
            }

            done = false;
        }
    }

    public static void heapSort(ArrayList<Integer> list)
    {
        int size = list.size();
        int tmp, swap, n = -1;
        int j = 0;
        int leftI, rightI = -1;
        boolean done  = false;
        int largest = -1;
        for(int i = 0; i < size; i++)
        {
            n = size-i-1;
            swap = list.get(0);
            tmp = list.remove(n);
            list.add(n, swap);
            list.remove(0);
            list.add(0, tmp);

            j = 0;

            while(j < (n-1)/2 && !done)
            {
                leftI = 2 * j + 1;
                rightI = 2 * j + 2;

                if (rightI < size && list.get(rightI) > list.get(leftI)) {
                    largest = rightI;
                } else {
                    largest = leftI;
                }

                if(list.get(j) > list.get(largest))
                {
                    done = true;
                }
                else
                {
                    swap = list.get(largest);
                    tmp = list.remove(j);
                    list.add(j, swap);
                    list.remove(largest);
                    list.add(largest, tmp);
                    j = largest;
                }
            }

            done = false;
        }
    }
}
