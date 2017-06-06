
package map;
import java.util.*;

public class Hashmap 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,Employee> hm=new HashMap<>();
		hm.put(0,new Employee(51645622,25000,"Subbu"));
		hm.put(1,new Employee(51645622,25000,"Subbu"));
		for(Map.Entry<Integer, Employee> m:hm.entrySet())
		{
			Employee e=m.getValue();
			System.out.println("Hello World");
			System.out.println("KEY IS:"+m.getKey()+"\nsapid: "+e.getSapid()+"\nsalary: "+e.getSalary()+"\nName: "+e.getName());
			
	}

}
}
