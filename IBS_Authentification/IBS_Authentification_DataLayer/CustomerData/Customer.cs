using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace IBS_Authentification_DataLayer.CustomerData
{
    public class Customer
    {
        [Key]
        public int Id_Customer { get; set; }
        public String First_Name { get; set; }
        public String Last_Name { get; set; }
        public String CNP { get; set; }
        public int Age { get; set; }
    }
}
