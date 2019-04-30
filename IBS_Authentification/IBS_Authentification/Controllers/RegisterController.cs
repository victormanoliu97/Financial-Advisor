using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.Service.Register;
using Microsoft.AspNetCore.Http.Headers;
using Microsoft.AspNetCore.Http.Internal;
using Microsoft.AspNetCore.Mvc;

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

        public void RegisterUser([FromBody] RegisterAccountRequest registerAccountRequest)
        {
            _registerService.RegisterUser(registerAccountRequest);
            
        }
    }
}