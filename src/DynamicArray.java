import java.util.Iterator;
import java.util.NoSuchElementException;
public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Capacity must be greater than 0" +capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T value){
        arr[index] = value;
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            arr[i] = null;
            len = 0;
        }
    }

    public void add(T value){
        if(len+1 >= capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++)
                new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = value;
    }
    public T removeAt(int index){
        if(index < 0 || index >= len) throw new IndexOutOfBoundsException();
        T data = arr[index];
        arr[index] = null;

    }
}
