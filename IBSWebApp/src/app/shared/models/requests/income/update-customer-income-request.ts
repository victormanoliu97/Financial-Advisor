export class UpdateCustomerIncomeRequest {
  idFinancialIncome: number;
  incomeAmount: number;
  incomeSource: string;
  compressibleCosts: number;
  nonCompressibleCosts: number;
  customerId: number;
}
