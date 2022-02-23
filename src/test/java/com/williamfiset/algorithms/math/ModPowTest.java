package com.williamfiset.algorithms.math;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ModPowTest {

    @Test
    public void modPow() {
        ModPow obj = new ModPow();
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
    @Test
    public void modPowInvTest(){
        long a, n, m, r2;
        ModPow obj = new ModPow();
        a = 1;
        n = -2;
        m = 39;
        r2 = obj.modPow(a, n, m);
        assertThat(r2).isEqualTo(obj.modPow(obj.modInv(a, m), -n, m));
    }

    @Test(expected = ArithmeticException.class)
    public void modPowException1(){
        long a, n, m, r2;
        ModPow obj = new ModPow();
        a = 3;
        n = 4;
        m = 0;
        r2 = obj.modPow(a, n, m);
    }

    @Test(expected = ArithmeticException.class)
    public void modPowException2(){
        long a, n, m, r2;
        ModPow obj = new ModPow();
        a = 3;
        n = -2;
        m = 39;
        r2 = obj.modPow(a, n, m); // 81
    }


}