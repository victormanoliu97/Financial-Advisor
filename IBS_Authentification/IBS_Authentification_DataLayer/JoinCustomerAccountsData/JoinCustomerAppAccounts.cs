using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace IBS_Authentification_DataLayer.JoinCustomerAccountsData
{
    public class JoinCustomerAppAccounts
    {
        [Key]
        public int Id { get; set; }
        public int Id_App_Account { get; set; }
        public int Id_Customer { get; set; }
    }
}
