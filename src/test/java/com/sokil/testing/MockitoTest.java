package com.sokil.testing;

import org.junit.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoTest {

    LinkedList mockedList = mock(LinkedList.class);

    @Test
    public void testMock(){
        mockedList.add("One");
        mockedList.clear();

        verify(mockedList).add("One");
        verify(mockedList).clear();
    }

    @Test
    public void stabTest(){
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));

        try {
            System.out.println(mockedList.get(1));
        }catch (RuntimeException e){
            System.out.println(e);
        }

        System.out.println(mockedList.get(999));
    }
}
