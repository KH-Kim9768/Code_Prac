using System;
using static System.Console;

namespace IntegralTypes
{
    class MainApp
    {
        static void Main(string[] args)
        {
            /*
            sbyte a = -10;
            byte b = 40;

            WriteLine($"a = {a}, b = {b}");

            short c = -30000;
            ushort d = 60000;

            WriteLine($"c = {c}, d = {d}");

            int e = -1000_0000;
            uint f = 3_0000_0000;

            WriteLine($"e = {e}, f = {f}");

            long g = -5000_00000_0000;
            ulong h = 200_0000_0000_0000_0000;

            WriteLine($"g = {g}, h = {h}");
            */

            byte a = 240;           // 10진수 리터럴
            WriteLine($"a = {a}");

            byte b = 0b1111_0000;   // 2진수 리터럴
            WriteLine($"b = {b}");

            byte c = 0XF0;          // 16진수 리터럴
            WriteLine($"c = {c}");

            uint d = 0x1234_abcd;   // 16진수 리터럴
            WriteLine($"d = {d}");



        }
    }
}
