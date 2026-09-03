package com.billing;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testCalculateBill() {
        App app = new App();
        
        // Test standard execution (no extra usage charges applied)
        assertEquals(20.0, app.calculateBill("basic", 8.0), 0.01);
        
        // Test extra usage charges evaluation ($40 base rate + 5GB over limit * $5 = $65.00)
        assertEquals(65.0, app.calculateBill("standard", 55.0), 0.01);
    }
}
