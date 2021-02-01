package com.rendawei.yudipu;

public class ParticleReduce {

  public static void main(String[] args) {

    long t1 = 2124;
    int N = 300;
    float D = (float) 3.2;

    float f = (float) (20 * 1000) / t1;

    System.out.println(f);

    // 求对数
    double tmp = Math.log(f) / Math.log(2);  // 对数
    System.out.println(tmp);

//    对求出来的对数四舍五入
    float tmp1 = Math.round(tmp);
//    int tmp2 = (int) Math.round(3.599999);
    System.out.println(tmp1);
//    System.out.println(tmp2);
    double F = Math.pow(2, tmp1);
    System.out.println(F);

    double t2 = 1 / F;
    System.out.println(t2);

    double T = N * t2;
    System.out.println(T);

    double v = D / T;
    System.out.println(v);

    float v1 = (float) (D / ((N * (1 / (Math.pow(2, Math.round(Math.log((float) (20 * 1000) / t1) / Math.log(2))))))*1000));
    System.out.println(v1);
  }
}
