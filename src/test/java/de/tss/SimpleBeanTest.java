package de.tss;

import org.junit.Assert;
import org.junit.Test;

public class SimpleBeanTest {

    /*@Test
    public void testMe() {
        SimpleBean f = new SimpleBean("H");
        Assert.assertEquals("H", f.getDep());
        System.out.println("f = " + f);
    }*/

    /// Simple output:
    /// A   B   C
    /// B   C   E
    /// C   G
    /// D   A   F
    /// E   F
    /// F   H
    //@Test
    /*public void test() {
        SimpleBean a = new SimpleBean("b", "c");
        SimpleBean b = new SimpleBean("c", "e");
        SimpleBean c = new SimpleBean("g");
        SimpleBean d = new SimpleBean("a", "f");
        SimpleBean e = new SimpleBean("f");
        SimpleBean f = new SimpleBean("h");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
    }*/

    /// A   B C E F G H
    /// B   C E F G H
    /// C   G
    /// D   A B C E F G H
    /// E   F H
    /// F   H
    @Test
    public void testFullDep() {

        SimpleBean h = new SimpleBean("h");
        SimpleBean g = new SimpleBean("g");
        SimpleBean f = new SimpleBean("f", h);
        SimpleBean e = new SimpleBean("e", f);
        SimpleBean c = new SimpleBean("c",g);
        SimpleBean b = new SimpleBean("b", c, e);
        SimpleBean a = new SimpleBean("a", b, c);
        SimpleBean d = new SimpleBean("d", a, f);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}