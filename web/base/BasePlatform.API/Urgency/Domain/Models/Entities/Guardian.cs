using System.ComponentModel.DataAnnotations;

namespace BasePlatform.API.Urgency.Domain.Models.Entities;

public class Guardian
{
    public int Id { get;set; }
    
    [MaxLength(30)]
    public string Username { get; set; }
    public string Email { get; set; }
    public string LastName { get; set; }
    public string FirstName { get; set; }
    public string Gender { get; set; }
    public string Address { get; set; }
}


