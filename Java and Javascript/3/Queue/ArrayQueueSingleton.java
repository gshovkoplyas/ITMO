public class ArrayQueueSingleton {
	private static Object[] elements = new Object[1];
	private static int head = 0, tail = 0, size = 0;
	//inv: size >= 0 && (tail - head + elements.length) mod elements.length == size

	//post: tail = (tail' + 1) mod elements.length && elements[tail'] = element
	public static void push(Object element) {
		ensureCapacity(size + 1);
		int new_index = (tail + 1) % elements.length;
		elements[tail] = element;
		tail = new_index;
		size++;
	}

	private static void ensureCapacity(int capacity) {
		if (capacity < elementh.length)
			return;
		Object[] new_elements = new Object[2 * capacity];
		int i = head, j = 0;
		while (i != tail) {
			new_elements[j] = elements[i];
			i = (i + 1) % elements.length;
			j++;
		}
		elements = new_elements;
		head = 0;
		tail = j;
	}
	
	//pre: size > 0
	//post: head = (head' + 1) mod elements.length && result == elements[head']
	public static Object pop() {
		assert head != tail;
		int ret_index = head;
		head = (head + 1) % elements.length;
		size--;
		return elements[ret_index];
	}

	//pre: size > 0
	//post: result == elements[head]
	public static Object peek() {
		assert head != tail;
		return elements[head];
	}

	//post: result = size
	public static int size() {
		return size;
	}

	//post: result = (size == 0)
	public static boolean isEmpty() {
		return (size == 0);
	}
}
