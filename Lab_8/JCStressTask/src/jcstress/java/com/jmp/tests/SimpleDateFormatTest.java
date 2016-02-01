package com.jmp.tests;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.BooleanResult2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created on 31.01.2016.
 */
@JCStressTest
@Description("SimpleDateFormat thread-safety test")
@Outcome(id = "[true, true]", expect = Expect.ACCEPTABLE, desc = "Everything is ok, values are matched")
@Outcome(id = "[false, true]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Fail!")
@Outcome(id = "[true, false]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Fail!")
@Outcome(id = "[false, false]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Fail!")
@State
public class SimpleDateFormatTest {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date parsed1 = new Date();
    Date parsed2 = new Date();
    //parse() and format()

    @Actor
    public void thread1() {

        try {
            parsed1 = dateFormat.parse("2016-12-12");
        } catch (Exception ex) {
            parsed1 = new Date();
        }
    }

    @Actor
    public void thread2() {

        try {
            parsed2 = dateFormat.parse("2015-07-25");
        } catch (Exception ex) {
            parsed2 = new Date();
        }
    }

    @Arbiter
    public void observe(BooleanResult2 res) {

        Calendar calendar = new GregorianCalendar().getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 12);
        Date date1 = calendar.getTime();

        calendar = new GregorianCalendar().getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DATE, 25);
        Date date2 = calendar.getTime();

        res.r1 = date1.equals(parsed1);
        res.r2 = date2.equals(parsed2);
    }

}
