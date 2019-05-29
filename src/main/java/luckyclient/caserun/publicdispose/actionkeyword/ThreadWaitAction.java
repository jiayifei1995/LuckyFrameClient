package luckyclient.caserun.publicdispose.actionkeyword;


import luckyclient.caserun.publicdispose.ChangString;
import luckyclient.publicclass.LogUtil;

/**
 * 动作关键字的处理接口的实现类：线程等待时间
 * @author: sunshaoyan
 * @date: Created on 2019/4/13
 */
@Action(name="Wait")
public class ThreadWaitAction implements ActionKeyWordParser {


    /**
     * @param actionorder 动作关键字
     */
    @Override
    public String parse(String actionorder, String testResult) {
        if(ChangString.isInteger(actionorder.substring(0, actionorder.lastIndexOf("#Wait")))){
            try {
                // 获取步骤间等待时间
                int time=Integer.parseInt(actionorder.substring(0, actionorder.lastIndexOf("#Wait")));
                if (time > 0) {
                    LogUtil.APP.info("Action(Wait):线程等待"+time+"秒...");
                    Thread.sleep(time * 1000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            LogUtil.APP.error("使用等待关键字的参数不是整数，直接跳过此动作，请检查！");
        }
        return testResult;
    }
}
