public abstract class Tower_Console extends Console
{
   boolean hasHardDiskDrive;
   String generation;

   public Tower_Console()
   {
       super();
   }

   public void setHasHardDiskDrive(boolean hasHardDiskDrive)
   {
       this.hasHardDiskDrive = hasHardDiskDrive;
   }

   public void setGeneration(String generation)
   {
       this.generation = generation;
   }

   public String getGeneration()
   {
    return generation;
   }

   public boolean getHasHardDiskDrive()
   {
       return hasHardDiskDrive;
   }
}