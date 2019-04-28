/**
 * 
 */
package jw.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jennifer
 *
 */
public class PersonDataTest {

	PersonData p1 ;
	PersonData p2 ;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 p1 = new PersonData();
		 p2 = new PersonData();
		
	}
	
	/**
	 * Test method for {@link jw.pojo.PersonData#equals(java.lang.Object)}.
	 * test email is different
	 */
	@Test
	public final void testEqualsPhone() {
		
		p1.setLast_name("wang");
		p1.setFirst_name("jennifer");
		p1.setEmail("test@test.com");
		p1.setPhone("781-111-1234");
		
		p2.setLast_name("Wang");
		p2.setFirst_name("Jenn");
		p2.setEmail("test@test2.com");
		p2.setPhone("781-111-1234");
		
		assertTrue(p1.equals(p2));
	}
	
	/**
	 * Test method for {@link jw.pojo.PersonData#equals(java.lang.Object)}.
	 * test phone is different
	 */
	@Test
	public final void testEqualsEmail() {
		
		p1.setLast_name("wang");
		p1.setFirst_name("jennifer");
		p1.setEmail("test@test.com");
		p1.setPhone("781-111-1234");
		
		p2.setLast_name("Wang");
		p2.setFirst_name("Jenn");
		p2.setEmail("test@test.com");
		p2.setPhone("781-222-1234");
		
		assertTrue(p1.equals(p2));
	}

}
