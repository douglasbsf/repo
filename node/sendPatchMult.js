var request = require('request');

var options = {
    uri: 'http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/',
    method: 'PATCH',
    json: 
        {
          "objects": [
                {
                    "schedule_date": "1388657411",
                    "url": "/tv/api/tv/v1/channel/42/",
                    "message": "Agendamento realizado com sucesso! W",
                    "channel" : "51"
                },
                {
                    "schedule_date": "1388657412",
                    "url": "/tv/api/tv/v1/channel/42/",
                    "message": "Agendamento realizado com sucesso! Z",
                    "channel" : "51"
                },
                     ]
        }
    
    headers: {
        "api_key" : "e63ddefd649814b0d9af360e7bf4e1166fd2f231"
          } 

};

request(options, function (error, response, body) {
    if (!error && response.statusCode == 202) {
        console.dir(response) 
    }
});


