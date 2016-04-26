package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Student_Test {

	private static PersonDomainModel t1;
	private static PersonDomainModel t2;
	private static PersonDomainModel t3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void UpdatePersonTest(){
		PersonDomainModel t;
		String newFirstName = "Bernie";
		PersonDAL.addPerson(t1);
		
		t = PersonDAL.getPerson(t1.getPersonID());
		assertEquals("Barack", t.getFirstName());
		t1.setFirstName(newFirstName);
		
		PersonDAL.updatePerson(t1);
		assertEquals("Noam", t.getFirstName());
		PersonDAL.deletePerson(t1.getPersonID());
	}
	@Test
	public void GetPersonsTest(){
		ArrayList<PersonDomainModel> people = new ArrayList<PersonDomainModel>();
		PersonDAL.addPerson(t1);
		PersonDAL.addPerson(t2);
		people = PersonDAL.getPersons();
		assertTrue(people.size() > 1);
		PersonDAL.deletePerson(t1.getPersonID());
		PersonDAL.deletePerson(t2.getPersonID());
	}
	
	@Test
	public void AddDeletePersonTest()
	{		
		PersonDAL.addPerson(t1);
		assertNull(PersonDAL.getPerson(t1.getPersonID()));
		PersonDAL.deletePerson(t1.getPersonID());
		assertNull(PersonDAL.getPerson(t1.getPersonID()));
	}
	



}
