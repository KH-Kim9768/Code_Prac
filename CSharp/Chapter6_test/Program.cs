using System;

namespace chapter6_test
{
    class MainApp
    {   
        static double Square(double arg)
        {
            /*
             * 매개변수를 제곱하여 반환
             */

            return arg * arg;
        }

        static void Mean(out double mean, params double[] args)
        {
            double sum = 0;
            for (int i = 0; i < args.Length; i++)
            {
                sum += args[i];
            }

            mean = sum / args.Length;
        }

        public static void Plus(int a, int b, out int c)
        {
            c = a + b;

        }

        public static void Plus(double a, double b, out double c)
        {
            c = a + b;
        }

        static void Main(string[] args)
        {
            /*
            Console.Write("숫자를 입력하세요 : ");
            string input = Console.ReadLine();
            double arg = Convert.ToDouble(input);

            Console.WriteLine(Square(arg));
            */

            double mean = 0;
            Mean(out mean, 1123, 123, 32, 212, 2);
            Console.WriteLine(mean);

            int a = 3;
            int b = 4;
            int resultA = 0;

            Plus(a, b, out resultA);

            Console.WriteLine("{0} + {1} = {2}", a, b, resultA);

            double x = 2.4;
            double y = 3.1;
            double resultB = 0;

            Plus(x, y, out resultB);

            Console.WriteLine("{0} + {1} = {2}", x, y, resultB);


        }
    }
}
