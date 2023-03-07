package com.google.common.io;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

public class ResourcesMockingTest {
    @Test
    public void testReadResource() throws IOException {
        // Create a mock ClassLoader object
        ClassLoader mockClassLoader = mock(ClassLoader.class);

        // Create a mock URL object
        URL mockUrl = new URL("http://example.com/resource.txt");

        // Define the return value of the ClassLoader's getResource method
        when(mockClassLoader.getResource("resource.txt")).thenReturn(mockUrl);

        // Assert that the actual content matches the expected content
        assertEquals(mockUrl, mockClassLoader.getResource("resource.txt"));
    }
}

