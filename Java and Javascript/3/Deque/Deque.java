public class Deque {
	// pre: deque.size > 0 & for all obj in deque obj <-> Integer
	// post: result = min{ a | a in deque} & const
	public static int getMin(ArrayDeque deque) {
		int min = (Integer) deque.peekLast();
		for (int i = 0; i < deque.size(); i++) {
			int cur = (Integer) deque.removeFirst();
			if (cur < min) {
			    min = cur;
			}
			deque.addLast(cur);
		}
		return min;
	}
}
