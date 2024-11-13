package ex1;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double[] get_varf() {
        double xv = -b / (2.0 * a);
        double yv = -(b * b - 4 * a * c) / (4.0 * a);
        return new double[]{xv, yv};
    }

    @Override
    public String toString() {
        return String.format("f(x) = %d x^2 + %d x + %d", a, b, c);
    }


    public double[] coord_mijloc(Parabola p) {//mij(V1,v2)
        double[] v1 = this.get_varf();
        double[] v2 = p.get_varf();
        double xm = (v1[0] + v2[0]) / 2;
        double ym = (v1[1] + v2[1]) / 2;
        return new double[]{xm, ym};
    }

    public static double[] coord_mijloc_static(Parabola p1, Parabola p2) {
        double[] v1 = p1.get_varf();
        double[] v2 = p2.get_varf();
        double xm = (v1[0] + v2[0]) / 2;
        double ym = (v1[1] + v2[1]) / 2;
        return new double[]{xm, ym};
    }


    public double lungime_segment(Parabola p) {
        double[] v1 = this.get_varf();
        double[] v2 = p.get_varf();
        return Math.hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }


    public static double lungime_segment_static(Parabola p1, Parabola p2) {
        double[] v1 = p1.get_varf();
        double[] v2 = p2.get_varf();
        return Math.hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }
}

