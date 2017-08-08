package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CustomerUnitTest {


    @Test
    public void shouldContainMovieNameWhenGetMovie() {
        Customer sut = new Customer("Test");
        Rental stub = mock(Rental.class);
        when(stub.getMovie()).thenReturn(new Movie("TestMovie", PriceCodes.Regular));

        sut.addRental(stub);
        String result = sut.Statement();

        assertThat(result).contains("TestMovie");
    }

    @Test
    public void shouldTotalAmountIncreaseTwoWhenRentalRegularMovieLessTwoDays() {
        Customer sut = new Customer("Test");
        Rental stub = mock(Rental.class);
        when(stub.getMovie()).thenReturn(new Movie("TestMovie", PriceCodes.Regular));
        when(stub.getDaysRented()).thenReturn(1);

        sut.addRental(stub);

        String testResult = "2";
        assertThat(sut.Statement()).contains(testResult);
    }

    @Test
    public void shouldTotalAmountIncreaseWhenRentalRegularMovieMoreTwoDays() {
        Customer sut = new Customer("Test");
        Rental stub = mock(Rental.class);
        when(stub.getMovie()).thenReturn(new Movie("TestMovie", PriceCodes.Regular));
        when(stub.getDaysRented()).thenReturn(3);

        sut.addRental(stub);

        String testResult = "3.5";
        assertThat(sut.Statement()).contains(testResult);
    }


    @Test
    public void shouldTotalAmountIncreaseWhenRentalChildrenMovieLessThreeDays() {
        Customer sut = new Customer("Test");
        Rental stub = mock(Rental.class);
        when(stub.getMovie()).thenReturn(new Movie("TestMovie", PriceCodes.Childrens));
        when(stub.getDaysRented()).thenReturn(3);

        sut.addRental(stub);

        String testResult = "1.5";
        assertThat(sut.Statement()).contains(testResult);
    }

    @Test
    public void shouldCallGetMovieWhenCallStatement() {
        Customer sut = new Customer("Test");
        Rental mock = mock(Rental.class);
        when(mock.getMovie()).thenReturn(new Movie("TestMovie", PriceCodes.Regular));

        sut.addRental(mock);
        sut.Statement();

        verify(mock, times(3)).getMovie();
    }
}
