package stack;


import java.util.Stack;

import list.Employee;


public class StackImplement
{
public static void main(String[] args) 
{
	Stack<Employee> stack=new Stack<Employee>();
	Employee e=new Employee();
	e.setCompany("HCL");
	e.setName("Subhashini");
	e.setId(51645622);
	 stack.push(e); //adding employee details in stack
	 
	 //stack.pop(); //delete employee details in stack 
	 for(Employee e1:stack)
	{
		 System.out.println("Company is "+e.getCompany());
			System.out.println("Name is "+e.getName());
			System.out.println("SapId is "+e.getId());	
		
         }
	 }
}