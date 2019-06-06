using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.Service.Register;
using Microsoft.AspNetCore.Http.Headers;
using Microsoft.AspNetCore.Http.Internal;
using Microsoft.AspNetCore.Mvc;
using Raven.Client;
using System;
using System.Linq;
using IBS_Authentification_BusinessLayer.AuthResponses;

namespace IBS_Authentification.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class RegisterController
    {
        private readonly IRegisterService _registerService;

        public RegisterController(IRegisterService registerService)
        {
            _registerService = registerService;
        }

        [HttpPost]
        public RegisterRequestResponse Register([FromBody] RegisterAccountRequest registerAccountRequest)
        {
            return _registerService.RegisterUser(registerAccountRequest);

        }
    }
}