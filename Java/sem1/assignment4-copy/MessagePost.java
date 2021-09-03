public class MessagePost extends CommentedPost
{
    String message;
    private String messagePost;

    public MessagePost()
    {
        super();
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String toString()
    {
        messagePost = "";
        messagePost += "Username : " + username + "\n";
        messagePost += "Message : " + message + ";";
        messagePost += "Comments : \n";
        for (int i = 0; i < numberOfComments; i++)
        {
           messagePost += "[" + i  + "] " + this.getComment(i) + "\n";
        }
        messagePost += "Likes : " + this.getNoLikes();
        return messagePost;
    }
}