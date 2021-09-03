public class Shareable
{
    private PhotoPost postRef = new PhotoPost();
    private EventPost eventRef = new EventPost();
    

    public void sharePost()
    {
        System.out.println("--------------Shareable Post------------------");
        System.out.println(postRef);
        System.out.println(eventRef);
        System.out.println("----------------------------------------------");

    }

}

