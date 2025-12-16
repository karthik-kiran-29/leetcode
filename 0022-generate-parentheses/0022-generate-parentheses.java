class Solution {

    public List<String> generateParenthesis(int n) {
        return recurseParanthasis(n,n,new ArrayList<String>(),"");
    }

    private List<String> recurseParanthasis(int open,int closed,List<String> list,String comb){
        
        if(open==0 && closed ==0){
            list.add(comb);
            return list;
        }
        
        if(open>0){
            recurseParanthasis(open-1,closed,list,comb+"(");
        }

        if(open < closed){
            recurseParanthasis(open,closed-1,list,comb+")");
        }
        
        return list;
    }
}