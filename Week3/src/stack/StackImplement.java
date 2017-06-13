package stack;


public class StackImplement
{

public static void main(String[] args) throws Exception 
{
	 
	MyStack stack=new MyStack(0);
	Employee e=new Employee();
	e.setId(51645622);
	e.setName("Subhashini");
	e.setCompany("HCL");
	stack.push(e);
	//stack.pop();
	System.out.println("SapId:" +e.getId());
	System.out.println("Salary:" +e.getCompany());
	System.out.println("Name:" +e.getName());

}
}