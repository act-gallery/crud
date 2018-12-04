package crud.advice;

import act.app.ActionContext;
import act.handler.ReturnValueAdvice;
import crud.util.ResponseData;

public class GlobalResponseAdvice implements ReturnValueAdvice {

    @Override
    public Object applyTo(Object o, ActionContext actionContext) {
        if (o instanceof ResponseData) {
            return o;
        }
        return new ResponseData(o);
    }
}
