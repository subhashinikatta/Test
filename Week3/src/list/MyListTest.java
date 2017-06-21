package list;


import static org.junit.Assert.assertTrue;

public class MyListTest {

public static void main(String args[]){
	
       
                MyList<Integer> list = new MyList<Integer>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(3);
                list.add(4);
                assertTrue(4 == list.get(4));
                assertTrue(2 == list.get(1));
                assertTrue(3 == list.get(2));

              list.get(6);
                
                System.out.println(list);
        }
}


