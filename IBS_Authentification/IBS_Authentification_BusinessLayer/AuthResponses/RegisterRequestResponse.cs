using System;
using Newtonsoft.Json.Linq;
using Raven.Client;

namespace IBS_Authentification_BusinessLayer.AuthResponses
{
    public class RegisterRequestResponse
    {
        
        public int ResponseCode { get; set; }
        public string ResponseMessage { get; set; }
        
        
        public override string ToString()
        {
            dynamic jsonObject = new JObject();
            jsonObject.responseCode = ResponseCode;
            jsonObject.responseMessage = ResponseMessage;
            return jsonObject.ToString(Newtonsoft.Json.Formatting.None);
        }

        public JsonObject toJson()
        {
            dynamic jsonObject = new JObject();
            jsonObject.responseCode = ResponseCode;
            jsonObject.responseMessage = ResponseMessage;
            return jsonObject;

        }
    }
}