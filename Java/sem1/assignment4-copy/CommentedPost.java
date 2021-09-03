import java.util.ArrayList;
public abstract class CommentedPost extends Post
{
    ArrayList<String> comments  = new ArrayList<String>();
    int numberOfComments;
    int numberOfLikes;

    public CommentedPost()
    {
        super();
        numberOfLikes = 0;
        numberOfComments = 0;
    }

    public int getNoLikes()
    {
        return numberOfLikes;
    }

    public String getComment(int index)
    {
        return comments.get(index);
    }

    public void setLikes(int numberOfLikes)
    {
        this.numberOfLikes = numberOfLikes;
    }
    public void addLike()
    {
       numberOfLikes++;
    }

    public void removeLike()
    {
       numberOfLikes--;
    }

    public void addComment(String comment)
    {
        comments.add(comment);
        numberOfComments++;
    }

    public void removeComment(int index)
    {
        comments.remove(index);
        numberOfComments--;
    }
}