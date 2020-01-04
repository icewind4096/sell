package com.windvalley.sell.utils;

import com.windvalley.sell.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        return new ResultVO(0, "成功", object);
    }

    public static ResultVO sucess(){
        return success(null);
    }

    public static ResultVO error(Integer code, String message){
        return new ResultVO(code, message, null);
    }
}
