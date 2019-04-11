using System;
using System.Collections.Generic;
using System.Text;
using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;

namespace IBS_Authentification_BusinessLayer.Repository
{
    public interface IAuthRepository
    {
        bool CustomerAccountExists(string email, string password);
        LoginRequestResponse CreateLoginResponse(string email, string password, int statusCode);

        bool UserAlreadyExists(string email);
        
        void RegisterAccount(RegisterAccountRequest request);
    }
}
