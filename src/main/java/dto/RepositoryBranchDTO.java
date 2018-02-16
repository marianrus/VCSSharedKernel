package dto;

public class RepositoryBranchDTO extends DTO
{
    private String name;

    private String commit_sha;

    private int repository_id;

    public String getName()
    {
        return name;
    }

    public String getCommitSha()
    {
        return  commit_sha;
    }

    public int getRepositoryId()
    {
        return repository_id;
    }
}
