public class array {
    
    public static void main(String[] args){
        
        // ==========================================
        // 1. PRIMITIVE ARRAY (Raw Data)
        // ==========================================
        
        // This creates an array of basic integers.
        // In memory, the numbers 10, 20, 30, and 40 are stored 
        // directly inside the array's contiguous memory block.
        int[] arr = {10, 20, 30, 40};
        
        // The .length property tells us exactly how many items are in the array.
        // Here, 'n' becomes 4.
        int n = arr.length;

        System.out.print("Primitive Array -> ");
        
        // This loop starts at index 0 and runs until index 3.
        // It fetches and prints each raw number one by one.
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // This just prints a blank line so the next output starts on a fresh line.
        System.out.println();


        // ==========================================
        // 2. NON-PRIMITIVE ARRAY (Object References)
        // ==========================================
        
        // This creates an array of String objects.
        // Unlike primitives, the actual words "Lakshit", "Rahul", etc., 
        // are NOT stored directly inside the array. 
        // Instead, the array simply holds the memory addresses (pointers) 
        // to where these Strings actually live in the Heap memory.
        String[] names = {"Lakshit", "Rahul", "Pankaj"};

        System.out.print("Non-Primitive Array -> ");
        
        // Here, we skip creating a variable for 'n' and just use names.length directly.
        // It loops from index 0 to 2, following the memory address at each index 
        // to fetch and print the actual String object.
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
    }
}