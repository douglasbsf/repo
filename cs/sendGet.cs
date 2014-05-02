using System;
using System.Drawing;
using MonoMac.Foundation;
using MonoMac.AppKit;
using MonoMac.ObjCRuntime;
using System.IO;
using System.Net;
using System.Text;

namespace WpfTestApplication
{
    public class WebRequestPostExample
    {
        public static void Main ()
        {
            string URI = "http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/";
            Console.WriteLine ("http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/");
            System.Net.WebRequest req = System.Net.WebRequest.Create(URI);
            req.Headers.Set ("api_key", "e63ddefd649814b0d9af360e7bf4e1166fd2f231");
            System.Net.WebResponse resp = req.GetResponse();
            System.IO.StreamReader sr = new System.IO.StreamReader(resp.GetResponseStream());
            Console.WriteLine(sr.ReadToEnd().Trim());
        }
    }
}
