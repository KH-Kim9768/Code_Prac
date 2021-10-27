using CoAP;
using CoAP.Server;
using CoAP.Server.Resources;

if (args.Length == 0 || args[0] != "S" && args[0] != "C")
{
    Console.Write(@"No command line arguments.
    S : Server
    C : Client
    ");
    return;
}

var cmd = args[0];

if ( cmd == "S" )
{
    var s = new CoapServer();
    s.Add(new HelloWorldResource());
    s.Start();

    Console.WriteLine("Press any key to exit...");
    Console.ReadLine();

}

else if (cmd == "C")
{
    var req = new Request(Method.GET);
    req.URI = new("coap://127.0.0.1/hello-world");
    req.Send();

    var res = req.WaitForResponse();
    Console.WriteLine($"Response : {res.ResponseText}");

    req = new Request(Method.GET);
    req.URI = new("coap://127.0.0.1/weather");
    req.Send();

    res = req.WaitForResponse();
    Console.WriteLine($"Response : {res.ResponseText}");
}

class HelloWorldResource : Resource
{
    public HelloWorldResource() : base("hello-world")
    {
        Attributes.Title = "Get friendly greeting!";

    }

    protected override void DoGet(CoapExchange exchange)
    {
        exchange.Respond("Hello World from CoAP.NET!");
    }
}
