<?php

//$url = 'http://10.1.1.90/tv/device/tvod_list/';
$url = 'http://179.96.131.169/tv/device/tvod_list/';
$options = array(
        'http' => array(

            'header' => "Content-Type: application/json\r\n".
            "API-KEY: fb026adfd8436dcc6126af01ded5d61550c983f3\r\n".
            "MAC: 00:00:00:00:00:00\r\n",
            'method'  => 'GET',
            'Content-Type' => 'application/json, application/x-www-form-urlencoded',
            'Accept' =>  '*/*'
    ),
);

$context  = stream_context_create($options);
$result = file_get_contents($url, false, $context);

var_dump($result);
var_dump($http_response_header);

?>

