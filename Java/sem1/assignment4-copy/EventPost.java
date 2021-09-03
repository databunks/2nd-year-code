

public class EventPost extends Post
{
    String eventType;
    String eventDate;
    String eventTime;

    private String eventPost;

    public EventPost()
    {
      super();
    }

    public void setEventType(String eventType)
    {
      this.eventType = eventType;
    }

    public void setEventDate(String eventDate)
    {
      this.eventDate = eventDate;
    }

    public void setEventTime(String eventTime)
    {
      this.eventTime = eventTime;
    }


    public String getEventType()
    {
        return eventType;
    }

    public String getEventDate()
    {
        return eventDate;
    }
    
    public String eventTime()
    {
        return eventTime;
    }

    public String toString()
    {
        eventPost = "";
        eventPost += "Event Type : " + eventType + ";\n";
        eventPost += "Event Date : " + eventDate + ";\n";
        eventPost += "Event Time : " + eventTime + ";";
        return eventPost;
    }
}