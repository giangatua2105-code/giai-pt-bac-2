package com.codegym;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Giải phương trình bậc 2: a*x^2 + b*x + c = 0 (dùng thư viện quadratic-lib.jar)");

        double a, b, c;
        if (args.length == 3) {
            // Chạy với tham số: java ... com.codegym.Main 1 -3 2
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        } else {
            Scanner scanner = new Scanner(System.in);
            scanner.useLocale(Locale.US); // nhập số thập phân bằng dấu chấm, ví dụ 1.5
            System.out.print("Nhập a: ");
            a = scanner.nextDouble();
            System.out.print("Nhập b: ");
            b = scanner.nextDouble();
            System.out.print("Nhập c: ");
            c = scanner.nextDouble();
        }

        try {
            QuadraticEquation equation = new QuadraticEquation(a, b, c);
            System.out.println("Phương trình: " + a + "x^2 + " + b + "x + " + c + " = 0");
            System.out.println(equation.describeSolution());
        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
