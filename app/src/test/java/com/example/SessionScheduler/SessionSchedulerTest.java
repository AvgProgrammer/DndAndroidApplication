package com.example. SessionScheduler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.SessionScheduler.SessionScheduler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SessionSchedulerTest {

    private SessionScheduler session;

    @Before
    public void setUp() {
        session= new SessionScheduler();
    }

    @After
    public void tearDown() {
        session=null;
    }

    @Test
    public void setEmail(){
        session.setSender("John");
        List<String> testing=new ArrayList<>();
        testing.add("a");
        testing.add("b");
        testing.add("c");
        testing.add("d");
        session.setRecipents(testing);
        LocalDate dt1 = LocalDate.parse("2021-01-07");
        session.setDate(dt1);
        session.setTime("20:30");
        session.setLocation("Athens");
        session.setDescription("description");
        String expectedOutput="From:John\n"+"To:a,b,c,d\n"+"Date:2021-01-07\n"+"Time:20:30\n"+"Location:Athens\n"+"description";
        Assert.assertEquals(expectedOutput, session.sendEmail());
    }
}
