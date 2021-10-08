package org.elasticsearch.numbers;

public class Numbers {
    public static short bytesToShort(byte[] bytes, int offset) {
        return (short) (((bytes[offset] & 0xFF) << 8) | (bytes[offset + 1] & 0xFF));
    }

    public static int bytesToInt(byte[] bytes, int offset) {
        return ((bytes[offset] & 0xFF) << 24) | ((bytes[offset + 1] & 0xFF) << 16) | ((bytes[offset + 2] & 0xFF) << 8)
                | (bytes[offset + 3] & 0xFF);
    }

    public static long bytesToLong(byte[] bytes, int offset) {
        return (((long) (((bytes[offset] & 0xFF) << 24) | ((bytes[offset + 1] & 0xFF) << 16) | ((bytes[offset + 2] & 0xFF) << 8)
                | (bytes[offset + 3] & 0xFF))) << 32)
                | ((((bytes[offset + 4] & 0xFF) << 24) | ((bytes[offset + 5] & 0xFF) << 16) | ((bytes[offset + 6] & 0xFF) << 8)
                | (bytes[offset + 7] & 0xFF)) & 0xFFFFFFFFL);
    }

    public static byte[] intToBytes(int val) {
        byte[] arr = new byte[4];
        arr[0] = (byte) (val >>> 24);
        arr[1] = (byte) (val >>> 16);
        arr[2] = (byte) (val >>> 8);
        arr[3] = (byte) (val);
        return arr;
    }

    /**
     * Converts an int to a byte array.
     *
     * @param val The int to convert to a byte array
     * @return The byte array converted
     */
    public static byte[] shortToBytes(int val) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (val >>> 8);
        arr[1] = (byte) (val);
        return arr;
    }

    /**
     * Converts a long to a byte array.
     *
     * @param val The long to convert to a byte array
     * @return The byte array converted
     */
    public static byte[] longToBytes(long val) {
        byte[] arr = new byte[8];
        arr[0] = (byte) (val >>> 56);
        arr[1] = (byte) (val >>> 48);
        arr[2] = (byte) (val >>> 40);
        arr[3] = (byte) (val >>> 32);
        arr[4] = (byte) (val >>> 24);
        arr[5] = (byte) (val >>> 16);
        arr[6] = (byte) (val >>> 8);
        arr[7] = (byte) (val);
        return arr;
    }
}
