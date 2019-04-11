using System;
using System.Collections.Generic;
using System.Text;

namespace IBS_Authentification_BusinessLayer.AuthRequests
{
    public class RegisterAccountRequest
    {
        public String Email { get; set; }
        public string Password { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Cnp { get; set; }
        public DateTime BirthDate { get; set; }
        public int Age { get; set; }
        
        public String Street { get; set; }
        
        public string City { get; set; }
        public string Country { get; set; }
    }
}
