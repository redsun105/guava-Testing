package com.google.common.collect;

import com.google.common.base.Predicate;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IterablesMockingTest {
    @Test
    public void testAll() {
        // Create a mocked Iterable
        Iterable<Integer> iterable = mock(Iterable.class);
        when(iterable.iterator()).thenReturn(Arrays.asList(2, 3).iterator());

        // Create a mocked Predicate to check if a number is even
        Predicate<Integer> evenPredicate = mock(Predicate.class);
        when(evenPredicate.apply(2)).thenReturn(true);
        when(evenPredicate.apply(3)).thenReturn(false);

        // Call the Iterables.all method with the mocked Iterable and Predicate
        boolean allEven = Iterables.all(iterable, evenPredicate);

        // Verify that the iterable's iterator method was called on the mock objects with the correct arguments
        verify(iterable).iterator();

        // Verify that the evenPredicate's apply method was called on the mock objects with the correct arguments
        verify(evenPredicate).apply(2);
        verify(evenPredicate).apply(3);

        // Verify that the method returns the expected result
        assertEquals(false, allEven);
    }
}

