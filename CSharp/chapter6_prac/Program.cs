using System;

namespace chapter6_prac
{
    class Product
    {
        private int price = 100;

        public ref int getPrice()
        {
            return ref price;
        }

        public void printPrice()
        {
            Console.WriteLine($"Price : {price}");
        }
    }

    class Program
    {

        static int Fibonacci(int i)
        {
            if (i < 2)
                return i;
            else
                return Fibonacci(i - 1) + Fibonacci(i- 2);
        }

        static void PrintProfile(string name, string phone)
        {
            if (name == "")
            {
                Console.WriteLine("이름을 입력해주세요.");
                return;
            }

            Console.WriteLine($"Name : {name}, Phone:{phone}");

        }

        static ref int GetPrice()
        {
            int price = 5000;
            return ref GetPrice();
        }

        static void Swap(ref int a, ref int b)
        {
            int temp = b;
            b = a;
            a = temp;
        }
        /*
        static void Divide(int a, int b, ref int quotient, ref int remainder)
        {
            quotient = a / b;
            remainder = a % b;
        }
        */

        static int Plus(int a, int b)
        {
            return a + b;
        }

        static double Plus(double a, double b)
        {
            return a + b;
        }

        static int sum(params int[] args)
        {
            int sum = 0;
            for(int i = 0; i < args.Length; i++)
            {
                sum += args[i];
            }

            return sum;
        }


        static void Divide(int a, int b, out int quotient, out int remainder)
        {
            quotient = a / b;
            remainder = a % b;
        }

        static string ToLowerString(string input)
        {
            var arr = input.ToCharArray();
            for(int i = 0; i < arr.Length; i++)
            {
                arr[i] = ToLowerChar(i);
            }

            char ToLowerChar(int i)
            {
                if (arr[i] < 65 || arr[i] > 90) return arr[i];
                else return (char)(arr[i] + 32);
            }

            return new string(arr);
        }

        static void Main(string[] args)
        {
            /*
            Console.WriteLine($"10번째 피보나치 수 : {Fibonacci(10)}");

            PrintProfile("", "123-4567");
            PrintProfile("박상현", "456-1230");
            */
            /*
            int x = 3;
            int y = 4;

            Console.WriteLine($"x:{x}, y:{y}");

            Swap(ref x, ref y);

            Console.WriteLine($"x:{x}, y:{y}");

            Product prd = new Product();

            ref int ref_local_price = ref prd.getPrice();

            int normal_local_price = prd.getPrice();

            prd.printPrice();
            Console.WriteLine($"Ref Local Price : {ref_local_price}");
            Console.WriteLine($"Normal Local Price : {normal_local_price}");

            ref_local_price = 200;

            prd.printPrice();
            Console.WriteLine($"Ref Local Price : {ref_local_price}");
            Console.WriteLine($"Normal Local Price : {normal_local_price}");
            */

            int a = 20;
            int b = 3;
            /*
            int c = 0;
            int d = 0;
            */


            Divide(a, b, out int c, out int d);
            Console.WriteLine("몫 : {0}, 나머지 : {1}", c, d);

            Console.WriteLine("1,2,3,4 : {0}", sum(1, 2, 3, 4));
            Console.WriteLine("1,2,3,4,5,6,7 : {0}", sum(1, 2, 3, 4, 5, 6, 7));

            Console.WriteLine(ToLowerString("Hello!"));
            Console.WriteLine(ToLowerString("Good Morning~"));
            Console.WriteLine(ToLowerString("This is C#"));
        }
    }
}
