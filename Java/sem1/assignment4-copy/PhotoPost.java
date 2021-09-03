public class PhotoPost extends CommentedPost
{
    String fileName;
    String caption;
    private String photoPost;

    public PhotoPost()
    {
      super();
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getCaption()
    {
        return caption;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setCaption(String caption)
    {
      this.caption = caption;
    }


    public String toString() 
    {
      photoPost = "";
      photoPost += "File name : ";
      photoPost += fileName + ";\n";
      photoPost += "Caption : ";
      photoPost += caption + ";\n";
      return photoPost;
    }
}