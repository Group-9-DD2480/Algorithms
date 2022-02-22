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
        r1 = A.modPow(N, M); // 81
        r2 = obj.modPow(a, n, m); // 81
        assertThat(r1.longValue()).isEqualTo(r2);
    }
    
}