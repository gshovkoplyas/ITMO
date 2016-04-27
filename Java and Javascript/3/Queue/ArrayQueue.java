public class ArrayQueue {
	private Object[] elements = new Object[1];
	private int head = 0, tail = 0;

	//post: tail = (tail' + 1) mod elements.length && elements[tail'] = element
	public void push(Object element) {
		int new_index = (tail + 1) % elements.length;
		ensureCapacity(new_index);
		new_index = (tail + 1) % elements.length;
		elements[tail] = element;
		tail = new_index;
	}

	private void ensureCapacity(int new_tail) {
		if (new_tail != head)
			return;
		Object[] new_elements = new Object[2 * elements.length];
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

	public Object pop() {
		assert head != tail;
		int ret_index = head;
		head = (head + 1) % elements.length;
		return elements[ret_index];
	}

	public Object peek() {
		assert head != tail;
		return elements[head];
	}

	public int size() {
		return (tail - head + elements.length) % elements.length;
	}

	public boolean isEmpty() {
		return (head == tail);
	}
}
