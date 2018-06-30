//find three numbers in an array eqaul to a given sum
class Solution {
    public List<List<Integer>> threeSum(int[] a) {

      List<List<Integer>> a1=new ArrayList<>();

      Arrays.sort(a);
        int n=a.length;
      for(int i=0;i<n-1;i++)
      {
          if(i>0&&a[i]==a[i-1])continue;
          int left=i+1;
          int right=n-1;
          while(left<right)
          {
              if(a[i]+a[left]+a[right]==0)
              {
                  List<Integer> a2=new ArrayList<>();
                  a2.add(a[i]);
                  a2.add(a[left]);
                  a2.add(a[right]);
                  a1.add(a2);
                  while(left+1<n&&a[left]==a[left+1])left++;
                  while(right-1>left&&a[right]==a[right-1])right--;

                  left++;
                  right--;
              }else if(a[left]+a[right]+a[i]<0)
                  left++;
              else
                  right--;
          }

      }
        return a1;

    }
}
