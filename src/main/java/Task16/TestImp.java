package Task16;

import java.util.ArrayList;

public class TestImp implements Test{

    public ArrayList<Integer> test(int n){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(i);
        }
        return res;
    }
}
