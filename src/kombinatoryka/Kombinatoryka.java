/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kombinatoryka;

/**
 *
 * @author kbanasik
 */
class  Kombinatoryka{ 
  
    /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static int k = 1; //kb
    static void combinationUtil(int arr[], int data[], int start, 
                                int end, int index, int r) 
    { 
        // Current combination is ready to be printed, print it 
       // int k = 1; //kb
        if (index == r) 
        { 
            System.out.println("Kombinacja nr: " + k); 
            for (int j=0; j<r; j++) 
            {
              System.out.print(data[j]+" ");  
              k++; //kb
            }
                
            System.out.println(""); 
            
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combinationUtil(arr, data, i+1, end, index+1, r); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r); 
    } 
  
    /*Driver function to check for above function*/
    public static void main (String[] args) { 
        Obciazenie snieg = new Obciazenie(1, 0, "Snieg");
        Obciazenie snieg_2 = new Obciazenie(2, 0, "Snieg");
        Obciazenie wiatr_x_plus = new Obciazenie(3, 1, "Wiatr X+");
        Obciazenie wiatr_x_minus = new Obciazenie(4, 1, "Wiatr X+");
        
        int arr[] = {snieg.id, snieg_2.id, wiatr_x_plus.id, wiatr_x_minus.id}; 
        int r = 2; 
        int n = arr.length; 
        
        int k = 0;
        for(int i = 0; i < arr.length; i++)
        {
            r = i+1;
            printCombination(arr, n, r); 
            k++;
            
        }
        
       // System.out.println("Liczba kombinacji: " + k);
        
    } 
} 