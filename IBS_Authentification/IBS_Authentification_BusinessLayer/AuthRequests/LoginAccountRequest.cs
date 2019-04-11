using System;
using System.Collections.Generic;
using System.Text;

namespace IBS_Authentification_BusinessLayer.AuthRequests
{
    public class LoginAccountRequest
    {
        public LoginAccountRequest(string email, string password)
        {
            Email = email;
            Password = password;
        }

        public string Email { get; set; }
        public string Password { get; set; }
    }
}
