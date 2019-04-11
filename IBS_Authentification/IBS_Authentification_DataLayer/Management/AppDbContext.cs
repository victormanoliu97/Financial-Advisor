using IBS_Authentification_DataLayer.AppAccountData;
using IBS_Authentification_DataLayer.CustomerData;
using IBS_Authentification_DataLayer.JoinCustomerAccountsData;
using Microsoft.EntityFrameworkCore;

namespace IBS_Authentification_DataLayer.Management
{
    public class AppDbContext : DbContext
    {
        public DbSet<AppAccount> T_IBS_App_Accounts { get; set; }
        public DbSet<Customer> T_IBS_CUSTOMERS { get; set; }
        public DbSet<JoinCustomerAppAccounts> T_IBS_Join_Customers_App_Accounts { get; set; }

        public AppDbContext(DbContextOptions options) : base(options)
        {
            Database.EnsureCreated();
        }
    }
}