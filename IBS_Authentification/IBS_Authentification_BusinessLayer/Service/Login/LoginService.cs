using System.Net;
using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;
using IBS_Authentification_BusinessLayer.Repository;

namespace IBS_Authentification_BusinessLayer.Service
{
    public class LoginService : ILoginService
    {
        private readonly AuthRepository _authRepository;

        public LoginService(AuthRepository authRepository)
        {
            _authRepository = authRepository;
        }

        public LoginRequestResponse LoginUser(LoginAccountRequest loginAccountRequest)
        {
            LoginRequestResponse loginRequestResponse = new LoginRequestResponse();
            if (_authRepository.CustomerAccountExists(loginAccountRequest.Email, loginAccountRequest.Password))
            {
                loginRequestResponse = CreateLoginResponse(loginAccountRequest, (int) HttpStatusCode.OK);
            }
            else
            {
                loginRequestResponse = CreateLoginResponse(loginAccountRequest, (int) HttpStatusCode.NotFound);
            }
            return loginRequestResponse;
        }

        public LoginRequestResponse CreateLoginResponse(LoginAccountRequest loginAccountRequest, int statusCode)
        {
            return _authRepository.CreateLoginResponse(loginAccountRequest.Email, loginAccountRequest.Password, statusCode);
        }
    }
}