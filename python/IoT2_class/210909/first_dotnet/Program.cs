
for (var i = 2; i <= 9; i++)
{
    for (var j = 1; j<= 9; j++)
    {
        var message = $"{i} * {j} = {i*j}";
        Show(message);
    }
    Console.WriteLine();
}


void Show(string message)
{
    Console.WriteLine(message);
}

    
