public class Time 
{
  private int hour;
  private int minute;
  private String ampm;

  public Time()
  {
    
  }
  
  public void setTime(int hour, int minute, String ampm)
  {
    if (hour > 12 || minute > 60 || hour < 1 || minute < 0) System.out.println("Error incorrect time format");
    this.hour = hour;
    this.minute = minute;
    this.ampm = ampm;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinutes()
  {
    return minute;
  }

  public String getAmPm()
  {
    return ampm;
  }

}
