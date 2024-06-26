package information;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyFileReaderTest {
	
	MyFileReader myFileReader1;  
	MyFileReader myFileReader2;  
	MyFileReader myFileReader3;  
	MyFileReader myFileReader4; 
	MyFileReader myFileReader5;  
	
	
	@BeforeEach
	void setUp () {
		this.myFileReader1 = new MyFileReader("info.txt");   // original info.txt file
		this.myFileReader2 = new MyFileReader("test2.txt");  // file with multiple words per line
		this.myFileReader3 = new MyFileReader("test3.txt");  // similar to info.txt file but with leading and trailing whitespace
		this.myFileReader4 = new MyFileReader("test4.txt");  // similar to info.txt file but with different info
		this.myFileReader5 = new MyFileReader("test5.txt");  // similar to info.txt file but with blank lines in between lines with information
	}
	
	@Test
	public void testGetCleanContent() {
		ArrayList<String> actual = myFileReader1.getCleanContent();
		ArrayList<String> expected = new ArrayList<String>();
		
		// test original info.txt file
		expected.add("Course:");
		expected.add("MCIT_590");
		expected.add("CourseID:");
		expected.add("590");
		expected.add("StudentID:");
		expected.add("101");
		assertEquals(expected, actual);

		// test info.txt file with leading and trailing whitespace
		actual = myFileReader3.getCleanContent();
		assertEquals(expected, actual);
		
		// test file with multiple words per line
		actual = myFileReader2.getCleanContent();
		expected.removeAll(expected);
		expected.add("hello world");
		expected.add("Course Name and ID");
		expected.add("The quick brown fox jumps over the lazy dog.");
		assertEquals(expected, actual);
		

		// TODO write at least 2 additional test cases using different new MyFileReaders
		ArrayList<String> actual2 = myFileReader4.getCleanContent();
		ArrayList<String> expected2 = new ArrayList<String>();
		
		expected2.add("Course:");
		expected2.add("MCIT_594");
		expected2.add("CourseID:");
		expected2.add("594");
		expected2.add("StudentID:");
		expected2.add("8598");
		assertEquals(expected2, actual2);
		
		ArrayList<String> actual3 = myFileReader5.getCleanContent();
		ArrayList<String> expected3 = new ArrayList<String>();
		expected3.add("Course:");
		expected3.add("MCIT_590");
		expected3.add("CourseID:");
		expected3.add("590");
		expected3.add("StudentID:");
		expected3.add("101");
		assertEquals(expected3, actual3);

	}

}