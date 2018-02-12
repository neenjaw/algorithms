import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class FindSumOfPair {
  public static void findNaivePair(int[] a, int sum) {
    for (int i = 0; i < a.length; i++ ) {
      for (int j = i + 1; j < a.length; j++) {
        if ( a[i] + a[j] == sum ) {
          System.out.println("Pair found at index " + j + " and " + i);
        }
      }
    }
  }

  public static void findSortedPair(int[] a, int sum) {
    Arrays.sort(a);

    //maintain to indexes
    int low = 0;
    int high = a.length - 1;

    while (low < high) {
      if (a[low] + a[high] == sum) {
        System.out.println("Pair found at index " + low + " and " + high);
      }

      if (a[low] + a[high] < sum) {
        low++;
      } else {
        high--;
      }
    }
  }

  public static void findHashPair(int[] a, int sum) {
    //Create empty Hasp Map
    Map<Integer, Integer> map = new HashMap<>();

    //do for each element in the passed array
    for (int i = 0; i < a.length; i++) {
      if (map.containsKey(sum - a[i])) {
        System.out.println("Pair found at index " + map.get(sum - a[i]) + " and " + i);
        // return;
      }

      //store the index of the array with the number as the key
      map.put(a[i], i);
    }

    System.out.println("Pair not found");
  }

  public static void main (String[] args) {
    int[] a = { 66, 51, 41, 59, 23, 55, 20, 46, 17, 60, 50, 75, 77, 68, 4, 18, 11, 67, 72, 90, 57, 70, 36, 49, 71, 58, 5, 42, 98, 39, 100, 40, 43, 97, 76, 19, 47, 27, 87, 56, 13, 79, 24, 16, 37, 26, 89, 82, 92, 63, 53, 29, 3, 93, 62, 33, 8, 61, 74, 85, 54, 65, 1, 52, 48, 95, 69, 6, 45, 73, 91, 99, 86, 78, 31, 35, 80, 83, 28, 12, 34, 22, 25, 81, 32, 88, 94, 96, 7, 2, 44, 10, 15, 38, 30, 84, 21, 14, 9, 64 };
    int sum = 75;

    long startTime = System.nanoTime();
    findNaivePair(a, sum);
    long endTime = System.nanoTime();

    long duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    findSortedPair(a, sum);
    endTime = System.nanoTime();

    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    findHashPair(a, sum);
    endTime = System.nanoTime();

    duration = (endTime - startTime);
    System.out.println(duration);
  }
}