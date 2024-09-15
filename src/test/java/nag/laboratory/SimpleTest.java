package nag.laboratory;

import java.net.http.HttpHeaders;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    void classLoaderTest() {
        System.out.println(Object.class.getClassLoader());

        System.out.println(HttpHeaders.class.getClassLoader());

        System.out.println(SimpleClass.class.getClassLoader());
    }

}
