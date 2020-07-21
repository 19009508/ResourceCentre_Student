import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {//anson
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {//anson
		
		// write your code here
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void retrieveAllCamcorderTest() {//ISHWARYA
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {//ISHWARYA
		
		// write your code here
		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Chromebooks arraylist to add to", chromebookList);
				
				//test if the list of chromebooks retrieved from the SourceCentre is empty
				String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
				String testOutput = "";
				assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				ResourceCentre.addChromebook(chromebookList, cb1);
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());
				
				//test if the expected output string same as the list of chromebooks retrieved from the SourceCentre
				allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

				testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
				testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			
				assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {//WQ
		
		// write your code here
		// Test if the list is populated so that an item can be loan
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
		//Test if an item in the list can be loan
		camcorderList.add(cc2);
        assertEquals("Test if the first item is available", true, camcorderList.get(0).getIsAvailable());
        camcorderList.get(0).setIsAvailable(false);
       
        //Test if the ArrayList is updated to reflect the loan
        assertEquals("Test if in the ArrayList the first item has been loaned", false, camcorderList.get(0).getIsAvailable());
		
      //Test if the asset tag are to be check for absence
      	camcorderList.add(cc1);
      	String tag = cc1.getAssetTag();
      	String dueDate = "01012010";
      	assertTrue(ResourceCentre.doLoanCamcorder(camcorderList, tag, dueDate));
        
	}
	
	@Test
	public void doLoanChromebookTest() {//WQ
		
		// write your code here
		// Test if the list is populated so that an item can be loan
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
		//test if the list of chromebooks retrieved from the SourceCentre is empty
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
		
		//Test if an item in the list can be loan
		chromebookList.add(cb2);
        assertEquals("Test if the first item is available", true, chromebookList.get(0).getIsAvailable());
        chromebookList.get(0).setIsAvailable(false);
       
        //Test if the ArrayList is updated to reflect the loan
        assertEquals("Test if in the ArrayList the first item has been loaned", false, chromebookList.get(0).getIsAvailable());
		
      //Test if the asset tag are to be check for absence	
      	chromebookList.add(cb1);
      	String tag = cb1.getAssetTag();
      	String dueDate = "01012010";
      	assertTrue(ResourceCentre.doLoanChromebook(chromebookList, tag, dueDate));
        
	}
	
	@Test
	public void doReturnCamcorderTest() {//WQ
		
		// write your code here
		//Test if the list is populated so that an item can be return
        assertNotNull("Test if list is available", camcorderList);
       
        //Test if an item in the list can be return
        camcorderList.add(cc1);
        ResourceCentre.doLoanCamcorder(camcorderList, cc1.getAssetTag(), "2020-05-29");
        assertEquals("Test if the first item isn't available", false, camcorderList.get(0).getIsAvailable());
        camcorderList.get(0).setIsAvailable(true);
       
        //Test if the ArrayList is updated to reflect the return
        assertEquals("Test if in the ArrayList the first item has been returned", true, camcorderList.get(0).getIsAvailable());
		
	}
	@Test
	public void doReturnChromebookTest() {//WQ
		
		// write your code here
		//Test if the list is populated so that an item can be return
        assertNotNull("Test if list is available", chromebookList);
       
        //Test if an item in the list can be return
        chromebookList.add(cb1);
        ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), "2020-05-29");
        assertEquals("Test if the first item isn't available", false, chromebookList.get(0).getIsAvailable());
        chromebookList.get(0).setIsAvailable(true);
       
        //Test if the ArrayList is updated to reflect the return
        assertEquals("Test if in the ArrayList the first item has been returned", true, chromebookList.get(0).getIsAvailable());
               
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
