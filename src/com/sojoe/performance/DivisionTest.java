package com.sojoe.performance;

public class DivisionTest {

    static final long countLong = 0xFFFFFFFfL;
    static final int countInt = 0xFFFFFFE;

    public static void main(String[] args) {

        System.out.println("Number of calculations for the longs:" + countLong);
        System.out.println("Number of calculations for the integers:" + countInt);

        for(int i = 0; i < 1; i++) {
            System.out.println("test : " + i);
            bitShiftLong(countLong);
            //bitShiftInt(countInt);
            halfDouble(countLong);
        }
    }

    public static void bitShiftLong(long countLong)
    {
        System.out.println("Performing bitshift divisions with longs");
        long time = System.currentTimeMillis();
        long testLong = 0L;

        for (long j = 0L, i = countLong; i > 0; i-=2, j++) {
            testLong = (i+j>>1) + (j+i)%2;
        }

        System.out.println("final result: " +testLong);
        System.out.println("bitShift test took :" +(System.currentTimeMillis()-time)+"[ms]");
    }

    public static void bitShiftInt(int count)
    {
        System.out.println("Performing bitshift divisions with integers");
        long time = System.currentTimeMillis();
        long test = 0;
        for (int j = 0, i = countInt; i > 0; i-=2, j++) {
            test = (i+j>>1) + (j+i)%2;
        }
        System.out.println("final result: " +test);
        System.out.println("bitShift test took :" +(System.currentTimeMillis()-time)+"[ms]");
    }

    public static void halfDouble(long countLong)
    {
        System.out.println("Performing double division by 2 with doubles");
        long time = System.currentTimeMillis();
        int test = 0;

        for (long j = 0, i = countLong; i > 0; i-=2, j++) {
            double testd = ((j+i)*0.5);
            test = (int)(testd+.5);
        }
        System.out.println("final result: " +test);
        System.out.println("halfing via doubles took :"+ (System.currentTimeMillis()-time) + "[ms]");
    }





}
