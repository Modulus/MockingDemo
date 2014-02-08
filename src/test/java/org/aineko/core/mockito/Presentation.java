package org.aineko.core.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Modulus on 08.02.14.
 */
public class Presentation {

    private Something mockObject;

    @Before
    public void setUp(){
        //Dette lager et mock object a Something klassen
        mockObject = mock(Something.class);

        //Beskriver oppførsel til den mockede klassen når metoden returnerer data
        when(mockObject.method1()).thenReturn("Mock data");


        //Beskriver oppførsel til en metode som har void som returtype
        doNothing().when(mockObject).method2();
    }

    @Test
    public void testMethods(){

        mockObject.method1();
        mockObject.method1();
        mockObject.method1();

        mockObject.method2();

        //Verifiser oppførsel
        verify(mockObject, times(3)).method1();
        verify(mockObject, times(1)).method2();

        assertEquals("Mock data", mockObject.method1());
    }


    private class Something {
        public String method1(){
            return "Real method";
        }

        public void method2(){
            throw new NullPointerException();
        }
    }
}



