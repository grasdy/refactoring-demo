package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CustomerTest {

    @Test @Ignore
    public void shouldNameBeTest(){

        Customer sut = new Customer("Test" );
        String name = sut.getName();
        Assert.assertEquals("Test", name);
    }

    @Test @Ignore
    public void shouldContainRentalRecords(){

        Customer sut = new Customer("Test");
        String statement = sut.Statement();
        Assert.assertTrue(statement.contains("Rental record for Test"));
        Assert.assertTrue(statement.contains("Amount owed is "));
        Assert.assertTrue(statement.contains("You earned "));
        Assert.assertTrue(statement.contains(" frequent renter points."));
    }

    @Test @Ignore
    public void shouldContainNewReleaseStatus(){
        Customer sut = new Customer("Test");
        Movie movie = new Movie("NewRelease", PriceCodes.NewRelease);
        Rental rental = new Rental(movie, 2);

        sut.addRental(rental);

        String statement = sut.Statement();
        Assert.assertTrue(statement.contains("\tNewRelease\t"));
    }
}
