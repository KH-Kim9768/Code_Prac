using System;
using static System.Console;
namespace Chapter5_prac
{
    class MainApp
    {
        static void Main(string[] args)
        {

            for (int i = 1; i < 6; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    Write("*");
                }
                WriteLine("");
            }

            for(int i = 5; i > 0; i--)
            {
                for(int j = 0; j < i; j++)
                {
                    Write("*");

                }
                WriteLine();
            }

            WriteLine();
            int number = 0;
            while (true)
            {
                Write("반복 횟수를 입력하세요 : ");
                try
                {
                   number = Convert.ToInt32(ReadLine());
                }
                catch
                {
                    WriteLine("숫자를 입력해주세요");
                    continue;
                }
                
                if (number <= 0)
                {
                    WriteLine("0보다 작거나 같은 수는 입력할 수 없습니다.");
                    continue;
                }

                for (int i = 0; i < number; i++)
                {
                    for (int j = 0; j < i+1; j++)
                    {
                        Write("*");
                    }
                    WriteLine();
                }
            }
            
            /*
            WriteLine("점수를 입력하세요 : ");
            int score = Convert.ToInt32(ReadLine());

            WriteLine("재수강 입니까? : ");
            string line = ReadLine();
            bool repeated = line == "y" ? true : false;

            string grade = (int)(Math.Truncate(score / 10.0) * 10) switch
            {
                90 when repeated == true => "B+",
                90 => "A",
                80 => "B",
                70 => "C",
                60 => "D",
                _ => "F"
            };

            
            WriteLine($"학점 : {grade}");

            */
            /*
            object obj = null;

            string s = ReadLine();

            
            // TryParse() 함수는 Parse() 함수와 달리 변환 성공 여부를 반환한다.
             
            if (int.TryParse(s, out int out_i))
                obj = out_i;

            else if (float.TryParse(s, out float out_f))
                obj = out_f;

            else
                obj = s;

            switch (obj)
            {
                case int i:
                    WriteLine("int 형 입니다");
                    break;

                case float f:
                    WriteLine("float 형 입니다");
                    break;

                default:
                    WriteLine("String 형 입니다");
                    break;
            }
            */
            /*
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
            */
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
