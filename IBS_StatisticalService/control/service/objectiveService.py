import control.prediction.linear_regression as linear_regression
import control.database.databaseManager as databaseManager


def insert_objective(customerId, income, objectiveName, objectiveValue, years):
    possible = linear_regression.multiple_linear_regression(income, objectiveValue, years)
    databaseManager.insertObjective(customerId, income, objectiveName, objectiveValue, years, possible)