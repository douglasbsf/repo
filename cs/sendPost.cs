using System;
using System.Drawing;
using MonoMac.Foundation;
using MonoMac.AppKit;
using MonoMac.ObjCRuntime;
using System.IO;
using System.Net;
using System.Text;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;


namespace WpfTestApplication
{
    public class WebRequestPostExample
    {
        public class Data
        {
            public string schedule_date { get; set; }
            public string url { get; set; }
            public string message { get; set; }
            public string channel { get; set; }
        }

        public static void Main ()
        {
            string URI = "http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/";
            var httpWebRequest = (HttpWebRequest)WebRequest.Create(URI);
            httpWebRequest.ContentType = "application/json";
            httpWebRequest.Method = "POST";
            httpWebRequest.Headers.Set ("api_key", "e63ddefd649814b0d9af360e7bf4e1166fd2f231");
            httpWebRequest.Accept = "*/*";
            httpWebRequest.Expect = "";

            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                var data = new Data { schedule_date = "1388657410", url = "/tv/api/tv/v1/channel/42/",
                    message = "Agendamento realizado com sucesso!", channel = "51" };
                var json = JsonConvert.SerializeObject (data);
                streamWriter.Write(json);
                streamWriter.Close ();

                var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
                if (httpResponse.StatusCode == HttpStatusCode.Created) {
                    Console.WriteLine ("Registro criado com sucesso!");
                }
                using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
                {
                    Console.WriteLine (streamReader.ReadToEnd());
                }

            }
                
        }

    }

}
    
