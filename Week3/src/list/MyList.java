package list;


public class MyList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

   public void add(Employee e) {
       
       elements[size++] = e;
    }

    }
