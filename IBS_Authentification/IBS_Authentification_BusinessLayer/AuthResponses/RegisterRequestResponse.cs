using System;
using Newtonsoft.Json.Linq;

namespace IBS_Authentification_BusinessLayer.AuthResponses
{
    public class RegisterRequestResponse
    {
        public int CustomerId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string CNP { get; set; }
        public DateTime BirthDate { get; set; }
        public int Age { get; set; }
        public string Street { get; set; }
        public string City { get; set; }
        public string Country { get; set; }
        
        public int StatusCode { get; set; }
        
        
        public override string ToString()
        {
            dynamic jsonObject = new JObject();
            jsonObject.CustomerId = CustomerId;
            jsonObject.FirstName = FirstName;
            jsonObject.LastName = LastName;
            jsonObject.CNP = CNP;
            jsonObject.BirthDate = BirthDate;
            jsonObject.Age = Age;
            jsonObject.Street = Street;
            jsonObject.City = City;
            jsonObject.Country = Country;
            jsonObject.StatusCode = StatusCode;
            return jsonObject.ToString(Newtonsoft.Json.Formatting.None);
        }
    }
}