public class MergeSorter {

    // ==========================================
    // 1. THE BOSS (The Ignition Switch)
    // ==========================================
    public static void main(String[] args) {
        
        // The Boss creates the unsorted data in the Heap memory.
        int[] testArray = {38, 27, 43, 3, 9, 82, 10};

        // Print the original numbers to the screen
        System.out.print("Original Array: ");
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println(); // Moves to a new line

        // THE HANDOFF: The Boss calls our custom 'mergeSort' method and hands it the array.
        // The main method pauses here and waits for the workers to finish.
        mergeSort(testArray);

        // The workers are done! The Boss wakes up and prints the newly sorted array.
        System.out.print("Sorted Array:   ");
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
    }


    // ==========================================
    // 2. THE CHOPPER (Divides the array)
    // ==========================================
    public static void mergeSort(int[] array) {
        
        // EMERGENCY BRAKE: If the array only has 1 item (or is empty), 
        // it cannot be chopped anymore. We return and stop this specific task.
        if (array.length < 2) {
            return; 
        }

        // Find the exact middle index of the array
        int mid = array.length / 2;
        
        // Go to the memory and build two brand new, empty arrays.
        // leftHalf gets the size of 'mid'. rightHalf gets whatever is leftover.
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[array.length - mid];

        // Copy the actual numbers from the main array into our new leftHalf
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }
        
        // Copy the remaining numbers into our new rightHalf
        for (int i = mid; i < array.length; i++) {
            rightHalf[i - mid] = array[i];
        }

        // THE RECURSION: The Chopper calls clones of itself to chop these new halves.
        // This will keep happening until everything is broken down into 1-item arrays.
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Once the Chopper is finished breaking things down, it calls the Zipper
        // to stitch these specific halves back together in order.
        merge(array, leftHalf, rightHalf);
    }


    // ==========================================
    // 3. THE ZIPPER (Merges sorted halves together)
    // ==========================================
    private static void merge(int[] targetArray, int[] leftHalf, int[] rightHalf) {
        
        // Set up 3 "pointers" (fingers) to keep track of our positions
        int leftIndex = 0;   // Finger pointing at the left array
        int rightIndex = 0;  // Finger pointing at the right array
        int targetIndex = 0; // Finger pointing at the empty slots in the master array

        // THE BATTLE: While BOTH arrays still have numbers in them...
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            
            // Compare the numbers our fingers are pointing at.
            // If the left number is smaller (or equal)...
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                targetArray[targetIndex] = leftHalf[leftIndex]; // Copy left number to master
                leftIndex++; // Move the left finger forward
            } 
            // If the right number is smaller...
            else {
                targetArray[targetIndex] = rightHalf[rightIndex]; // Copy right number to master
                rightIndex++; // Move the right finger forward
            }
            
            // No matter who won the battle, move the master array finger forward to the next empty slot
            targetIndex++; 
        }

        // CLEANUP (Leftovers): 
        // If the right array ran out of numbers first, the left array might still have numbers.
        // Because they are already sorted, we just blindly copy the rest into the master array.
        while (leftIndex < leftHalf.length) {
            targetArray[targetIndex] = leftHalf[leftIndex];
            leftIndex++;
            targetIndex++;
        }

        // If the left array ran out first, we blindly copy the remaining right array numbers.
        while (rightIndex < rightHalf.length) {
            targetArray[targetIndex] = rightHalf[rightIndex];
            rightIndex++;
            targetIndex++;
        }
    }
}