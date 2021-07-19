using System;
using static System.Console;
using System.Collections;

namespace Chapter4_prac
{
    class MainApp
    {
        static void Main(string[] args)
        {
            /*
            WriteLine(3 + 4);
            WriteLine(3 - 4);
            WriteLine(3 / 4);
            WriteLine(3 * 4);
            WriteLine(30 % 4);
            */


            /*
            int a = 111 + 222;
            WriteLine($"a : {a}");

            int b = a - 100;
            WriteLine($"b : {b}");

            int c = b * 10;
            WriteLine($"c : {c}");

            double d = c / 6.3;
            WriteLine($"d : {d}");

            WriteLine($"22/7 = {22 / 7}({22 % 7})");
            */

            /*
            int a = 10;
            a++;
            a--;

            a = 10;
            WriteLine(a++);
            WriteLine(++a);

            a = 10;
            WriteLine(a--);
            WriteLine(--a);
            */

            /*
            string result = "123" + "456";
            WriteLine(result);

            result = "Hello" + " " + "World";
            WriteLine(result);
            */

            /*
            int ab = 30;
            string result = ab == 30 ? "삼십" : "삼십아님";

            WriteLine(result);
            */

            /*
            string result = (10 % 2) == 0 ? "짝수" : "홀수";
            WriteLine(result);
            */

            ArrayList a = null;
            a?.Add("야구");   // a?. 가 null을 반환하므로 Add() 메소드는 호출되지 않음
            a?.Add("축구");
            WriteLine($"Count : {a?.Count}");
            WriteLine($"{a?[0]}");
            WriteLine($"{a?[1]}");

            a = new ArrayList();
            a?.Add("야구");
            a?.Add("축구");
            WriteLine($"Count : {a?.Count}");
            WriteLine($"{a?[0]}");
            WriteLine($"{a?[1]}");


        
        }
    }
}
