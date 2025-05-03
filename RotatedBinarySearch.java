
public class RotatedBinarySearch {
    public static void main(String[] args) {
        String[] arr = {"kale", "lemon", "mango", "orange", "apple", "banana", "cherry"};
        String target = "banana";

        int index = search(arr, target);
        if (index != -1) {
            System.out.println("Found '" + target + "' at index: " + index);
        } else {
            System.out.println("'" + target + "' not found in the array.");
        }
    }

    public static int search(String[] arr, String target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid].equals(target)) {
                return mid;
            }

            // Left half is sorted
            if (arr[left].compareTo(arr[mid]) <= 0) {
                if (arr[left].compareTo(target) <= 0 && target.compareTo(arr[mid]) < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[mid].compareTo(target) < 0 && target.compareTo(arr[right]) <= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
}
