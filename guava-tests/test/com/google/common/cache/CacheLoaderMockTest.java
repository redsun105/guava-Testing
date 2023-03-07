package com.google.common.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CacheLoaderMockTest {

    @Mock
    private CacheLoader<String, Integer> cacheLoader;

    @Test
    public void testLoad() throws Exception {
        // given values
        String key = "foo";
        int value = 22;

        // define the behavior of the mock object.
        // In this case, we specify that when the load method is called with the given key,
        // it should return the given value.
        when(cacheLoader.load(key)).thenReturn(value);

        // `loadedValue` variable is assigned the result of
        // calling the load method on the mock object with the given key.
        int loadedValue = cacheLoader.load(key);

        // `verify` method is used to ensure that
        // the load method was called with the given key.
        verify(cacheLoader).load(key);

        // `assertEquals` method to ensure that
        // the result of the load method is equal to the given value
        assertEquals(value, loadedValue);
    }
}
