using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;

namespace IBS_Authentification_BusinessLayer.Service.Register
{
    public interface IRegisterService
    {
        RegisterRequestResponse RegisterUser(RegisterAccountRequest request);
    }
}