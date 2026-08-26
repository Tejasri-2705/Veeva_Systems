package oop;

class LockInfo {
    String user;
    int timestamp;
   public  LockInfo(String user,int timestamp)
    {
        this.user=user;
        this.timestamp=timestamp;
    }
    public int gettimestamp()
    {
        return timestamp;
    }
    public String getUser()
    {
        return user;
    }
}
