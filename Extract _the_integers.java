class Solution {
    public List<String> extractInt(String s) {
        
        List<String> ans=new ArrayList<>();
        s=s.toLowerCase();
        s=s.replaceAll("[^0-9]"," ");
        s=s.trim();
        String a[]=s.split("\\s+");
        for(String i:a)
        {
            ans.add(i);
        }
        return ans;
        
    }
}
