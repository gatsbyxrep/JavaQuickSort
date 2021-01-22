
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main
{
	public static <T> void printArray(T[] array) {
        for(T element : array)
            System.out.print(element + " ");
    }
	public static <T extends Comparable<T>> T getMinOfArray(T[] array) {
        T min = array[0];
        for(T element : array)
            if(element.compareTo(min) < 0)
                min = element;
        return min;
    }
	public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        int left = low;
        int right = high;
        T pivot = array[(high + low) / 2];
        while(left <= right)
        {
            while(array[left].compareTo(pivot) < 0)
                left++;
            while(array[right].compareTo(pivot) > 0)
                right--;
            if(left <= right) {
                T tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
            if(low < right)
                quickSort(array, low, right);
            if(high > left)
                quickSort(array, left, high);
        }
        
    }
	public static void main(String[] args) {    
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input array size");
		int arraySize = scanner.nextInt();
		Integer[] array = new Integer[arraySize];
		for(int i = 0; i < array.length; i++)
			array[i] = scanner.nextInt();
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
