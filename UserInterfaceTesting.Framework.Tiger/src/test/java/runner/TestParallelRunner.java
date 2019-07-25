package runner;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import tests.Sprint1Tests;
import tests.Sprint2Tests;
import tests.Sprint3Tests;
import tests.Sprint4Tests;
import tests.Sprint5Tests;

public class TestParallelRunner 
{
	public static void main(String[] args) 
	{
		Class[] cls= 
			{
				Sprint1Tests.class, 
				Sprint2Tests.class, 
				Sprint3Tests.class, 
				Sprint4Tests.class, 
				Sprint5Tests.class
			};  

        //simultaneously among classes  
        Result result = JUnitCore.runClasses(ParallelComputer.classes(), cls);
        System.out.print(result.wasSuccessful());
	}
}