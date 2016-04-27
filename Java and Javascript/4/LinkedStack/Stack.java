public interface Stack {
	public abstract void push(Object e);

	public Object pop();

	public Object peek();

	public int size();

	public boolean isEmpty();
	// public можно опустить, ничего кроме public все равно писать нельзя
	// abstract тоже опускается(значит, что пофиг как реализовано)
}
