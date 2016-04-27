//(elements.length - 1) + 1 <- 0
//0 - 1 <- (elements.length - 1)
//deque <-> [first; last)
//invariant: size >= 0 && last - first == size 
//&& 0 <= last, first < elements.length && for all i >= last & i < first  not in deque elements[i] =  null
public class ArrayDequeADT {
	private Object[] elements = new Object[1];
	private int first = 0, last = 0, size = 0;

	private static int next(ArrayDequeADT d, int ind) {
		return (ind + 1 + d.elements.length) % d.elements.length;
	}

	private static int prev(ArrayDequeADT d, int ind) {
		return (ind - 1 + d.elements.length) % d.elements.length;
	}

	// post: size = size' + 1
	// & elements[first] = element
	// & elements[i] = elements'[j]
	// {i in [last - size'; last) & j in [last' - size'; last') }
	// & first = last - size
	public static void addFirst(ArrayDequeADT d, Object element) {
		ensureCapacity(d, d.size + 1);
		d.first = prev(d, d.first);
		d.elements[d.first] = element;
		d.size++;
	}

	// post: size = size' + 1
	// & elements[first + size'] = element
	// & elements[i] = elements'[j]
	// {i in [first; first + size') & j in [first'; first' + size') }
	// & last = first + size
	public static void addLast(ArrayDequeADT d, Object element) {
		ensureCapacity(d, d.size + 1);
		d.elements[d.last] = element;
		d.last = next(d, d.last);
		d.size++;
	}

	// pre: size > 0
	// post: result = elements[first']
	// & size = size' - 1;
	// & last = last'
	// & first = last - size
	// & elements[i] = elements'[j] {i in [first; last) }
	public static Object removeFirst(ArrayDequeADT d) {
		assert d.size > 0;
		Object result = d.elements[d.first];
		d.elements[d.first] = null;
		d.size--;
		d.first = next(d, d.first);
		return result;
	}

	// pre: size > 0
	// post: result = elements[last]
	// & size = size' - 1;
	// & first = first'
	// & last = first + size
	// & elements[i] = elements'[j] {i in [first; last) }
	public static Object removeLast(ArrayDequeADT d) {
		assert d.size > 0;
		d.last = prev(d, d.last);
		Object result = d.elements[d.last];
		d.elements[d.last] = null;
		d.size--;
		return result;
	}

	// pre: size > 0
	// post: const & result = elements[first]
	public static Object peekFirst(ArrayDequeADT d) {
		assert d.size > 0;
		return d.elements[d.first];
	}

	// pre: size > 0
	// post: const & result = elements[last - 1]
	public static Object peekLast(ArrayDequeADT d) {
		assert d.size > 0;
		int ind = prev(d, d.last);
		return d.elements[ind];
	}

	// post: const & result = size
	public static int size(ArrayDequeADT d) {
		return d.size;
	}

	// post: const & result = (size == 0)
	public static boolean isEmpty(ArrayDequeADT d) {
		return d.size == 0;
	}

	private static void ensureCapacity(ArrayDequeADT d, int capacity) {
		if (d.elements.length < capacity) {
			Object[] e = new Object[2 * capacity];
			int i = d.first, j = 0;
			while (i != d.last || j == 0) {
				e[j] = d.elements[i];
				j++;
				i = next(d, i);
			}
			d.elements = e;
			d.first = 0;
			d.last = j;
		}
	}

}
