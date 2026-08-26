package oop;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
class DocumentLock {
    private final Map<String,LockInfo> locks;
    public DocumentLock()
    {
        locks=new HashMap<>();
    }
    public synchronized boolean requestLock(String docId ,String user,int timestamp)
    {
        if(locks.containsKey(docId))
        {
            return false;
        }
        locks.put(docId,new LockInfo(user,timestamp));
        return true;
    }
    public synchronized boolean releaseLock(String docId,String user)
    {
        if(!locks.containsKey(docId))
        {
            return false;
        }
        LockInfo lockInfo=locks.get(docId);
        if(!lockInfo.user.equals(user))
        {
            return false;
        }
        locks.remove(docId);
        return true;
    }
    public synchronized void cleanexplock(int ts,int duration)
    {
        Iterator<Map.Entry<String,LockInfo>> iterator=locks.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String,LockInfo> entry=iterator.next();
            LockInfo lockInfo=entry.getValue();
            if(ts-lockInfo.gettimestamp()>duration)
            {
                iterator.remove();
            }
        }
    }
    public static void main(String args[])
    {
        DocumentLock manager = new DocumentLock();

        System.out.println(
                manager.requestLock("doc1", "user1", 100)
        );

        System.out.println(
                manager.requestLock("doc1", "user2", 110)
        );

        System.out.println(
                manager.releaseLock("doc1", "user2")
        );

        System.out.println(
                manager.releaseLock("doc1", "user1")
        );

        System.out.println(
               manager.requestLock("doc1", "user2", 120)
        );
    }
    
}
