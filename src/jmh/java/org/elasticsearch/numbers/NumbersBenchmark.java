package org.elasticsearch.numbers;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class NumbersBenchmark {
    private final static byte[] longBytes = Numbers.longToBytes(12345678901L);
    private final static byte[] intBytes = Numbers.intToBytes(123456);
    private final static byte[] shortBytes = Numbers.shortToBytes(123);

    @Benchmark
    public void shortToBytes(Blackhole bh) {
        bh.consume(Numbers.shortToBytes(30));
    }

    @Benchmark
    public void intToBytes(Blackhole bh) {
        bh.consume(Numbers.intToBytes(300000));
    }

    @Benchmark
    public void longToBytes(Blackhole bh) {
        bh.consume(Numbers.longToBytes(12345678901L));
    }

    @Benchmark
    public void shortToBytesVH(Blackhole bh) {
        bh.consume(VHNumbers.shortToBytes(30));
    }

    @Benchmark
    public void intToBytesVH(Blackhole bh) {
        bh.consume(VHNumbers.intToBytes(300000));
    }

    @Benchmark
    public void longToBytesVH(Blackhole bh) {
        bh.consume(VHNumbers.longToBytes(12345678901L));
    }

    @Benchmark
    public void bytesToLong(Blackhole bh) {
        bh.consume(Numbers.bytesToLong(longBytes, 0));
    }

    @Benchmark
    public void bytesToLongVH(Blackhole bh) {
        bh.consume(VHNumbers.bytesToLong(longBytes, 0));
    }

    @Benchmark
    public void bytesToInt(Blackhole bh) {
        bh.consume(Numbers.bytesToInt(intBytes, 0));
    }

    @Benchmark
    public void bytesToIntVH(Blackhole bh) {
        bh.consume(VHNumbers.bytesToInt(intBytes, 0));
    }

    @Benchmark
    public void bytesToShort(Blackhole bh) {
        bh.consume(Numbers.bytesToShort(shortBytes, 0));
    }

    @Benchmark
    public void bytesToShortVH(Blackhole bh) {
        bh.consume(VHNumbers.bytesToShort(shortBytes, 0));
    }
}
