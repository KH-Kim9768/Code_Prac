using System;

namespace Constant
{
    class MainApp
    {
        enum DialogResult { YES = 10, NO = 20, CANCEL, CONFIRM, OK = 30 }

        static void Main(string[] args)
        {
            /*
            const int MAX_INT = 2147483647;
            const int MIN_INT = -2147483648;

            Console.Write(MAX_INT);
            Console.Write(MIN_INT);
            */

            DialogResult result = DialogResult.YES;


            Console.WriteLine((int)DialogResult.YES);
            Console.WriteLine((int)DialogResult.NO);
            Console.WriteLine((int)DialogResult.CANCEL);
            Console.WriteLine((int)DialogResult.CONFIRM);
            Console.WriteLine((int)DialogResult.OK);
            Console.WriteLine(result);


        }
    }
}
