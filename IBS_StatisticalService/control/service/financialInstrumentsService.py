import json
import urllib

stocksEndPoint = 'https://api.worldtradingdata.com/api/v1/stock?symbol=AAPL,BA,BAC,MSFT,HSBA.L&api_token=A9MONJTapVY8IzSS3c5XMdBvaMEEhvd0AJdYnCJQdXlinTHzl6j2mlmf7OEt'
forexEndPoint = 'https://api.worldtradingdata.com/api/v1/forex?base=RON&api_token=A9MONJTapVY8IzSS3c5XMdBvaMEEhvd0AJdYnCJQdXlinTHzl6j2mlmf7OEt'

def returnStocks():
    response = json.loads(urllib.request.urlopen(stocksEndPoint).read().decode("utf-8"))
    return response['data']

def returnForex():
    response = json.loads(urllib.request.urlopen(forexEndPoint).read().decode("utf-8"))
    result = [response['data']]
    return result
