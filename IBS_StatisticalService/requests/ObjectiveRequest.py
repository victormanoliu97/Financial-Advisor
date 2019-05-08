class ObjectiveRequest:
    def __init__(self, objectiveType, objectiveDescription, objectiveValue, objectiveYears, customerIncomes, customerLiabilities):
        self.objectiveType = objectiveType
        self.objectiveDescription = objectiveDescription
        self.objectiveValue = objectiveValue
        self.objectiveYears = objectiveYears
        self.customerIncomes = customerIncomes
        self.customerLiabilities = customerLiabilities

    def __str__(self):
        result = {"type":  self.objectiveType, "description": self.objectiveDescription, "value": self.objectiveValue,
                  "income": self.customerIncomes, "liabilities": self.customerLiabilities}
        return result

