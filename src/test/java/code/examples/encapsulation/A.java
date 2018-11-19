package code.examples.encapsulation;

import org.junit.Assert;
import org.junit.Test;

public class A {
    
    String a = "Wow";
    
    public A() {
        a = "much A's";
    }
    
    public void A() {
        
    }

    @Test
    public void m(){
        final A a = new A();
        Assert.assertEquals("much A's", a.a);
    }
}