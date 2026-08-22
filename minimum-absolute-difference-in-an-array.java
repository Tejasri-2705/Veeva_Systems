public static int minimumAbsoluteDifference(List<Integer> arr) {
    // Write your code here
    Collections.sort(arr);
    int mind=Integer.MAX_VALUE;
    for(int i=1;i<arr.size();i++)
    {
        mind=Math.min(mind,(Math.abs(arr.get(i-1)-arr.get(i))));
    }
    return mind;

    }

/*hacker rank*/
