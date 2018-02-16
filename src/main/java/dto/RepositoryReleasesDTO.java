package dto;

import java.sql.Date;

public class RepositoryReleasesDTO extends DTO
{
    private int id;

    private String name;

    private String tag_name;

    private String tag_commitish;

    private boolean draft;

    private int author_id;

    private boolean prerelease;

    private Date created_at;

    private Date published_at;

    private String body;

    private int repository_id;

}
