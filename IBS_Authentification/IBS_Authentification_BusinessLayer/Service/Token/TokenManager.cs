using System;
using System.IdentityModel.Tokens.Jwt;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using JWT.Algorithms;
using JWT.Builder;
using System.Web;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Http.Internal;

namespace IBS_Authentification_BusinessLayer.Service.Token
{
    public class TokenManager
    {
        public static string GenerateAccessToken(string toHash)
        {
            var crypt = new System.Security.Cryptography.SHA256Managed();
            var hash = new System.Text.StringBuilder();
            byte[] crypto = crypt.ComputeHash(Encoding.UTF8.GetBytes(toHash));
            foreach (byte theByte in crypto)
            {
                hash.Append(theByte.ToString("x2"));
            }
            return hash.ToString();
        }
    }
}