public class Test {
    public static void main (String[] args) {
      ArrayQueueADT q = new ArrayQueueADT();
      for(int j = 0; j < 10; j++){
        ArrayQueueADT.push(q, j + 3);
      
        }                                          
        while (!ArrayQueueADT.isEmpty(q)) {
      	System.out.println(
	    	ArrayQueueADT.size(q) + " " +
        	ArrayQueueADT.peek(q) + " " +
       		ArrayQueueADT.pop(q)
    	);
	}
    }
}
