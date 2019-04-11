using IBS_Authentification_BusinessLayer.AuthRequests;
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

        public void RegisterUser(RegisterAccountRequest request)
        {
            if (request == null) return;
            if (_authRepository.UserAlreadyExists(request.Email) == false)
            {
                _authRepository.RegisterAccount(request);
            }
        }
    }
}