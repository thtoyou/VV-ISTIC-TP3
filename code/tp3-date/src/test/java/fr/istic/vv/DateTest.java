package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {


    private Date date;
    private Date date2;
    private Date date3;
    private Date date4;
    private Date date5;
    private Date leapdate;
    private Date firstDAy;

    private int annee2 = 2019;
    private int annee3 = 2000;

    @BeforeEach
    protected void setUp() throws Exception {
        //happyPath
        date = new Date(8, 03, 2023);
        //date to compare


        // change block one by one to improve tests
       // date5 = new Date(28, 02, 2020);

        //leap year
        leapdate = new Date(29, 02, 2020);
    }

    @Test
    public void isValidDateTest1() {
        assertTrue(isValidDate(17, 01, 2020));
    }

    @Test
    public void isValidDateTest2() {
        assertFalse(isValidDate(-50, 5, 2020));
    }

    @Test
    public void isValidDateTest3() {
        assertFalse(isValidDate(5, -8, 2020));
    }

    @Test
    public void isValidDateTest4() {
        assertFalse(isValidDate(5, 2, 20));
    }

    @Test
    public void isValidDateTest5() {
        assertFalse(isValidDate(0, 0, 0));
    }

    @Test
    public void isValidDateTest6() {
        assertFalse(isValidDate(-5, 50, 2020));
    }

    @Test
    public void isValidDateTest7() {
        assertFalse(isValidDate(29, 2, 2019), "February in 2019 had only 28 days");
    }



    @Test
    public void isLeapYearTest2() {
        assertFalse(isLeapYear(annee2));
    }

    @Test
    public void isLeapYearLogicCoverage() {
        assertTrue(isLeapYear(annee3));
    }

    @Test
    public void nextDateTest1() {
        Date expectedDate = new Date(9, 03, 2023);
        assertEquals(expectedDate,date.nextDate(date));
    }

    @Test
    public void nextDateTest2() {
        Date expectedDate = new Date(1, 03, 2020);
        Date testDate = leapdate.nextDate(leapdate);
        assertEquals(expectedDate,testDate);
    }

    @Test
    public void nextDateTest3() {
        Date expectedDate = new Date(1, 7, 2020);
        Date test = new Date(30, 6, 2020);
        assertEquals(expectedDate,test.nextDate(test));
    }

    @Test
    public void nextDateTest4() {
        Date expectedDate = new Date(1, 1, 2023);
        Date test = new Date(31, 12, 2022);
        assertEquals(expectedDate,test.nextDate(test));
    }

    @Test
    public void previousDateTest() {
        Date expectedDate2 = new Date(7,03,2023);
        assertEquals(expectedDate2,date.previousDate());
    }

    @Test
    public void previousDateTest2() {
        Date test = new Date(1, 03, 2020);
        Date expectedDate2 = new Date(29,02,2020);
        assertEquals(expectedDate2,test.previousDate());
    }

    @Test
    public void previousDateTest3() {
        Date test = new Date(1, 1, 2023);
        Date expectedDate2 = new Date(31,12,2022);
        assertEquals(expectedDate2,test.previousDate());
    }

    @Test
    public void previousDateTest4() {
        Date test = new Date(1, 1, 2022);
        Date expectedDate2 = new Date(31,12,2021);
        assertEquals(expectedDate2,test.previousDate());
    }

    @Test
    public void compareToTest() {
    Date other = new Date(10,5,2020);
        assertTrue(date.compareTo(other)>0);
    }

    @Test
    public void countDaysTest() {
        assertEquals(31, countDays(12,2012));
    }

}


