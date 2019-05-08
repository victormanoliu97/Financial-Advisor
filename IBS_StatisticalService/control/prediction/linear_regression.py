import pymysql.cursors
import pymysql
import json
import numpy as np
from sklearn.linear_model import LinearRegression

connection = pymysql.connect(
    host="localhost",
    user="root",
    password="victor",
    db="ibs_local_schema",
    charset="utf8mb4",
    cursorclass=pymysql.cursors.DictCursor
)


def getAllIncome():
    with connection.cursor() as cursor:
        querystring = "select income from `test_objective`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllObjValue():
    with connection.cursor() as cursor:
        querystring = "select obj_value from `test_objective`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllYears():
    with connection.cursor() as cursor:
        querystring = "select years from `test_objective`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllPossible():
    with connection.cursor() as cursor:
        querystring = "select possible from `test_objective`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def createX():
    incomes = []
    objValues = []
    years = []
    x = [[]]

    for i in getAllIncome():
        incomes.append(i["income"])

    for i in getAllObjValue():
        objValues.append(i["obj_value"])

    for i in getAllYears():
        years.append(i["years"])

    for i in range(0, len(incomes)):
        x.append([incomes[i], objValues[i], years[i]])

    for i in x:
        if not i:
            x.remove(i)

    return x


def createXPredict():
    x = [[], [100, 5000.0, 2], [200, 25000.0, 1], [300.0, 3600.0, 1], [100, 100, 1]]

    for i in x:
        if not i:
            x.remove(i)

    return x

def createY():
    y = []
    for i in getAllPossible():
        y.append(i["possible"])

    return y


def multiple_linear_regression():
    x = createX()
    y = createY()

    model = LinearRegression().fit(x, y)

    y_pred = model.predict(np.array(createXPredict()))

    result = []
    for i in y_pred:
        result.append(int(round(i)))

    return result


print(multiple_linear_regression())
