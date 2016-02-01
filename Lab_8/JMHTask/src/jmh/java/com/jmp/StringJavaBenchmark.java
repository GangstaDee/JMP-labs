package com.jmp;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created on 2/1/2016.
 */
public class StringJavaBenchmark {

    @State(Scope.Thread) //how to share for another test?
    public static class ListState {

        @Param({"20", "100", "500", "4000"})
        public static int size;

        List<String> list = new ArrayList<>();

        @Setup(Level.Trial)
        public void fill() {

            System.out.println("Fill list");
            for(int i = 0; i < size; i++) {
                String str = (new Random().nextInt(10000)+1) + UUID.randomUUID().toString().replaceAll("-", "");
                list.add(str);
            }
        }

        @TearDown(Level.Trial)
        public void cleanup() {
            System.out.println("Clear list");
            list.clear();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Fork(1)
    public List<String> testJava7(ListState listState) {

        List<String> list = listState.list;

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(!iterator.next().startsWith("9")) {
                iterator.remove();
            }
        }

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        list = list.size() > 10 ? list.subList(0,10) : list;

        AtomicInteger i = new AtomicInteger();
        i.getA
        return list;
    }



    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Fork(1)
    public List<String> testJava8(ListState listState) {

        List<String> list = listState.list;

        List<String> res = list.stream().filter(s -> s.startsWith("9")).sorted(String.CASE_INSENSITIVE_ORDER).
                limit(10).collect(Collectors.toList());

        return list;
    }
}
