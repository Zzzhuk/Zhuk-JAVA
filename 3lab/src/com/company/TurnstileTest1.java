package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TurnstileTest1 {

    @Test
    public void testPassCard() {
        TimeCard tc = new TimeCard(2, true);
        Register reg = new Register();
        reg.CreateCard(tc);
        Turnstile turnstile = new Turnstile();
        Assert.assertEquals(true, turnstile.PassCard(tc));

    }

    @Test
    public void testPassCard1() {
        TimeCard tc1 = new TimeCard(2, true, LocalDate.of(2020, 02, 01));
        Register reg = new Register();
        reg.CreateCard(tc1);
        Turnstile turnstile = new Turnstile();
        Assert.assertEquals(false, turnstile.PassCard(tc1));
    }

    @Test
    public void testPassCard2() {
        TimeCard tc2 = new TimeCard(2, false, LocalDate.of(2020, 02, 23));
        Register reg = new Register();
        reg.CreateCard(tc2);
        Turnstile turnstile = new Turnstile();
        Assert.assertEquals(false, turnstile.PassCard(tc2));
    }

    @Test
    public void testPassCard3() {
        MoneyCard mc = new MoneyCard(14);
        Register reg = new Register();
        reg.CreateCard(mc);

        Turnstile turnstile = new Turnstile();
        System.out.println("First try:");
        turnstile.PassCard(mc);
        System.out.println("Second try:");
        Assert.assertEquals(false, turnstile.PassCard(mc));
    }

    @Test
    public void testPassCard4() {
        NumberCard nc = new NumberCard(4, true);
        Register reg = new Register();
        reg.CreateCard(nc);

        Turnstile turnstile = new Turnstile();
        System.out.println("First try:");
        turnstile.PassCard(nc);
        System.out.println("Second try:");
        turnstile.PassCard(nc);
        System.out.println("Third try:");
        turnstile.PassCard(nc);
        System.out.println("Fourth try:");
        turnstile.PassCard(nc);
        System.out.println("Fifth try:");
        Assert.assertEquals(false, turnstile.PassCard(nc));
    }

    @Test
    public void testPassCard5() {
        NumberCard nc = new NumberCard(4, true);
        Turnstile turnstile = new Turnstile();
        Register reg = new Register();
        reg.CreateCard(nc);
        reg.CancelCard(nc);
        Assert.assertEquals(false, turnstile.PassCard(nc));
    }

    @Test
    public void testPassCard6() {
        NumberCard nc = new NumberCard(4, true);
        Register reg = new Register();
        reg.CreateCard(nc);
        Turnstile turnstile = new Turnstile();
        turnstile.PassCard(nc);
        turnstile.PassCard(nc);
        reg.CancelCard(nc);
        Assert.assertEquals(false, turnstile.PassCard(nc));
        reg.PassInfo(nc);
        reg.GetInfo(nc.getId());

    }

}