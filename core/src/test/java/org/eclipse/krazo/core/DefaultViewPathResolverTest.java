package org.eclipse.krazo.core;

import static org.junit.Assert.*;

import javax.mvc.View;

import org.junit.Before;
import org.junit.Test;

public class DefaultViewPathResolverTest {

    private ViewPathResolver viewPathResolver;

    @Before
    public void before() {
        viewPathResolver = new DefaultViewPathResolver();
    }

    @Test
    public void testDefaultBehaviour() throws NoSuchMethodException, SecurityException {
        Class<MyTestClass> clazz = MyTestClass.class;
        assertNull(viewPathResolver.pathFor(clazz.getDeclaredMethod("someMethod")));
        assertNull(viewPathResolver.pathFor(clazz.getDeclaredMethod("someMethod2")));
    }

    @Test
    public void testDefaultBehaviourWithAnnotedClass() throws NoSuchMethodException, SecurityException {
        Class<MyTestClass2> clazz = MyTestClass2.class;
        assertNull(viewPathResolver.pathFor(clazz.getDeclaredMethod("someMethod")));
        assertNull(viewPathResolver.pathFor(clazz.getDeclaredMethod("someMethod2")));
    }

    @Test
    public void testDefaultBehaviourWithInheritClass() throws NoSuchMethodException, SecurityException {
        Class<MyTestClass3> clazz = MyTestClass3.class;
        assertNull(viewPathResolver.pathFor(clazz.getMethod("someMethod")));
        assertNull(viewPathResolver.pathFor(clazz.getMethod("someMethod2")));
    }

    private class MyTestClass {

        @View("a.jsp")
        public void someMethod() {

        }

        public void someMethod2() {

        }
    }

    @View("b.jsp")
    private class MyTestClass2 {

        @View("a.jsp")
        public void someMethod() {

        }

        public void someMethod2() {

        }
    }

    private class MyTestClass3 extends MyTestClass2 {

    }
}
