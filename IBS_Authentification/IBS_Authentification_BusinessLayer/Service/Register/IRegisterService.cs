using IBS_Authentification_BusinessLayer.AuthRequests;

namespace IBS_Authentification_BusinessLayer.Service.Register
{
    public interface IRegisterService
    {
        void RegisterUser(RegisterAccountRequest request);
    }
}