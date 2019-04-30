using System;
using System.Net;
using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;
using IBS_Authentification_BusinessLayer.Service;
using IBS_Authentification_BusinessLayer.Service.Token;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace IBS_Authentification.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly ILoginService _loginService;
        private readonly TokenManager _tokenManager;

        public LoginController(ILoginService loginService, TokenManager tokenManager)
        {
            _loginService = loginService;
            _tokenManager = tokenManager;
        }

        public string LoginUser([FromBody] LoginAccountRequest loginAccountRequest)
        {
            var loginResponse = _loginService.LoginUser(loginAccountRequest);
            if (loginResponse.StatusCode == (int) HttpStatusCode.OK)
            {
                loginResponse.AccessToken = TokenManager.GenerateAccessToken(loginAccountRequest.Email);
            }
            return loginResponse.ToString();
        }
    }
}