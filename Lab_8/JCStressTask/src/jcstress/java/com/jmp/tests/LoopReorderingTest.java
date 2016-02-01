package com.jmp.tests;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

/**
 * Created on 2/1/2016.
 */
@JCStressTest
@Description("Test to identify reordering optimization using loop")
@Outcome(id = "[0, 0]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[1, 0]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[2, 0]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[3, 0]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[2, 20]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[3, 20]", expect = Expect.ACCEPTABLE, desc = "No reordering")
@Outcome(id = "[0, 20]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Reordering identified")
@Outcome(id = "[1, 20]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Reordering identified")
@Outcome(id = "[2, 20]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Reordering identified")
@State
public class LoopReorderingTest {

    int a;
    int b;

    @Actor
    public void mainThread(IntResult2 res) {

        while(a < 3) {
            a += 1;
        }
        b = 20;
    }

    @Actor
    public void checkingThread(IntResult2 res) {

        res.r1 = a;
        res.r2 = b;

    }
}
