import pymysql.cursors
import pymysql
import json

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
        querystring = "select income from `t_ibs_customer_financial_objectives`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllObjValue():
    with connection.cursor() as cursor:
        querystring = "select objective_value from `t_ibs_customer_financial_objectives`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllYears():
    with connection.cursor() as cursor:
        querystring = "select years from `t_ibs_customer_financial_objectives`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def getAllPossible():
    with connection.cursor() as cursor:
        querystring = "select possible from `t_ibs_customer_financial_objectives`"
        cursor.execute(querystring)
        result = cursor.fetchall()
        return result


def insertObjective(customerId, income, objectiveName, objectiveValue, years, possible):
    with connection.cursor() as cursor:
        querystring = "insert into `t_ibs_customer_financial_objectives`(`id_customer`, `income`, `objective_name`, `objective_value`, `years`, `possible`)" \
                      " values(%s, %s, %s, %s, %s, %s)"
        cursor.execute(querystring, (customerId, income, objectiveName, objectiveValue, years, possible))
        connection.commit()

