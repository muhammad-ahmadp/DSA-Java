/**
 * LinearSearchDemo.java
 * Demonstrates multiple linear search operations in Java:
 * 1. Find all indices of a target element and count occurrences.
 * 2. Find the first repeating element in an array.
 * 3. Find the largest element and its last occurrence.
 * 4. Find both smallest and largest elements with first and last occurrences.
 * 5. Search a target element, print indices, count, and difference between first and last occurrence.
 * Author: Muhammad Ahmad
 */
public class LinearSearchDemo {
    public static void main(String[] args) {
        // Sample arrays and target values for testing
        int[] numbers = {3, 9, 2, 9, 4, 5, 9, 5, 6};
        int[] numbersWithRepeats = {10, 5, 3, 4, 3, 5, 6};
        int[] mixedNumbers = {4, 2, 7, 2, 9, 7, 1, 4, 9};
        int[] sampleNumbers = {3, 5, 2, 5, 6, 5, 7};
        int target1 = 9;
        int target2 = 5;

        // Find all indices of 'target1' in numbers and count occurrences
        int count1 = findAllIndices(numbers, target1);
        if(count1 == 0){
            System.out.println("-1"); // Target not found
        } else {
            System.out.println("Count: " + count1);
        }

        // Find the first repeating element in numbersWithRepeats
        int firstRepeating = findFirstRepeating(numbersWithRepeats);
        System.out.println("First repeating element: " + firstRepeating);

        // Find the largest element in numbers and its last occurrence
        findLargestElement(numbers);

        // Find both smallest and largest elements in mixedNumbers along with first and last occurrences
        findSmallestAndLargest(mixedNumbers);

        // Search for target2 in sampleNumbers, print indices, count, and difference between first and last occurrence
        int count2 = searchTargetInArray(sampleNumbers, target2);
        System.out.println(count2);
    }

    // Find all indices where the target value occurs and return total count
    static int findAllIndices(int[] arr, int target){
        if (arr.length == 0) return -1; // Array empty

        int count = 0;
        System.out.print("Indices: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                System.out.print(i + " "); // Print index of target
                count++;
            }
        }
        System.out.println(); // New line after indices
        return count; // Return total occurrences
    }

    // Find the first repeating element in the array
    // Returns element with first occurrence the smallest index
    static int findFirstRepeating(int[] arr) {
        int firstRepeatingIndex = arr.length; // Default: no repeat

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    firstRepeatingIndex = Math.min(firstRepeatingIndex, i);
                    break; // Stop inner loop after first repeat found for current i
                }
            }
        }

        if (firstRepeatingIndex == arr.length) return -1; // No repeating element
        return arr[firstRepeatingIndex];
    }

    // Find the largest element and its last occurrence index
    static void findLargestElement(int[] arr) {
        if(arr.length == 0){
            System.out.println("Array is empty!");
            return;
        }

        int largest = arr[0];
        int lastIndex = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest){
                largest = arr[i];
                lastIndex = i; // Update last occurrence for new largest
            } else if(arr[i] == largest){
                lastIndex = i; // Update last occurrence for equal largest
            }
        }

        System.out.println("Largest element: " + largest);
        System.out.println("Last occurrence index: " + lastIndex);
    }

    // Find both smallest and largest elements with first and last occurrence indices
    static void findSmallestAndLargest(int[] arr) {
        if (arr.length == 0){
            System.out.println("Array is empty!");
            return;
        }

        int max = arr[0], min = arr[0];
        int maxFirstIndex = 0, maxLastIndex = 0;
        int minFirstIndex = 0, minLastIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            // Update largest element and indices
            if (arr[i] > max){
                max = arr[i];
                maxFirstIndex = i;
                maxLastIndex = i;
            } else if (arr[i] == max){
                maxLastIndex = i; // Only update last occurrence
            }

            // Update smallest element and indices
            if (arr[i] < min){
                min = arr[i];
                minFirstIndex = i;
                minLastIndex = i;
            } else if (arr[i] == min){
                minLastIndex = i; // Only update last occurrence
            }
        }

        // Print largest element details
        System.out.println("Largest element: " + max);
        System.out.println("First occurrence index: " + maxFirstIndex);
        System.out.println("Last occurrence index: " + maxLastIndex);

        // Print smallest element details
        System.out.println("Smallest element: " + min);
        System.out.println("First occurrence index: " + minFirstIndex);
        System.out.println("Last occurrence index: " + minLastIndex);
    }

    // Search for target in array, print all indices, count, and difference between first and last occurrence
    static int searchTargetInArray(int[] arr, int target){
        if (arr.length == 0) return -1; // Array empty

        int count = 0;
        int firstIndex = -1; // Initialize first occurrence
        int lastIndex = -1;  // Initialize last occurrence

        System.out.print("Indices: ");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                System.out.print(i + " "); // Print index
                count++;
                if(firstIndex == -1) firstIndex = i; // Store first occurrence
                lastIndex = i; // Update last occurrence
            }
        }
        System.out.println(); // New line after indices
        System.out.println("Target element: " + target);
        System.out.println("Count: " + count);

        if(count > 0){
            int difference = lastIndex - firstIndex; // Difference between first and last occurrence
            System.out.println("Difference between first and last occurrence: " + difference);
        }

        return count; // Return total occurrences
    }
}