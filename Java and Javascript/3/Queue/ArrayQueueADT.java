public class ArrayQueueADT {
	private Object[] elements = new Object[1];
	private int head = 0, tail = 0;

	//post: tail = (tail' + 1) mod elements.length && elements[tail'] = element
	public static void push(ArrayQueueADT q, Object element) {
		int new_index = (q.tail + 1) % q.elements.length;
		ensureCapacity(q, new_index);
		new_index = (q.tail + 1) % q.elements.length;
		q.elements[q.tail] = element;
		q.tail = new_index;
	}

	private static void ensureCapacity(ArrayQueueADT q, int new_tail) {
		if (new_tail != q.head)
			return;
		Object[] new_elements = new Object[2 * q.elements.length];
		int i = q.head, j = 0;
		while (i != q.tail) {
			new_elements[j] = q.elements[i];
			i = (i + 1) % q.elements.length;
			j++;
		}
		q.elements = new_elements;
		q.head = 0;
		q.tail = j;
	}

	public static Object pop(ArrayQueueADT q) {
		assert q.head != q.tail;
		int ret_index = q.head;
		q.head = (q.head + 1) % q.elements.length;
		return q.elements[ret_index];
	}

	public static Object peek(ArrayQueueADT q) {
		assert q.head != q.tail;
		return q.elements[q.head];
	}

	public static int size(ArrayQueueADT q) {
		return (q.tail - q.head + q.elements.length) % q.elements.length;
	}

	public static boolean isEmpty(ArrayQueueADT q) {
		return (q.head == q.tail);
	}
}
