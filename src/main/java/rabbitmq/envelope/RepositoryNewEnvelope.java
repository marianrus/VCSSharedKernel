package rabbitmq.envelope;

public class RepositoryNewEnvelope extends Envelope
{
    private String repositoryName;

    public static RepositoryNewEnvelope createFromString(String repositoryName)
    {
        RepositoryNewEnvelope newRepositoryToAddEnvelope = new RepositoryNewEnvelope();
        newRepositoryToAddEnvelope.repositoryName = repositoryName;

        return newRepositoryToAddEnvelope;
    }

    public String getRepositoryName()
    {
        return  this.repositoryName;
    }
}
