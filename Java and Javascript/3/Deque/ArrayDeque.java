//(elements.length - 1) + 1 <- 0
//0 - 1 <- (elements.length - 1)
//deque <-> [first; last)
//invariant: size >= 0 && last - first == size 
//&& 0 <= last, first < elements.length && for all i >= last & i < first  not in deque elements[i] =  null
public class ArrayDeque {
	private Object[] elements = new Object[1];
	private int first = 0, last = 0, size = 0;
	
	private int next(int ind) {
		return (ind + 1 + elements.length) % elements.length;
	}

	private int prev(int ind) {
		return (ind - 1 + elements.length) % elements.length;
	}

	// post: size = size' + 1
	// & elements[first] = element
	// & elements[i] = elements'[j]
	// {i in [last - size'; last) & j in [last' - size'; last') }
	// & first = last - size
	public void addFirst(Object element) {
		ensureCapacity(size + 1);
		first = prev(first);
		elements[first] = element;
		size++;
	}

	// post: size = size' + 1
	// & elements[first + size'] = element
	// & elements[i] = elements'[j]
	// {i in [first; first + size') & j in [first'; first' + size') }
	// & last = first + size
	public void addLast(Object element) {
		ensureCapacity(size + 1);
		elements[last] = element;
		last = next(last);
		size++;
	}

	// pre: size > 0
	// post: result = elements[first']
	// & size = size' - 1;
	// & last = last'
	// & first = last - size
	// & elements[i] = elements'[j] {i in [first; last) }
	public Object removeFirst() {
		assert size > 0;
		Object result = elements[first];
		elements[first] = null;
		size--;
		first = next(first);
		return result;
	}

	// pre: size > 0
	// post: result = elements[last]
	// & size = size' - 1;
	// & first = first'
	// & last = first + size
	// & elements[i] = elements'[j] {i in [first; last) }
	public Object removeLast() {
		assert size > 0;
		last = prev(last);
		Object result = elements[last];
		elements[last] = null;
		size--;
		return result;
	}

	// pre: size > 0
	// post: const & result = elements[first]
	public Object peekFirst() {
		assert size > 0;
		return elements[first];
	}

	// pre: size > 0
	// post: const & result = elements[last - 1]
	public Object peekLast() {
		assert size > 0;
		int ind = prev(last);
		return elements[ind];
	}

	// post: const & result = size
	public int size() {
		return size;
	}

	// post: const & result = (size == 0)
	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity(int capacity) {
		if (elements.length < capacity) {
			Object[] e = new Object[2 * capacity];
			int i = first, j = 0;
			while (i != last || j == 0) {
				e[j] = elements[i];
				j++;
				i = next(i);
			}
			elements = e;
			first = 0;
			last = j;
		}
	}

}
