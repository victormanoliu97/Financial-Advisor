using IBS_Authentification_BusinessLayer.AuthRequests;
using IBS_Authentification_BusinessLayer.AuthResponses;
using IBS_Authentification_BusinessLayer.Repository;

namespace IBS_Authentification_BusinessLayer.Service.Register
{
    public class RegisterService : IRegisterService
    {
        private readonly AuthRepository _authRepository;

        public RegisterService(AuthRepository authRepository)
        {
            _authRepository = authRepository;
        }

        public RegisterRequestResponse RegisterUser(RegisterAccountRequest request)
        {
            if (request == null) return new RegisterRequestResponse {ResponseCode = 422, ResponseMessage = "Null Request"};
            if (_authRepository.UserAlreadyExists(request.Email) == false)
            {
                _authRepository.RegisterAccount(request);
                return new RegisterRequestResponse {ResponseCode = 200, ResponseMessage = "Ok"};
            }
            return new RegisterRequestResponse {ResponseCode = 500, ResponseMessage = "Internal Server Error"};
        }
    }
}