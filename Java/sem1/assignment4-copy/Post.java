public abstract class Post
{
    String timeStamp;
    String username;
    int numberOfPosts;

    public Post(String username, String timeStamp)
    {
      timeStamp = "10/12/2020";
      username = "EpicHaxor59";
    }

    public Post()
    {}

    public String getUsername()
    {
      return username;
    }

    public String getTimeStamp()
    {
      return timeStamp;
    }


    public int getNumberOfPosts()
    {
      return numberOfPosts;
    }

    public void setTimeStamp(String timeStamp)
    {
      this.timeStamp = timeStamp; 
    }
    
}