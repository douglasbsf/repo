var request = require('request');

var options = {
    uri: 'http://10.1.1.90/tv/device/tvod_list/',
    method: 'GET',
    headers: {
        "API-KEY" : "df4df757327fcfd94abf51887bd22b86581a8680",
          } 

};

request(options, function (error, response, body) {
    console.dir(response) 
    if (!error && response.statusCode == 200) {
        console.dir(response) 
    }
});


