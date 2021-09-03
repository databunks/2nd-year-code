class GFG { 
      
    // Function to find the total number of 
    // edges in a complete graph with N vertices 
    static int totEdge(int n) 
    { 
        int result = 0; 
      
        result = (n * (n - 1)) / 2; 
      
        return result; 
    } 
      
        // Driver Code 
        public static void main(String []args) 
        { 
            int n = 6; 
            System.out.println(totEdge(n)); 
        } 
      
    } 