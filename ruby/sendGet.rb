require 'net/http'
require 'uri'
require 'json'

uri = URI.parse("http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/")

header = {'Content-Type' => 'application/json', 'api_key' => 'e63ddefd649814b0d9af360e7bf4e1166fd2f231'}

http = Net::HTTP.new(uri.host, uri.port)
request = Net::HTTP::Get.new(uri.request_uri, header)

response = http.request(request)
if response.code == '200'
    puts response.body
end
