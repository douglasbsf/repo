require 'net/http'
require 'uri'
require 'json'

uri = URI.parse("http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/")

header = {'Content-Type' => 'application/json', 'api_key' => 'e63ddefd649814b0d9af360e7bf4e1166fd2f231'}
data = {
            'schedule_date' => '1388657410', 
            'url' => '/tv/api/tv/v1/channel/42',
            'message' => 'Agendamento realizado com sucesso!',
            'channel' => '51'
               
        }

http = Net::HTTP.new(uri.host, uri.port)
request = Net::HTTP::Post.new(uri.request_uri, header)
request.body = data.to_json

response = http.request(request)
if response.code == '201'
    puts 'Registro criado com sucesso!'
    puts response.to_hash
end
