/*the veeva systems specializes in a cloud based s/w in a cloud there will be documents which are accessed by differen user.now implement 
    a light weight simulation of a concurrent document managemet system that grants or desires locks on documents to users and release locks 
    on documents  now design and imlement document lock manager class witrh following methods 1.request_lock (Dtring dco id,String userId,int timestamp) 
    this method grants a lock to user if the document is not already locked by someone else return true if successfult 
    2)realease lock(String docid,String user_id) it realeases the lock if holding user request it return true if succesfullly released and false
    otherwise 3)cleanexpiredLocks(int timestamp,int duration) these emthod releases all the Logs that have been longer than allowed duration relative to 
    current timestamppackage oop;*/
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
