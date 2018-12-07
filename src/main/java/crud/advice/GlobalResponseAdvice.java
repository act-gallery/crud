package crud.advice;

import act.app.ActionContext;
import act.handler.ReturnValueAdvice;
import com.alibaba.fastjson.JSONObject;
import crud.util.ResponseData;

public class GlobalResponseAdvice implements ReturnValueAdvice {

    @Override
    public Object applyTo(Object o, ActionContext actionContext) {
        if (o instanceof ResponseData) {
            return o;
        } else if (o instanceof JSONObject) {
            if(((JSONObject) o).get("_rd") != null) {
                return o;
            }
        }
        return new ResponseData(o);
    }
}
