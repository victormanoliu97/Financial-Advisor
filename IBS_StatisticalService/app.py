from flask import Flask, request
import control.service.objectiveService as objectiveService

app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/predict-objective', methods=['POST'])
def predict_objective():
    data = request.get_json()
    objectiveService.insert_objective(data['customerId'], data['income'], data['objectiveName'], data['objectiveValue'], data['years'])

    return "Success"


if __name__ == '__main__':
    app.run()
