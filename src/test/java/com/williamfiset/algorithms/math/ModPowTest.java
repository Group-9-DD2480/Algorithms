package com.williamfiset.algorithms.math;

//import org.junit.jupiter.api.Test;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ModPowTest {

    public ModPow obj = new ModPow();
    //Input 3,4,1000000, expected value is 81.
    @Test
    public void modPow() {
        //ModPow obj = new ModPow();
        java.math.BigInteger A, N, M, r1;
        long a, n, m, r2;

        A = new java.math.BigInteger("3");
        N = new java.math.BigInteger("4");
        M = new java.math.BigInteger("1000000");
        a = A.longValue();
        n = N.longValue();
        m = M.longValue();
        r1 = A.modPow(N, M);
        r2 = obj.modPow(a, n, m);
        assertThat(r1.longValue()).isEqualTo(r2);

    }
    //Expected Value:1,-2,39. Checks branch when n<0. Expected output:modPow(obj.modInv(a, m), -n, m)
    @Test
    public void modPowInvTest(){
        long a, n, m, r2;
        //ModPow obj = new ModPow();
        a = 1;
        n = -2;
        m = 39;
        r2 = obj.modPow(a, n, m);

        assertThat(r2).isEqualTo(obj.modPow(obj.modInv(a, m), -n, m));
    }
    // expected input: m=0, a,n doesn't matter. Expected output:ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void modPowException1(){
        long a, n, m, r2;
        //ModPow obj = new ModPow();
        a = 3;
        n = 4;
        m = 0;
        r2 = obj.modPow(a, n, m);


    }

    // expected input: a=3,n=-2, m=39,(gcd(a,m) != 1). Expected output:ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void modPowException2(){
        long a, n, m, r2;
        //ModPow obj = new ModPow();
        a = 3;
        n = -2;
        m = 39;
        r2 = obj.modPow(a, n, m); // 81

    }
    @Test
    public void runBranchCoverage(){
        java.math.BigInteger A, N, M, r1;
        long a, n, m, r2;
        boolean[] true_coverage = new boolean[11];
        //First unittest
        A = new java.math.BigInteger("3");
        N = new java.math.BigInteger("4");
        M = new java.math.BigInteger("1000000");
        a = A.longValue();
        n = N.longValue();
        m = M.longValue();
        r1 = A.modPow(N, M);
        r2 = obj.modPow(a, n, m);
        for(int i=0; i<true_coverage.length; i++){
            if (obj.branch_coverage[i] == true) {
                true_coverage[i] = true;
            }
        }
        //Second unit test
        a = 1;
        n = -2;
        m = 39;
        r2 = obj.modPow(a, n, m);
        for(int i=0; i<true_coverage.length; i++){
            if (obj.branch_coverage[i] == true) {
                true_coverage[i] = true;
            }
        }
        //First exception
        a = 3;
        n = 4;
        m = 0;
        try{
            r2 = obj.modPow(a, n, m);
        }catch (ArithmeticException e){

        }
        for(int i=0; i<true_coverage.length; i++){
            if (obj.branch_coverage[i] == true) {
                true_coverage[i] = true;
            }
        }
        //Second exception.
        a = 3;
        n = -2;
        m = 39;
        try{
            r2 = obj.modPow(a, n, m);
        }catch (ArithmeticException e){

        }
        for(int i=0; i<true_coverage.length; i++){
            if (obj.branch_coverage[i] == true) {
                true_coverage[i] = true;
            }
        }
        for(int i = 0; i < true_coverage.length; i++){
            System.out.println(true_coverage[i]);
        }
    }


}