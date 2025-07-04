import controller.MainController;
import utils.constant.Const;

/*
*********************************************************************************************************
*  @Java Class Name :   App
*  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
*  @Company         :   Antrazal
*  @Date            :   04-07-2024
*  @Description     :   App is the main entry point of the application.
*********************************************************************************************************
*/


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Const.WELCOME);
        MainController.mainController();
    }
}