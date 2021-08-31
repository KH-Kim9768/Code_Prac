using System;

namespace Chapter7_prac
{
    class Cat
    {
        public string Name;
        public string color;
        
        public Cat()
        {
            Name = "";
            color = "";
        }

        public Cat(string Name, string color)
        {
            this.Name = Name;
            this.color = color;
        }

        ~Cat()
        {   
            // 종료자

            Console.WriteLine($"{Name} 고양이 종료");
        }

        public void Meow()
        {
            Console.WriteLine($"{Name} : 야옹");
        }
    }

    class MyClass
    {
        public int num1;
        public int num2;

        public MyClass DeepCopy()
        {
            MyClass myClass = new MyClass();
            myClass.num1 = this.num1;
            myClass.num2 = this.num2;

            return myClass;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Cat cat1 = new Cat();
            Cat cat2 = new Cat("야옹이", "하얀색");

            cat1.Name = "네로";
            cat1.color = "검정색";

            cat1.Meow();
            cat2.Meow();

            MyClass my1 = new MyClass();
            my1.num1 = 10;
            my1.num2 = 20;

            Console.WriteLine("{0}, {1}", my1.num1, my1.num2);

            MyClass my2 = my1;
            my2.num1 = 20;
            my2.num2 = 10;
            Console.WriteLine("{0}, {1}", my1.num1, my1.num2);
            Console.WriteLine("{0}, {1}", my2.num1, my2.num2);

            MyClass my3 = my1.DeepCopy();
            my3.num1 = 35;
            my3.num2 = 50;
            Console.WriteLine("{0}, {1}", my1.num1, my1.num2);
            Console.WriteLine("{0}, {1}", my2.num1, my2.num2);
            Console.WriteLine("{0}, {1}", my3.num1, my3.num2);
            Console.WriteLine("{0}, {1}", my1.num1, my1.num2);



        }
    }
}
