using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace IBS_Authentification_DataLayer.AppAccountData
{
    public class AppAccount
    {
        [Key]
        public int Id_App_Account { get; set; }
        public String Email { get; set; }
        public String Password { get; set; }
    }
}
