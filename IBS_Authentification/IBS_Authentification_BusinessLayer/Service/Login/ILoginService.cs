using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;

namespace IBS_Authentification_BusinessLayer.Service
{
    public interface ILoginService
    {
        LoginRequestResponse LoginUser(LoginAccountRequest loginAccountRequest);
        LoginRequestResponse CreateLoginResponse(LoginAccountRequest loginAccountRequest, int statusCode);
    }
}