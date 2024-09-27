public class SearchInSortedAndRotatedArray {

    int searchInrotatedArray(int arr[], int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        // If the key is at mid
        if (arr[mid] == key) {
            return mid;
        }

        // If the left half is sorted
        if (arr[left] <= arr[mid]) {
            // Check if the key lies in the left half
            if (key >= arr[left] && key <= arr[mid]) {
                return searchInrotatedArray(arr, key, left, mid - 1);  // Explore left half
            } else {
                return searchInrotatedArray(arr, key, mid + 1, right);  // Explore right half
            }
        }

        // If the right half is sorted
        if (arr[mid] <= arr[right]) {
            // Check if the key lies in the right half
            if (key >= arr[mid] && key <= arr[right]) {
                return searchInrotatedArray(arr, key, mid + 1, right);  // Explore right half
            } else {
                return searchInrotatedArray(arr, key, left, mid - 1);  // Explore left half
            }
        }

        return -1; // If key is not found
    }

    public static void main(String[] args) {
        SearchInSortedAndRotatedArray searchObj = new SearchInSortedAndRotatedArray();
        int arr[] = {6, 7, 8, 9, 10, 1, 2, 5};
        int n = arr.length;
        int key = 8;

        int idx = searchObj.searchInrotatedArray(arr, key, 0, n - 1);
        if (idx == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key exists at index " + idx);
        }
    }
}
