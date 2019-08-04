
/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.a
 * 类名称:     Seven
 * 类描述:     七级台阶
 * 创建人:     huangyang
 * 创建时间:   2019/7/29 10:45
 */
public class Serven {

    public static void main(String[] args){

        System.out.println(show(1));
        System.out.println(show(2));
        System.out.println(show(3));
        System.out.println(show(4));
        System.out.println(show(7));

    }

    /**
     * f(n) = f(n-1) + f(n-2)
     * f(0) = 1;
     * f(1) = 1;
     *
     * // f(2) = 2
     *
     * @param x 台阶级数
     */
    private static int show(int x) {

        if (x == 0 || x == 1) return 1;
        return show(x - 1) + show(x - 2);

        // x = 3
    }

}
