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
