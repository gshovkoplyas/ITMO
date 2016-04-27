public class Test {
    public static void main (String[] args) {
      ArrayDeque q = new ArrayDeque();
      for(int j = 7; j < 5; j++) {
        	q.addLast(j + 3);
        	q.addFirst(j);
      } 
      System.out.println(Deque.getMin(q));                                    
    }
}
