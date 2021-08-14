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

        static void Main(string[] args)
        {
            /*
            Console.WriteLine($"10번째 피보나치 수 : {Fibonacci(10)}");

            PrintProfile("", "123-4567");
            PrintProfile("박상현", "456-1230");
            */

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

        }
    }
}
