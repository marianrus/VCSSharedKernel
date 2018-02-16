package dto;

import java.sql.Date;

public class RepositoryPullRequestDTO extends DTO
{
    private int id;

    private String title;

    private int repository_id;

    private String url;

    private String diff_url;

    private int number;

    private String state;

    private boolean locked;

    private int user_id;

    private Date created_at;

    private Date updated_at;

    private Date closed_at;

    private Date merged_at;

    private String merge_commit_sha;

}
