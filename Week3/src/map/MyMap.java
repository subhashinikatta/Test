package map;

public class MyMap
{
	 private int size = 0;
	    private static final int DEFAULT_CAPACITY = 10;
	    private Object elements[];

	    public MyMap() {
	        elements = new Object[DEFAULT_CAPACITY];
	    }
	  
	public void put(int i, map.Employee e) {
	
		elements[size++] = new Employee();
		
	}
	 public int size() {
         return size;
 }
	 public void remove(int key) {
         for (int i = 0; i < size; i++) {
                         size--;
                         Array(i);
         }
	 }
         private void Array(int start) {
             for (int i = start; i < size; i++) {
            	 elements[i] = elements[i + 1];
             }
     }
 }
	
