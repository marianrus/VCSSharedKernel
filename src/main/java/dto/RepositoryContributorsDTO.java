package dto;

public class RepositoryContributorsDTO extends DTO
{
    private int repository_id;

    private int user_id;

    private int contributions;

    public int getUserId()
    {
        return user_id;
    }

    public int getContributions() {
        return this.contributions;
    }

    public int getRepositoryId() {
        return repository_id;
    }

}
