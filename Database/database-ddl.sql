CREATE TABLE T_IBS_APP_ACCOUNTS(
  id_app_account int(10) auto_increment primary key,
  email varchar(10) not null,
  password varchar(10) not null
);


CREATE TABLE T_IBS_CUSTOMERS(
    id_customer int(10) auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    cnp varchar(20) not null,
    birth_date datetime(6) not null,
    age int(3) not null,
    street varchar(30) not null,
    city varchar(30) not null,
    country varchar(30) not null
);


CREATE TABLE T_IBS_JOIN_CUSTOMERS_APP_ACCOUNTS(
  id_app_account int(10) not null,
  id_customer int(10) not null
);


-- Here we store all the information about the current banks
CREATE TABLE T_IBS_BANK_INFORMATION(
  id_bank int(10) auto_increment primary key,
  bank_name varchar(30) not null,
  administrative_commission double not null,
  lending_rate double not null
);

-- Here we store all the information about the bank accounts of a customer
CREATE TABLE T_IBS_CUSTOMERS_BANK_ACCOUNTS(
  id_account int(10) auto_increment primary key,
  iban varchar(30) not null,
  id_customer int(10) not null,
  id_bank int(10) not null,
  account_type VARCHAR(10) not null,
  current_sold int(20) not null,
  loan_amount int(20) not null,
  FOREIGN KEY (id_customer) REFERENCES T_IBS_CUSTOMERS(id_customer),
  FOREIGN KEY (id_bank) REFERENCES T_IBS_BANK_INFORMATION(id_bank)
);

-- Here we store all the incomes of a customer and their compressible and non-compressible costs
CREATE TABLE T_IBS_CUSTOMERS_CUSTOMER_FINANCIAL_INCOME(
  id_financial_income int(10) auto_increment primary key,
  id_customer int(10) not null,
  income_amount double not null,
  income_source varchar(20),
  compressible_costs double,
  non_compressible_costs double,
  FOREIGN KEY (id_customer) REFERENCES  T_IBS_CUSTOMERS(id_customer)
);

-- Here we store all the liabilities of a customer
CREATE TABLE T_IBS_CUSTOMERS_CUSTOMER_FINANCIAL_LIABILITIES(
  id_financial_liability int(10) auto_increment primary key,
  id_customer int(10) not null,
  liabilities_amount double not null,
  liabilities_source varchar(20),
  FOREIGN KEY (id_customer) REFERENCES  T_IBS_CUSTOMERS(id_customer)
);

-- Here we store all the estates of a customer
CREATE TABLE T_IBS_CUSTOMERS_CUSTOMER_FINANCIAL_ESTATES(
  id_estate int(10) auto_increment primary key,
  id_customer int(10) not null,
  estate_name varchar(20) not null,
  estate_description varchar(20),
  estate_type varchar(20) not null,
  estate_value double not null,
  FOREIGN KEY (id_customer) REFERENCES  T_IBS_CUSTOMERS(id_customer)
);

-- Here we store all the companies of a customer
CREATE TABLE T_IBS_CUSTOMERS_CUSTOMER_FINANCIAL_COMPANIES(
  id_company int(10) auto_increment primary key,
  id_customer int(10) not null,
  company_name varchar(20) not null,
  company_description varchar(20),
  company_type varchar(20),
  company_revenue double not null,
  FOREIGN KEY (id_customer) REFERENCES  T_IBS_CUSTOMERS(id_customer)
);