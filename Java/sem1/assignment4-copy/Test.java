public class Test
{
    public static void main(String[] args)
    {
        MessagePost messagePost1 = new MessagePost();
        messagePost1.setMessage("Fortnite");
        messagePost1.addComment("bruhMomento moment nice meme");
        messagePost1.addComment("We Like fortnite");
        messagePost1.addComment("I hate poggers memes");

        System.out.println(messagePost1);

        PhotoPost photoPost1 = new PhotoPost();
        photoPost1.setFileName("poggers");
        photoPost1.setCaption("Bruh");

        System.out.println(photoPost1);


    }
}