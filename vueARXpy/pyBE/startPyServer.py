# !/usr/bin/env python3
from http.server import HTTPServer, SimpleHTTPRequestHandler, test
import sys

class CORSRequestHandler (SimpleHTTPRequestHandler):
    def end_headers (self):
        self.send_header('Access-Control-Allow-Origin', '*')
        SimpleHTTPRequestHandler.end_headers(self)

if __name__ == '__main__':
    test(CORSRequestHandler, HTTPServer, port=int(sys.argv[1]) if len(sys.argv) > 1 else 8000)


# from http.server import  HTTPServer, SimpleHTTPRequestHandler

# def run(server_class=HTTPServer, handler_class=SimpleHTTPRequestHandler):
#     server_address = ('0.0.0.0', 8082)
#     httpd = server_class(server_address, handler_class)
#     httpd.serve_forever()
#     print("server is running at 8082 ....")
# if __name__ == '__main__':
#     run()
