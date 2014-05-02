var request = require('request');

var options = {
    uri: 'http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/24/',
    method: 'PATCH',
    json: {
        "message": "Agendamento realizado com sucesso YY !"
          }, 
    headers: {
        "api_key" : "e63ddefd649814b0d9af360e7bf4e1166fd2f231"
          } 

};

request(options, function (error, response, body) {
    if (!error && response.statusCode == 202) {
        console.dir(response) 
    }
});


