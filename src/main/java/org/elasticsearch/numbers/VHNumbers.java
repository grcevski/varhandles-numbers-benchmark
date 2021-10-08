package org.elasticsearch.numbers;

import java.lang.invoke.VarHandle;
import java.lang.invoke.MethodHandles;
import java.nio.ByteOrder;

public class VHNumbers {
    public static final VarHandle VH_BE_SHORT =
            MethodHandles.byteArrayViewVarHandle(short[].class, ByteOrder.BIG_ENDIAN);

    public static final VarHandle VH_BE_INT =
            MethodHandles.byteArrayViewVarHandle(int[].class, ByteOrder.BIG_ENDIAN);

    public static final VarHandle VH_BE_LONG =
            MethodHandles.byteArrayViewVarHandle(long[].class, ByteOrder.BIG_ENDIAN);

    public static byte[] shortToBytes(int val) {
        byte[] arr = new byte[2];
        VH_BE_SHORT.set(arr, 0, (short)val);
        return arr;
    }

    public static byte[] intToBytes(int val) {
        byte[] arr = new byte[4];
        VH_BE_INT.set(arr, 0, val);
        return arr;
    }

    public static byte[] longToBytes(long val) {
        byte[] arr = new byte[8];
        VH_BE_LONG.set(arr, 0, val);
        return arr;
    }

    public static long bytesToLong(byte[] bytes, int offset) {
        return (long) VH_BE_LONG.get(bytes, offset);
    }

    public static int bytesToInt(byte[] bytes, int offset) {
        return (int) VH_BE_INT.get(bytes, offset);
    }

    public static short bytesToShort(byte[] bytes, int offset) {
        return (short) VH_BE_SHORT.get(bytes, offset);
    }
}
