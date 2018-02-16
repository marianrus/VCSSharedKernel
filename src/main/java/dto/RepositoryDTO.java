package dto;

public class RepositoryDTO extends DTO
{
    public int id;

    public String name;

    public String full_name;

    public int owner;

    public int getRepositoryId()
    {
        return id;
    }

    public String getName()
    {
        return  name;
    }

    public String getFullName()
    {
        return this.full_name;
    }
}
