using System.Linq;
using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;
using IBS_Authentification_DataLayer.AppAccountData;
using IBS_Authentification_DataLayer.CustomerData;
using IBS_Authentification_DataLayer.JoinCustomerAccountsData;
using IBS_Authentification_DataLayer.Management;
using Microsoft.EntityFrameworkCore;

namespace IBS_Authentification_BusinessLayer.Repository
{
    public class AuthRepository : IAuthRepository
    {
        private readonly AppDbContext _appDbContext;

        public AuthRepository(AppDbContext appDbContext)
        {
            _appDbContext = appDbContext;
        }

        public bool CustomerAccountExists(string email, string password)
        {
            if (email == null && password == null) return false;
            var foundCustomer = _appDbContext.T_IBS_App_Accounts.FirstOrDefault(e => e.Email == email && e.Password == password);
            if (foundCustomer == null)
            {
                return false;
            }
            return true;
        }

        public LoginRequestResponse CreateLoginResponse(string email, string password, int statusCode)
        {
            var loginResponse = new LoginRequestResponse();
            loginResponse.StatusCode = statusCode;
            var foundAccount = _appDbContext.T_IBS_App_Accounts.FirstOrDefault(e => e.Email == email && e.Password == password);
            if (foundAccount != null)
            {
                var foundCustomerJoinAccount =
                    _appDbContext.T_IBS_Join_Customers_App_Accounts.FirstOrDefault(id =>
                        id.Id_App_Account == foundAccount.Id_App_Account);
                var foundCustomer =
                    _appDbContext.T_IBS_CUSTOMERS.FirstOrDefault(id =>
                        id.Id_Customer == foundCustomerJoinAccount.Id_Customer);

                loginResponse.CustomerId = foundCustomer.Id_Customer;
                loginResponse.FirstName = foundCustomer.First_Name;
                loginResponse.LastName = foundCustomer.Last_Name;
                loginResponse.CNP = foundCustomer.CNP;
                loginResponse.BirthDate = foundCustomer.Birth_Date;
                loginResponse.Age = foundCustomer.Age;
                loginResponse.Street = foundCustomer.Street;
                loginResponse.City = foundCustomer.City;
                loginResponse.Country = foundCustomer.City;
            }

            return loginResponse;
        }

        public bool UserAlreadyExists(string email)
        {
            var found = _appDbContext.T_IBS_App_Accounts.FirstOrDefault(e => e.Email == email);
            if (found == null) return false;
            return true;
        }

        public void RegisterAccount(RegisterAccountRequest request)
        {
            if (request == null) return;
            
            var accountToAdd = new AppAccount();
            accountToAdd.Email = request.Email;
            accountToAdd.Password = request.Password;
            _appDbContext.T_IBS_App_Accounts.Add(accountToAdd);
            _appDbContext.SaveChanges();
            
            var customerToAdd = new Customer();
            customerToAdd.First_Name = request.FirstName;
            customerToAdd.Last_Name = request.LastName;
            customerToAdd.CNP = request.Cnp;
            customerToAdd.Birth_Date = request.BirthDate;
            customerToAdd.Age = request.Age;
            customerToAdd.Street = request.Street;
            customerToAdd.City = request.City;
            customerToAdd.Country = request.Country;
            _appDbContext.T_IBS_CUSTOMERS.Add(customerToAdd);
            _appDbContext.SaveChanges();

            var justAddedCustomer = from o in _appDbContext.T_IBS_CUSTOMERS
                select o.Id_Customer;

            var justAddedAcc = from o in _appDbContext.T_IBS_App_Accounts
                select o.Id_App_Account;
            
            var jointAccount = new JoinCustomerAppAccounts();
            jointAccount.Id_Customer = justAddedCustomer.ToList().Max();
            jointAccount.Id_App_Account = justAddedAcc.ToList().Max();
            _appDbContext.T_IBS_Join_Customers_App_Accounts.Add(jointAccount);
            _appDbContext.SaveChanges();
        }
    }
}
