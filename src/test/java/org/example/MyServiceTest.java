package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Test
    public void testMethodAWithSpy() {
        MyService myService = new MyService();

        MyService spyService = spy(myService);

        // Stubbing method b
        when(spyService.b("test")).thenReturn("Stubbed Response from b");

        // Call method a
        String result = spyService.a("test");

        // Verify the result
        System.out.println(result); // Outputs: Stubbed Response from b

        // Verify that method b was called
        verify(spyService).b("test");
    }

    @Test
    public void mockStaticMethod() {
        try (MockedStatic<StringHelper> mockedStatic = mockStatic(StringHelper.class)) {
            mockedStatic.when(StringHelper::Hello).thenReturn("Mocked Hello");

            MyService myService = new MyService();
            String result = myService.a("test"); // This calls method b, which calls StringHelper.Hello

            // Assert the result or verify interactions
            assertEquals("test Mocked Hello", result);
            mockedStatic.verify(StringHelper::Hello);
        }
    }
}
