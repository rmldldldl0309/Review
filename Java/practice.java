class Solution {
    public String solution(String code) {
        reurn 
        String[] code_ = code.split("");
        int mode = 0;
        String ret = "";

        for (int idx = 0; idx <= code_.length; idx++){
            if (mode == 0){
                if (code_[idx] != "1" && idx % 2 == 0){
                    ret = ret.concat(code_[idx]);
                }
                else{
                    mode  = 1;
                }
            }
            else if (mode == 1){
                if (code_[idx] != "1" && idx % 2 == 1){
                    ret = ret.concat(code_[idx]);
                }
                else{
                    mode = 0;
                }
            }
        }
        if (ret == ""){
            return = "empty"
        }
        else{
            return = ret;
        }
    }
}