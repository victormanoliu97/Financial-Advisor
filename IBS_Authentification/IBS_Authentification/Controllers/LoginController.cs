using System;
using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;
using IBS_Authentification_BusinessLayer.Service;
using Microsoft.AspNetCore.Mvc;

namespace IBS_Authentification.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly ILoginService _loginService;

        public LoginController(ILoginService loginService)
        {
            _loginService = loginService;
        }

        public string LoginUser([FromBody] LoginAccountRequest loginAccountRequest)
        {
            return _loginService.LoginUser(loginAccountRequest).ToString();
        }
    }
}