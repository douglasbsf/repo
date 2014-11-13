var request = require('request');

var options = {
    uri: 'http://10.1.1.90:8000/tv/api/client/v1/settopboxprogramschedule/',
    method: 'POST',
    json: {
        "schedule_date": "1388657410",
        "url": "/tv/api/tv/v1/channel/42/",
        "message": "Agendamento realizado com sucesso!",
        "channel" : "51"
          }, 
    headers: {
        "api_key" : "e63ddefd649814b0d9af360e7bf4e1166fd2f231"
          } 

};

request(options, function (error, response, body) {
    console.dir(response) 
    if (!error && response.statusCode == 201) {
        console.dir(response) 
    }
});


