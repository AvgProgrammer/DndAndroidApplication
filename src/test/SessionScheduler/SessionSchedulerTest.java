package SessionScheduler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SessionScheduler.SessionScheduler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class SessionSchedulerTest {

    private SessionScheduler session;

    @BeforeEach
    void setUp() {
        session= new SessionScheduler();
    }

    @AfterEach
    void tearDown() {
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
        Assertions.assertEquals(expectedOutput, session.sendEmail());
    }
}
