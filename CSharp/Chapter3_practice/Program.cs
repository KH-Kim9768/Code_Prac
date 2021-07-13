using System;

namespace Chapter3_practice
{
    class Program
    {
        static void Main(string[] args)
        {
            // 사각형의 넓이 구하기
            Console.WriteLine("사각형의 가로 : ");
            int width = int.Parse(Console.ReadLine());

            Console.WriteLine("사각형의 세로 : ");
            int height = int.Parse(Console.ReadLine());

            int area = width * height;

            Console.WriteLine("사각형의 넓이 : {0}", area);


        }
    }
}
