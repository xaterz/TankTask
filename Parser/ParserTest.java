package main.java.backend.Parser;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

/**
 * ParserTest
 * Contains the test cases for Parser component
 * @@author A0121795B
 */
public class ParserTest {
	public main.java.backend.Parser.Parser parser = new main.java.backend.Parser.Parser();
	String input;
	public ArrayList<String> actual; 
	public ArrayList<String> expected;
	private void printTest() {
		System.out.println("Input:    " + input);
	    System.out.println("Expected: " + expected.toString());
	    System.out.println("Actual:   " + actual.toString());
	}
	private void executeTest(String input) {
		actual = parser.parseInput(input);
		printTest();
	    assertEquals(expected, actual);
	}
	private String getTodayDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("EEE, dd MMM");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
		return strDate;
	}
	private String getTmrDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("EEE, dd MMM");
	    Date now = new Date();
	    long milliNow = now.getTime();
	    long milliTmr = milliNow += (1000 * 60 * 60 * 24);
	    String strDate = sdfDate.format(milliTmr);
		return strDate;
	}
	@Test
	/**
	 * Test whether basic commands with valid inputs work
	 */
	public void BasicTests() {
		System.out.println("\n-----------------Result for BasicTests-----------------");
	    input = "exit";
	    expected = new ArrayList<String>( Arrays.asList("exit") );
	    executeTest(input);

	    input = "redo";
	    expected = new ArrayList<String>( Arrays.asList("redo") );
	    executeTest(input);

	    input = "deleteall";
	    expected = new ArrayList<String>( Arrays.asList("deleteAll") );
	    executeTest(input);

		input = "add Project Proposal";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("addF", "Project Proposal", "", "", "", "") );
	    executeTest(input);

	    input = "1 deadline 30 December 23:59";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

	    input = "1 priority 5";
	    expected = new ArrayList<String>( Arrays.asList("priority", "1", "5") );
	    executeTest(input);

	    input = "1 description i need to start doing this!";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "i need to start doing this!") );
	    executeTest(input);

	    input = "ADD PROJECT PROPOSAL";
	    expected = new ArrayList<String>( Arrays.asList("addF", "PROJECT PROPOSAL", "", "", "", "") );
	    executeTest(input);

	    input = "1     deadline     30  December     23:59";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

	    input = "1 by 12 Feb 3pm";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Fri, 12 Feb 16, 3pm") );
	    executeTest(input);

	    input = "1 BY 12 Feb 3pm";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Fri, 12 Feb 16, 3pm") );
	    executeTest(input);

	    input = "3 from 4 Apr 4pm to 5 May 5:30pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "3", "Mon, 04 Apr 16, 4pm", "Thu, 05 May 16, 5:30pm") );
	    executeTest(input);

	    input = "4 rename new task name";
	    expected = new ArrayList<String>( Arrays.asList("rename", "4", "new task name") );
	    executeTest(input);

	    input = "showF";
	    expected = new ArrayList<String>( Arrays.asList("showF") );
	    executeTest(input);

	    input = "showO";
	    expected = new ArrayList<String>( Arrays.asList("showO") );
	    executeTest(input);

	    input = "show floating";
	    expected = new ArrayList<String>( Arrays.asList("showF") );
	    executeTest(input);

	    input = "show todo";
	    expected = new ArrayList<String>( Arrays.asList("showT") );
	    executeTest(input);
	    
	    input = "show events";
	    expected = new ArrayList<String>( Arrays.asList("showE") );
	    executeTest(input);

	    input = "show today";
	    expected = new ArrayList<String>( Arrays.asList("showD") );
	    executeTest(input);

	    input = "show O";
	    expected = new ArrayList<String>( Arrays.asList("showO") );
	    executeTest(input);
	    
	    input = "show d";
	    expected = new ArrayList<String>( Arrays.asList("showD") );
	    executeTest(input);

	    input = "show done";
	    expected = new ArrayList<String>( Arrays.asList("showC") );
	    executeTest(input);

	    input = "show completed";
	    expected = new ArrayList<String>( Arrays.asList("showC") );
	    executeTest(input);

	    input = "SHOW COMPLETED";
	    expected = new ArrayList<String>( Arrays.asList("showC") );
	    executeTest(input);

	    input = "sortp";
	    expected = new ArrayList<String>( Arrays.asList("sortP") );
	    executeTest(input);

	    input = "sort date";
	    expected = new ArrayList<String>( Arrays.asList("sortD") );
	    executeTest(input);

	    input = "sort deadline";
	    expected = new ArrayList<String>( Arrays.asList("sortD") );
	    executeTest(input);

	    input = "sort pri";
	    expected = new ArrayList<String>( Arrays.asList("sortP") );
	    executeTest(input);

	    input = "sort name";
	    expected = new ArrayList<String>( Arrays.asList("sortN") );
	    executeTest(input);

	    input = "sort by priority";
	    expected = new ArrayList<String>( Arrays.asList("sortP") );
	    executeTest(input);

	    input = "sort N";
	    expected = new ArrayList<String>( Arrays.asList("sortN") );
	    executeTest(input);
	    
	    input = "sort d";
	    expected = new ArrayList<String>( Arrays.asList("sortD") );
	    executeTest(input);
	    
	    input = "sort P";
	    expected = new ArrayList<String>( Arrays.asList("sortP") );
	    executeTest(input);

	    input = "search meeting with boss";
	    expected = new ArrayList<String>( Arrays.asList("search", "meeting with boss") );
	    executeTest(input);

	    input = "filepath Desktop/TankTask/";
	    expected = new ArrayList<String>( Arrays.asList("filepath", "Desktop/TankTask/") );
	    executeTest(input);

	    input = "fp Desktop/TankTask/";
	    expected = new ArrayList<String>( Arrays.asList("filepath", "Desktop/TankTask/") );
	    executeTest(input);

	}
	@Test
	/**
	 * Test whether dominating commands work properly
	 */
	public void DominatingCommands() {
		System.out.println("\n-----------------Result for DominatingCommands-----------------");
		//should ignore the extra words
	    input = "exit extra extra extra words";
	    expected = new ArrayList<String>( Arrays.asList("exit") );
	    executeTest(input);

	    //either format for done/delete should work
	    input = "done 1";
	    expected = new ArrayList<String>( Arrays.asList("done", "1") );
	    executeTest(input);

	    input = "1 done";
	    expected = new ArrayList<String>( Arrays.asList("done", "1") );
	    executeTest(input);

	    //dominating commands should be ignored when 'add' is in effect
	    input = "Add Project Proposal done delete";
	    expected = new ArrayList<String>( Arrays.asList("addF", "Project Proposal done delete", "", "", "", "") );
	    executeTest(input);

	    input = "add Project Proposal search";
	    expected = new ArrayList<String>( Arrays.asList("addF", "Project Proposal search", "", "", "", "") );
	    executeTest(input);

	    //all other commands should be ignored when 'search' is in effect
	    input = "search Project Proposal description bla bla every week";
	    expected = new ArrayList<String>( Arrays.asList("search", "Project Proposal description bla bla every week") );
	    executeTest(input);

	    //'addcat' should be ignored when 'add' is in effect
	    input = "add Project Proposal addcat priority 5";
	    expected = new ArrayList<String>( Arrays.asList("addF", "Project Proposal addcat", "", "5",
	    												"", "") );
	    executeTest(input);

	    //all dominating commands and no-content commands should be ignored when 'add' is in effect
	    input = "add addcat delete search reset sortp exit showf";
	    expected = new ArrayList<String>( Arrays.asList("addF", "addcat delete search reset sortp exit showf", "", "", "", "") );
	    executeTest(input);

	    //delete/done should ignore extra words
	    input = "delete 1 aaaaaaaaaa";
	    expected = new ArrayList<String>( Arrays.asList("delete", "1") );
	    executeTest(input);

	    //Test whether reset works properly
	    input = "1 reset all";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "all") );
	    executeTest(input);

	    input = "1 reset deadline";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "date") );
	    executeTest(input);

	    input = "1 reset event";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "date") );
	    executeTest(input);

	    input = "1 reset DATE";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "date") );
	    executeTest(input);

	    input = "1 reset priority";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "priority") );
	    executeTest(input);

	    input = "1 reset pri";
	    expected = new ArrayList<String>( Arrays.asList("reset", "1", "priority") );
	    executeTest(input);

	    //If last word is a commad keyword and 'add' is in effect, the last command keyword is taken as part of task name
	    input = "add bla deadline";
	    expected = new ArrayList<String>( Arrays.asList("addF", "bla deadline", "", "", "", "") );
	    executeTest(input);

	    input = "1 des bla bla deadline";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "bla bla deadline") );
	    executeTest(input);

	}
	@Test
	/**
	 * Test whether one-shot commands work properly
	 */
	public void OneShotCommand() {
		System.out.println("\n-----------------Result for OneShotCommand-----------------");
		//Check that you can add floatings with one-shot commands
		input = "add Project Proposal priority 5";
	    expected = new ArrayList<String>( Arrays.asList("addF", "Project Proposal", "", "5", "", "") );
	    executeTest(input);

	    input = "add User Guide reminder 20 December 12:00 description i will do this in 10 days priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addF", "User Guide", "i will do this in 10 days", "3", 
	    												"Sun, 20 Dec 15, 12pm", "") );
	    executeTest(input);

	    //Check that you can add to-dos with one-shot commands
	    input = "add Project Proposal deadline 30 December 23:59";
	    expected = new ArrayList<String>( Arrays.asList("addT", "Project Proposal", "", "Wed, 30 Dec 15, 11:59pm", "", "", "") );
	    executeTest(input);

	    input = "add Project Proposal deadline 30 December 23:59 priority 5 description i need to start doing this!";
	    expected = new ArrayList<String>( Arrays.asList("addT", "Project Proposal", "i need to start doing this!",  
	    								  "Wed, 30 Dec 15, 11:59pm", "5", "", "") );
	    executeTest(input);
  
	    //Check that you can add events with one-shot commands
	    input = "add OP2 event 29 Dec 2pm to 3pm";
	    expected = new ArrayList<String>( Arrays.asList("addE", "OP2", "", "Tue, 29 Dec 15, 2pm", "Tue, 29 Dec 15, 3pm", "", "", "") );
	    executeTest(input);

	    //Check that you can set multiple fields for existing tasks 
	    input = "1 description i must finish this early reminder 25 Dec 21:00";
	    expected = new ArrayList<String>( Arrays.asList("set", "1", "i must finish this early", "", 
	    												"Fri, 25 Dec 15, 9pm", "", "") );
	    executeTest(input);

	    input = "2 priority 4 deadline 5 October 20:00 every day ";
	    expected = new ArrayList<String>( Arrays.asList("setT", "2", "", "Wed, 05 Oct 16, 8pm",
	    												"4", "", "1 day", "") );
	    executeTest(input);

	    input = "2 priority 4 every day";
	    expected = new ArrayList<String>( Arrays.asList("set", "2", "", "4", "", "1 day", "") );
	    executeTest(input);

	    input = "3 deadline 19 Nov 3pm every 6 months";
	    expected = new ArrayList<String>( Arrays.asList("setT", "3", "", "Thu, 19 Nov 15, 3pm", 
													"", "", "6 month", "") );
	    executeTest(input);

	    //Check that command shortforms also work for one-shot commands
	    input = "1 des hello dea 11 Jan 2pm rem 5 Jan 2pm pri 2";
	    expected = new ArrayList<String>( Arrays.asList("setT", "1", "hello", "Mon, 11 Jan 16, 2pm", "2", "Tue, 05 Jan 16, 2pm", "", "") );
	    executeTest(input);

	    input = "1 des hello rename bla bla pri 2";
	    expected = new ArrayList<String>( Arrays.asList("set", "1", "hello", "2", "", "", "bla bla") );
	    executeTest(input);

	    //Test recurring in one-shot command
	    input = "add daily task from 20 dec 2pm to 4pm every day";
	    expected = new ArrayList<String>( Arrays.asList("addE", "daily task", "", "Sun, 20 Dec 15, 2pm", "Sun, 20 Dec 15, 4pm", "", "", "1 day") );
	    executeTest(input);

	    input = "add weekly task by friday 5pm every week";
	    expected = new ArrayList<String>( Arrays.asList("addT", "weekly task", "", "Fri, 06 Nov 15, 5pm", "Sun, 20 Dec 15, 4pm", "", "", "1 week") );
	    printTest();
	    input = "add monthly task from 30 dec every 2 months";
	    expected = new ArrayList<String>( Arrays.asList("addE", "monthly task", "", "Wed, 30 Dec 15, 9am", "Wed, 30 Dec 15, 9pm", "", "", "2 month") );
	    executeTest(input);

	}
	@Test
	/**
	 * Test whether parser can ignore Duplicate commands in certain scenarios
	 */
	public void DuplicateCommands() {
		System.out.println("\n-----------------Result for DuplicateCommands-----------------");
		//Test whether Duplicate 'add' is considered as part of task name
	    input = "add add";
	    expected = new ArrayList<String>( Arrays.asList("addF", "add", "", "", "", "") );
	    executeTest(input);

	    input = "add add food to the fridge priority 2";
	    expected = new ArrayList<String>( Arrays.asList("addF", "add food to the fridge", "", "2", "", "") );
	    executeTest(input);

	    //Test whether Duplicate 'description' is considered as part of description
	    input = "1 description hello this is a description";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "hello this is a description") );
	    executeTest(input);

	    input = "1 description hello this is a description priority 3";
	    expected = new ArrayList<String>( Arrays.asList("set", "1", "hello this is a description", "3", "", "", "") );
	    executeTest(input);

	    //Test whether other Duplicate commands are considered as part of description (when description is in effect)
	    input = "1 deadline 15 dec 10pm every day des i do this every day";
	    expected = new ArrayList<String>( Arrays.asList("setT", "1", "i do this every day", "Tue, 15 Dec 15, 10pm", "", "", "1 day", "") );
	    executeTest(input);

	    //Test whether command keywords inside quotations will be ignored
	    input = "1 des buy from every pet shop";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'event'") );
	    executeTest(input);

	    input = "1 des \"buy cat from pet shop\"";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "buy cat from pet shop") );
	    executeTest(input);

	    input = "add \"buy new cat\" des \"buy cat from pet shop\"";
	    expected = new ArrayList<String>( Arrays.asList("addF", "buy new cat", "buy cat from pet shop", "", "", "") );
	    executeTest(input);

	    input = "add \"buy new cat\" pri 3 rem 21 Jul 7pm des \"buy cat from pet shop\"";
	    expected = new ArrayList<String>( Arrays.asList("addF", "buy new cat", "buy cat from pet shop", "3", "Thu, 21 Jul 16, 7pm", "") );
	    executeTest(input);

	    input = "add \"buy new cat\" rem 21 Jul 7pm des \"buy cat from pet shop\" pri 3";
	    expected = new ArrayList<String>( Arrays.asList("addF", "buy new cat", "buy cat from pet shop", "3", "Thu, 21 Jul 16, 7pm", "") );
	    executeTest(input);

	    input = "1 des \"buy new pet";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "\"buy new pet") );
	    executeTest(input);

	    input = "1 des \"buy\"";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "buy") );
	    executeTest(input);

	    input = "1 des \"buy cat\" pet";
	    expected = new ArrayList<String>( Arrays.asList("description", "1", "\"buy cat\" pet") );
	    executeTest(input);

	    //Ignore duplicate when user types 'recur every'
	    input = "2 recur week";
	    expected = new ArrayList<String>( Arrays.asList("every", "2", "1 week") );
	    executeTest(input);

	    input = "2 recur every week";
	    expected = new ArrayList<String>( Arrays.asList("every", "2", "1 week") );
	    executeTest(input);

	    input = "2 recurring every 3 weeks";
	    expected = new ArrayList<String>( Arrays.asList("every", "2", "3 week") );
	    executeTest(input);

	}
	@Test
	/**
	 * Test whether date and time are being formatted correctly
	 */
	public void DateAndTime(){
		System.out.println("\n-----------------Result for DateAndTime-----------------");
		//Testing different deadline formats for the same date and time
		input = "1 deadline 30/12/15 23:59";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30-12-15 23.59";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30/12 11:59pm";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30/12 23:59";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30 Dec 23:59";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30 Dec 8:07pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 8:07pm") );
	    executeTest(input);

	    //Test whether time without minutes work
		input = "1 deadline 30-12 11pm";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11pm") );
	    executeTest(input);

	    //Test whether a full date and time works
		input = "1 deadline 12/3/2016 04:56";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Sat, 12 Mar 16, 4:56am") );
	    executeTest(input);

	    //Test whether deadline without time is given the default time 11:59pm
		input = "1 deadline 30/12";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline 30 Dec";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

		input = "1 deadline December 30";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 11:59pm") );
	    executeTest(input);

	    //The result of these tests depend on whether the current time is before or after the stated deadline
		/*input = "1 deadline 2:30pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", dateTmr + " 14:30:00 " + yearNow) );
	    printTest();
		input = "1 deadline 20:00";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", dateNow + " 20:00:00 " + yearNow) );
	    printTest();*/
	    //Testing if zeroes are removed correctly from time
		input = "1 deadline 30 Dec 8pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 8pm") );
	    executeTest(input);

		input = "1 deadline 30 Dec 8:07pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 8:07pm") );
	    executeTest(input);

		input = "1 deadline 30 Dec 8:10pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 8:10pm") );
	    executeTest(input);

	    //Testing for event with both start and end date/time
	    input = "3 event 15/09 10:00 to 17/09 09:59";
	    expected = new ArrayList<String>( Arrays.asList("event", "3", "Thu, 15 Sep 16, 10am", 
	    "Sat, 17 Sep 16, 9:59am") );
	    executeTest(input);

	    input = "4 event 15/09 10AM to 16/09 11AM";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 11am") );
	    executeTest(input);

	    //Testing for event with end date but not time (should set the end time to be same as start time)
	    input = "4 event 15/09 10am to 16/09";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 9pm") );
	    executeTest(input);

	    input = "4 event 15 Sep 10am to 16 Sep";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 9pm") );
	    executeTest(input);

	    input = "4 event 15 September 10am to 16 September";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 9pm") );
	    executeTest(input);

	    //Testing for when end date is before start date (should set it to one day or one year later)
	    input = "4 event 15 Sep 10am to 14 Sep";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Thu, 14 Sep 17, 9pm") );
	    executeTest(input);

	    input = "4 event 15 Sep 10:30am to 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10:30am", "Fri, 16 Sep 16, 10am") );
	    executeTest(input);

	    input = "4 event 15 Sep 10:30am to 10:10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10:30am", "Fri, 16 Sep 16, 10:10am") );
	    executeTest(input);

	    input = "4 event 15 Sep 10am to 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 10am") );
	    executeTest(input);

	    input = "2 event 15 Sep 2pm to 15 Sep 1pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 15 Sep 16, 2pm", "Fri, 15 Sep 17, 1pm") );
	    executeTest(input);

	    //Testing for event with end time but not date (should set end date to be the same day or the next day depending on time)
	    input = "4 event 15/09 10am to 2pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Thu, 15 Sep 16, 2pm") );
	    executeTest(input);

	    input = "4 event 15/09 10am to 8am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 8am") );
	    executeTest(input);

	    input = "4 event 15/09 2am to 4am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 2am", "Thu, 15 Sep 16, 4am") );
	    executeTest(input);

	    input = "4 event 15/09 12pm to 12pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 12pm", "Fri, 16 Sep 16, 12pm") );
	    executeTest(input);

	    input = "4 event 15 Sep 10:30am to 10:45am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10:30am", "Thu, 15 Sep 16, 10:45am") );
	    executeTest(input);

	    input = "4 event 15/09 11:55PM to 11:59PM";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 11:55pm", "Thu, 15 Sep 16, 11:59pm") );
	    executeTest(input);

	    //Testing for event with no end date/time (should set end date to be same as start date, time to be 11:59pm)
	    input = "2 event 15/09 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 15 Sep 16, 10am", "Thu, 15 Sep 16, 9pm") );
	    executeTest(input);

	    input = "2 event 15 Sep 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 15 Sep 16, 10am", "Thu, 15 Sep 16, 9pm") );
	    executeTest(input);

	    //Testing for event with no start or end time (set both to 9am)
	    input = "2 event 15 Sep to 16 Sep";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 15 Sep 16, 9am", "Fri, 16 Sep 16, 9pm") );
	    executeTest(input);

	    //Testing reminder with no time
	    input = "2 reminder 20 dec";
	    expected = new ArrayList<String>( Arrays.asList("reminder", "2", "Sun, 20 Dec 15, 9am") );
	    executeTest(input);
	    
	    //Testing for when time was entered before date
		input = "1 deadline 3pm 30 Dec";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Wed, 30 Dec 15, 3pm") );
	    executeTest(input);

	    input = "4 event 10am 15/09 to 16/09";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 9pm") );
	    executeTest(input);

	    input = "4 event 10am 15 Sep to 14 Sep";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Thu, 14 Sep 17, 9pm") );
	    executeTest(input);

	    input = "4 event 10:30am 15 Sep to 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10:30am", "Fri, 16 Sep 16, 10am") );
	    executeTest(input);

	    input = "4 event 10am 15/09 to 8am";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Thu, 15 Sep 16, 10am", "Fri, 16 Sep 16, 8am") );
	    executeTest(input);

	    input = "2 event 10am 15/09";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 15 Sep 16, 10am", "Thu, 15 Sep 16, 9pm") );
	    executeTest(input);

	    //Testing event in one-shot commands (some with year specified, some without)
	    input = "2 description i must reach there early event 30/12 11am to 3pm reminder 29/12/15 12:00";
	    expected = new ArrayList<String>( Arrays.asList("setE", "2", "i must reach there early", 
	    "Wed, 30 Dec 15, 11am", "Wed, 30 Dec 15, 3pm", "", "Tue, 29 Dec 15, 12pm", "", "") );
	    executeTest(input);

	    input = "add 2101 meeting event 12/12/15 12:00 to 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "2101 meeting", "", "Sat, 12 Dec 15, 12pm", 
	    "Sat, 12 Dec 15, 6pm", "3", "", "") );
	    executeTest(input);

	    input = "add 2101 meeting event Dec 12 12:00 to 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "2101 meeting", "", "Sat, 12 Dec 15, 12pm", 
	    "Sat, 12 Dec 15, 6pm", "3", "", "") );
	    executeTest(input);

	    input = "add 2101 meeting event 12 Dec 2015 12:00 to 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "2101 meeting", "", "Sat, 12 Dec 15, 12pm", 
	    										"Sat, 12 Dec 15, 6pm", "3", "", "") );
	    executeTest(input);

	    input = "add 2101 meeting event Dec 12 12:00 to 12 Dec 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "2101 meeting", "", "Sat, 12 Dec 15, 12pm", 
	    										"Sat, 12 Dec 15, 6pm", "3", "", "") );
	    executeTest(input);

	    input = "add longest meeting ever event Dec 12 2015 12:00 to Dec 12 2016 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "longest meeting ever", "", "Sat, 12 Dec 15, 12pm", 
	    										"Mon, 12 Dec 16, 6pm", "3", "", "") );
	    executeTest(input);

	    input = "add longest meeting ever event 12/12/15 12:00 to 12/12/16 18:00 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("addE", "longest meeting ever", "", "Sat, 12 Dec 15, 12pm", 
	    										"Mon, 12 Dec 16, 6pm", "3", "", "") );
	    executeTest(input);

	    //Test whether parser will change an old year to the current year
	    input = "2 by 31 Dec 1995 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Thu, 31 Dec 15, 10am") );
	    executeTest(input);

		input = "1 deadline 12/3/2014 9pm";
		actual = parser.parseInput(input);
	    expected = new ArrayList<String>( Arrays.asList("deadline", "1", "Sat, 12 Mar 16, 9pm") );
	    executeTest(input);

	    //Test when year is not specified, whether parser can set the date to always be the nearest one in the future
	    input = "2 event 31 Dec 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Thu, 31 Dec 15, 10am", "Thu, 31 Dec 15, 9pm") );
	    executeTest(input);

	    input = "2 event 2 Jan 10am";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10am", "Sat, 02 Jan 16, 9pm") );
	    executeTest(input);

	    //Test when only event start date is specified, whether parser can set start time to default 12pm, and end date/time to default too
	    input = "2 event 2 Jan";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 9am", "Sat, 02 Jan 16, 9pm") );
	    executeTest(input);

	    //Test whether extra spaces affect date parser
	    input = "2 by 2 Jan 10 am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Sat, 02 Jan 16, 10am") );
	    executeTest(input);

	    input = "2 from 2 Jan 10 am to 10 pm ";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10am", "Sat, 02 Jan 16, 10pm") );
	    executeTest(input);

	    input = "2 from 2 Jan 10 am to 3/1 10 pm ";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10am", "Sun, 03 Jan 16, 10pm") );
	    executeTest(input);

	    input = "2 by Jan 2 10:30 am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Sat, 02 Jan 16, 10:30am") );
	    executeTest(input);

	    input = "2 from Jan 2 10:24 am to 3 Feb 7:39 pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10:24am", "Wed, 03 Feb 16, 7:39pm") );
	    executeTest(input);

	    //Test whether lack of spaces affect date parser
	    input = "2 by 2Jan 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Sat, 02 Jan 16, 10am") );
	    executeTest(input);

	    input = "2 by 30Jun 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Thu, 30 Jun 16, 10am") );
	    executeTest(input);

	    input = "2 by Jan2 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "2", "Sat, 02 Jan 16, 10am") );
	    executeTest(input);

	    input = "2 from Jan2 10am to 5Jun 10pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10am", "Sun, 05 Jun 16, 10pm") );
	    executeTest(input);

	    input = "2 from 2January 10am to June5 10pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 02 Jan 16, 10am", "Sun, 05 Jun 16, 10pm") );
	    executeTest(input);

	    //Test whether shortform for deadline works
	    input = "3 by today";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTodayDate() + " 15, 11:59pm") );
	    executeTest(input);

	    input = "3 by tmr";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTmrDate() + " 15, 11:59pm") );
	    executeTest(input);

	    //Test whether daily recurring task works
	    input = "5 every day";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 day") );
	    executeTest(input);

	    input = "5 every 3 days";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "3 day") );
	    executeTest(input);

	    //Test whether weekly recurring task works
	    input = "5 every 1 week";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 week") );
	    executeTest(input);

	    input = "5 every week";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 week") );
	    executeTest(input);

	    input = "5 every 2 WEEKS";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "2 week") );
	    executeTest(input);

	    //Test whether monthly recurring task works
	    input = "5 every month";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 month") );
	    executeTest(input);

	    input = "5 every 3 months";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "3 month") );
	    executeTest(input);

	    input = "5 every month aaaaa";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 month") );
	    executeTest(input);

	    //Test whether yearly recurring task works
	    input = "5 every year";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "1 year") );
	    executeTest(input);

	    input = "5 every 10 years";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "10 year") );
	    executeTest(input);

	    input = "5 every 100 years";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "100 year") );
	    executeTest(input);

	    //Test if using 'next' or 'later' works
	    input = "6 by 10 days later 2pm";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "01 Apr") );
	    printTest();
	    input = "6 by next tue 3pm";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "01 Apr") );
	    printTest();
	    input = "6 by 2 wed later 4pm";
	    expected = new ArrayList<String>( Arrays.asList("every", "5", "01 Apr") );
	    printTest();
	    input = "search 12 feb 2pm";
	    expected = new ArrayList<String>( Arrays.asList("search", "Fri, 12 Feb 16, 2pm") );
	    executeTest(input);

	    input = "search 12 feb";
	    expected = new ArrayList<String>( Arrays.asList("search", "12 Feb") );
	    executeTest(input);

	    input = "search 12/2";
	    expected = new ArrayList<String>( Arrays.asList("search", "12 Feb") );
	    executeTest(input);

	    input = "search 2pm";
	    expected = new ArrayList<String>( Arrays.asList("search", "2pm") );
	    executeTest(input);

	    input = "search 14:30";
	    expected = new ArrayList<String>( Arrays.asList("search", "2:30pm") );
	    executeTest(input);

	    input = "search saturday";
	    expected = new ArrayList<String>( Arrays.asList("search", "Sat") );
	    executeTest(input);

	    input = "search fri";
	    expected = new ArrayList<String>( Arrays.asList("search", "Fri") );
	    executeTest(input);

	    input = "search saturday 14:00";
	    expected = new ArrayList<String>( Arrays.asList("search", "Sat 2pm") );
	    executeTest(input);

	    input = "search today";
	    expected = new ArrayList<String>( Arrays.asList("search", "") );
	    printTest();
	    input = "search next sat 2pm";
	    expected = new ArrayList<String>( Arrays.asList("search", "") );
	    printTest();
	    input = "search Sunday guitar lesson";
	    expected = new ArrayList<String>( Arrays.asList("search", "guitar lesson Sun") );
	    executeTest(input);

	    input = "search november";
	    expected = new ArrayList<String>( Arrays.asList("search", "Nov") );
	    executeTest(input);

	    //Test whether add20ToYear works
	    input = "4 by 15/09/17 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "4", "Fri, 15 Sep 17, 10am") );
	    executeTest(input);

	    input = "4 by 15 sep 18 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "4", "Sat, 15 Sep 18, 10am") );
	    executeTest(input);

	    input = "4 by sep 15 27 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "4", "Wed, 15 Sep 27, 10am") );
	    executeTest(input);

	    input = "4 from dec 22 10";
	    expected = new ArrayList<String>( Arrays.asList("event", "4", "Tue, 22 Dec 15, 9am", "Tue, 22 Dec 15, 9pm") );
	    executeTest(input);

	    //Test whether confirmDateIsInfuture works properly
	    input = "2 from 7 nov 10 12pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Mon, 07 Nov 16, 12pm", "Mon, 07 Nov 16, 9pm") );
	    printTest();
	    
	    input = "2 from 7 nov 10 5pm";
	    expected = new ArrayList<String>( Arrays.asList("event", "2", "Sat, 07 Nov 15, 5pm", "Sat, 07 Nov 15, 9pm") );
	    printTest();
	    
	    //Make sure 'today' works for events
	    input = "3 from today 10pm to today 11pm";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTodayDate() + " 15, 10pm", getTodayDate() + " 15, 11pm") );
	    printTest();
	    
	    input = "3 from today 8am to today 10am";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTodayDate() + " 15, 8am", getTodayDate() + " 15, 10am") );
	    printTest();
	    
	    //Test other date keywords
	    input = "3 next tuesday";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTodayDate() + " 15, 10pm", getTodayDate() + " 15, 11pm") );
	    printTest();
	    
	    input = "3 next week";
	    expected = new ArrayList<String>( Arrays.asList("deadline", "3", getTodayDate() + " 15, 8am", getTodayDate() + " 15, 10am") );
	    printTest();
	}
	@Test
	/**
	 * Test whether parser can handle invalid commands
	 */
	public void ErrorTests(){
		System.out.println("\n-----------------Result for ErrorTests-----------------");
		//Parser should generate error if first word is not a command keyword or index
	    input = "addd Project Proposal";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidWordError: 'addd' is not recognised as a command or index") );
	    executeTest(input);

		input = "Project Proposal done";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidWordError: 'Project' is not recognised as a command or index") );
	    executeTest(input);

	    //Parser should generate error if task index is not followed by a command keyword
		input = "1 bla";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidCommandError: 'bla' is not recognised as a command") );
	    executeTest(input);

		input = "1";
	    expected = new ArrayList<String>( Arrays.asList("error", "NoCommandError: Please enter a command after the task index '1'") );
	    executeTest(input);

	    //Parser should generate error when a command is expecting an index, but the next word(s) is not an index
	    input = "delete Project Proposal";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidIndexError: 'Project Proposal' is not recognised as an index") );
	    executeTest(input);

	    //Parser should generate error when Duplicate commands are detected
		input = "1 deadline 30 October 12:34 deadline 30 December 23:59";
	    expected = new ArrayList<String>( Arrays.asList("error", "DuplicateCommandError: Duplicate command 'deadline'") );
	    executeTest(input);

		input = "1 priority 1 priority 5 priority 3";
	    expected = new ArrayList<String>( Arrays.asList("error", "DuplicateCommandError: Duplicate command 'priority'") );
	    executeTest(input);

		input = "add Project Proposal deadline coming soon priority 2 deadline 30 Nov 23:59";
	    expected = new ArrayList<String>( Arrays.asList("error", "DuplicateCommandError: Duplicate command 'deadline'") );
	    executeTest(input);

	    //Parser should generate error when user never include the content for a command
	    input = "deadline";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'deadline'") );
	    executeTest(input);

	    input = "deadline deadline";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'deadline'") );
	    executeTest(input);

	    input = "add";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'add'") );
	    executeTest(input);

	    input = "done";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'done'") );
	    executeTest(input);

	    input = "1 priority";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'priority'") );
	    executeTest(input);

	    input = "1 priority 3 deadline description hello";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'deadline'") );
	    executeTest(input);

	    input = "add dea des pri cat";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'add'") );
	    executeTest(input);

	    input = "show";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'show'") );
	    executeTest(input);

	    input = "1 reset";
	    expected = new ArrayList<String>( Arrays.asList("error", "EmptyFieldError: Please enter content for the command 'reset'") );
	    executeTest(input);

	    //Parser should generate error if priority is invalid (not between 1 to 5)
	    input = "1 priority 6";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidPriorityError: '6' is not between 1 to 5") );
	    executeTest(input);

	    input = "1 priority bla";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidPriorityError: 'bla' is not between 1 to 5") );
	    executeTest(input);

	    input = "1 deadline 30 Dec 23:59 priority 0";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidPriorityError: '0' is not between 1 to 5") );
	    executeTest(input);

	    //Parser should generate error when a date cannot be actual
	    input = "1 deadline qwertyuiop";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'qwertyuiop' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 priority 2 deadline qwertyuiop";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'qwertyuiop' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 reminder qwertyuiop";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'qwertyuiop' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 reminder qwertyuiop priority 2";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'qwertyuiop' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 event qwertyuiop";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'qwertyuiop' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 event asdfghjkl to 30 Dec 2pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'asdfghjkl' is not an acceptable date format") );
	    executeTest(input);

	    input = "1 event 30 Dec 2pm 2015 to asdfghjkl";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDateError: 'asdfghjkl' is not an acceptable date format") );
	    executeTest(input);

	    //Parser should not allow a task to have both deadline and event date
	    input = "1 deadline 15 Dec 8pm event 30 Dec 2pm to 6pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "ConflictingDatesError: Task cannot have both deadline and event date") );
	    executeTest(input);

	    input = "1 des conflicting dates deadline 15 Dec 8pm pri 4 event 30 Dec 2pm to 6pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "ConflictingDatesError: Task cannot have both deadline and event date") );
	    executeTest(input);

	    input = "1 event 30 Dec 2pm to";
	    expected = new ArrayList<String>( Arrays.asList("error", "NoEndDateError: Please enter an end date after the command word 'to'") );
	    executeTest(input);

	    input = "1 event 30 Dec 2pm to rem 23 Dec 2pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "NoEndDateError: Please enter an end date after the command word 'to'") );
	    executeTest(input);

	    //Parser should generate error when user never indicate the frequency of a recurring task
	    input = "5 every 2pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidFrequencyError: Please enter 'day'/'week'/'month'/'year' after 'every' to indicate the frequency") );
	    executeTest(input);

	    input = "5 every time";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidFrequencyError: Please enter 'day'/'week'/'month'/'year' after 'every' to indicate the frequency") );
	    executeTest(input);
 
	    input = "add again by tmr 2pm every what";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidFrequencyError: Please enter 'day'/'week'/'month'/'year' after 'every' to indicate the frequency") );
	    executeTest(input);
	    
	    //Parser should generate error when the content to show/sort/reset is invalid
	    input = "show aaaaa";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTaskTypeError: 'aaaaa' is not a valid task type "
	    		+ "(please enter 'todo', 'event', 'floating', 'today', 'overdue' or 'complete')" ) );
	    executeTest(input);

	    input = "sort aaaaa";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidSortFieldError: 'aaaaa' is not a valid sort field "
	    		+ "(please enter 'date', 'name' or 'priority')") );
	    executeTest(input);

	    input = "1 reset aaaaaaaaaa";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidResetError: 'aaaaaaaaaa' is not a field that can be reset") );
	    executeTest(input);

	    //Test invalid time
	    input = "4 from 20 Dec 2:60pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '2:60pm' is not an acceptable time format") );
	    executeTest(input);

	    input = "4 from 20 Dec 12:77";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '12:77' is not an acceptable time format") );
	    executeTest(input);

	    input = "4 by 20 Dec 3:99am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '3:99am' is not an acceptable time format") );
	    executeTest(input);

	    input = "4 by 20 Dec 25pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '25pm' is not an acceptable time format") );
	    executeTest(input);

	    input = "4 by 20 Dec 24pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '24pm' is not an acceptable time format") );
	    executeTest(input);

	    input = "4 by 20 Dec 36:32";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidTimeError: '36:32' is not an acceptable time format") );
	    executeTest(input);

	    //Test invalid date
	    input = "5 by 32/3 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '32/3' does not exist (March only has 31 days!)") );
	    executeTest(input);

	    input = "5 by 32 apr 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '32 apr' does not exist (April only has 30 days!)") );
	    executeTest(input);

	    input = "5 by may 32 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date 'may 32' does not exist (May only has 31 days!)") );
	    executeTest(input);

	    input = "5 from may 2 10am to 42 jun 4pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '42 jun' does not exist (June only has 30 days!)") );
	    executeTest(input);

	    input = "5 from may 72 10am to 42 jun 4pm";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date 'may 72' does not exist (May only has 31 days!)") );
	    executeTest(input);

	    input = "5 by 31/4 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '31/4' does not exist (April only has 30 days!)") );
	    executeTest(input);

	    input = "5 by 31 June 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '31 June' does not exist (June only has 30 days!)") );
	    executeTest(input);

	    input = "5 by 30 Feb 10am";
	    expected = new ArrayList<String>( Arrays.asList("error", "InvalidDayOfMonthError: The date '30 Feb' does not exist (February only has 29 days!)") );
	    executeTest(input);
	    
	    input = "add floating task every day";
	    expected = new ArrayList<String>( Arrays.asList("error", "NoDateForRecurrenceError: Cannot make floating task recur. Please set a deadline or start date for the task") );
	    executeTest(input);
	}
}
