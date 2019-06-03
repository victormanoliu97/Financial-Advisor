import numpy as np
from sklearn.linear_model import LinearRegression

import control.database.databaseManager as dm


def createXTestData():
    incomes = []
    objValues = []
    years = []
    x = [[]]

    for i in dm.getAllIncome():
        incomes.append(i["income"])

    for i in dm.getAllObjValue():
        objValues.append(i["objective_value"])

    for i in dm.getAllYears():
        years.append(i["years"])

    for i in range(0, len(incomes)):
        x.append([incomes[i], objValues[i], years[i]])

    for i in x:
        if not i:
            x.remove(i)

    return x


def createXPredict(income, objectiveValue, years):
    x = [[]]

    x1 = [income, objectiveValue, years]
    x.append(x1)

    for i in x:
        if not i:
            x.remove(i)

    return x


def createYTestData():
    y = []
    for i in dm.getAllPossible():
        y.append(i["possible"])

    return y


def multiple_linear_regression(income, objectiveValue, years):
    x = createXTestData()
    y = createYTestData()

    model = LinearRegression().fit(x, y)

    y_pred = model.predict(np.array(createXPredict(income, objectiveValue, years)))

    result = []
    for i in y_pred:
        result.append(int(round(i)))

    return result


