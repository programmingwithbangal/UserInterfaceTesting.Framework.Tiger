package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.Sprint1Tests;
import tests.Sprint2Tests;
import tests.Sprint3Tests;
import tests.Sprint4Tests;
import tests.Sprint5Tests;

@RunWith(Suite.class)
@Suite.SuiteClasses({Sprint1Tests.class, Sprint2Tests.class, Sprint3Tests.class, Sprint4Tests.class, Sprint5Tests.class})
public class Runner 
{	
}
