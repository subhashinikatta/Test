package com;
public class Test 
{
	int a, b;
	 Test(int i, int j)

    {
                    a = i;

                    b = j;
    }
 void swap(Test object)

    {
                    int c;

                    c=object.a;

                    object.a=object.b;

                    object.b=c;                  

    }
}