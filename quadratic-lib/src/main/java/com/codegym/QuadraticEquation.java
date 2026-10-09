package com.codegym;

/**
 * Giải phương trình bậc 2: a*x^2 + b*x + c = 0 (a khác 0).
 */
public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Hệ số a phải khác 0 (nếu a = 0 thì không phải phương trình bậc 2)");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    /** Tính delta = b^2 - 4ac */
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    /** Nghiệm thứ nhất; trả về NaN nếu phương trình vô nghiệm thực. */
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    /** Nghiệm thứ hai; trả về NaN nếu phương trình vô nghiệm thực. */
    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    /**
     * Giải phương trình.
     * @return mảng rỗng (vô nghiệm), 1 phần tử (nghiệm kép) hoặc 2 phần tử (hai nghiệm phân biệt)
     */
    public double[] solve() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return new double[0];
        }
        if (delta == 0) {
            return new double[] { -b / (2 * a) };
        }
        return new double[] { getRoot1(), getRoot2() };
    }

    /** Mô tả kết quả bằng chữ để in ra màn hình. */
    public String describeSolution() {
        double delta = getDiscriminant();
        double[] roots = solve();
        if (roots.length == 0) {
            return "Delta = " + delta + " < 0: phương trình vô nghiệm (trong tập số thực)";
        }
        if (roots.length == 1) {
            return "Delta = 0: phương trình có nghiệm kép x = " + roots[0];
        }
        return "Delta = " + delta + " > 0: phương trình có 2 nghiệm phân biệt: x1 = " + roots[0] + ", x2 = " + roots[1];
    }
}
