public class StringSearch {
    
    // Our DSA Algorithm Method
    public static int findNameIndex(String[] names, String target) {
        
        // Step 1: Loop through the array from start to finish (Linear Search)
        for (int i = 0; i < names.length; i++) {
            
            // Step 2: The Interview Trap!
            // We MUST use .equals() to compare the actual letters inside the Objects.
            // If we used (names[i] == target), Java would only check if they 
            // share the exact same memory address in the Heap, causing random bugs.
            if (names[i].equals(target)) {
                
                // Step 3: If we find a match, immediately return the primitive index
                return i; 
            }
        }
        
        // Step 4: If the loop finishes and we never found the target, return -1
        return -1; 
    }

    public static void main(String[] args) {
        // Our test data
        String[] studentArray = {"Lakshit", "Rahul", "Pankaj"};
        String target = "Rahul";
        
        // Execute the algorithm
        int result = findNameIndex(studentArray, target);
        
        System.out.println("Target found at index: " + result);
    }
}