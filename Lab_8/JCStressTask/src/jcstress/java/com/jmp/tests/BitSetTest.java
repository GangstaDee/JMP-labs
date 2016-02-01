package com.jmp.tests;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.BooleanResult2;


import java.util.BitSet;

/**
 * Created on 31.01.2016.
 */
@JCStressTest
@Description("BitSet thread-safety test")
@Outcome(id = "[true, true]", expect = Expect.ACCEPTABLE, desc = "Everything is ok, values are matched")
@Outcome(id = "[false, true]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "T1 result is overwritten")
@Outcome(id = "[true, false]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "T2 result is overwritten")
@State
public class BitSetTest {

    final BitSet bitSet = new BitSet();

    @Actor
    public void thread1() {
        bitSet.set(0);
    }

    @Actor
    public void thread2() {
        bitSet.set(1);
    }

    @Arbiter
    public void observe(BooleanResult2 res) {
        res.r1 = bitSet.get(0);
        res.r2 = bitSet.get(1);
    }
}
