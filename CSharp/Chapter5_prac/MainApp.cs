using System;
using static System.Console;
namespace Chapter5_prac
{
    class MainApp
    {
        static void Main(string[] args)
        {

            int number = 1;

            object obj = 123;

            switch (obj) // C# 7.0 부터는 switch문에 데이터형을 조건으로 사용할 수 있게 되었다.
            {
                case int i:
                    WriteLine("int 형입니다");
                    break;

                case float f:
                    WriteLine("float 형입니다");
                    break;
            }

            /*
            switch (number)
            {
                case 1:
                    WriteLine("하나");              
                    break;

                case 2:
                    WriteLine("둘");
                    break;

                case 3:
                    WriteLine("셋");
                    break;

                case 4:
                    WriteLine("넷");
                    break;

                case 5:
                    WriteLine("다섯");
                    break;
            }
            */
            /*
            Write("숫자를 입력하세요 : ");

            string input = ReadLine();
            int number = Int32.Parse(input);

            if (number < 0)
            {
                WriteLine("음수");
                
            } else if (number > 0)
            {
                WriteLine("양수");

            } else
            {
                WriteLine(0);

            }

            if (number % 2 == 0)
            {
                WriteLine("짝수");

            }
            else
            {
                WriteLine("홀수");

            }
            */
        }
    }
}
