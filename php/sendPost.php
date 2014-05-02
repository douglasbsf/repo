<?php

$url = 'http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/';
$data  = array('schedule_date' => '1388657410', 'url' => '/tv/api/tv/v1/channel/42', 'message' => 'Agendamento realizado com sucesso!', 'channel' => '51');
$data_string = json_encode($data);   

$options = array(
        'http' => array(

            'header' => "Content-Type: application/json\r\n".
                        "api_key: e63ddefd649814b0d9af360e7bf4e1166fd2f231"."\r\n",
            'method'  => 'POST',
            'content' => $data_string,
    ),
);

$context  = stream_context_create($options);
$result = file_get_contents($url, false, $context);

var_dump($result);
var_dump($http_response_header);

?>

