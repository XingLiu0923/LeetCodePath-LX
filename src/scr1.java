import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class scr1 {
    double Z = 0;
    public double eraseOverlapIntervals() {
        double s0 = 47.25; // initial_stock_price, to be decided;
        double rf = 0.014;  // risk free rate, to be decided;
        double sigma = 0.17;  // variance
        int N = 10000;       // 循环总次数；
        double deltime = 1;     // 时间间隔 = 1 day
        int numperiods =  365 * 10;      // 我需要每一天的股价；

        double mu = rf - Math.pow(sigma, 2) / 2;

        List<Double> sList = new ArrayList<>();        // 满足条件的s，记录下来;

        for (int i = 0; i < N; i++) {
            /* 对每个世界进行循环扫描 */
            Vector<Double> window = new Vector<>();        // 窗口记录s值；
            int windowsCount = 0;       // 窗口中满足条件的数字；
            window.add(s0);
            if (window.get(0).doubleValue() > 120) windowsCount++;
            for (int j = 1; j < 30; j++) {      // 初始化windows;
                window.add(countNextS(window.get(j - 1), mu, deltime, sigma));
                if (window.get(j) > 120) windowsCount++;
                if (windowsCount == 20) { sList.add(window.get(j)); break; }
            }
            if (windowsCount >= 20) continue;
            for (int j = 30; j < numperiods / deltime; j++) {     // 不断向后进行滑动，每次都去除第一个数并加入新数；
                if (window.get(0).doubleValue() > 120) windowsCount--;
                window.remove(0);       // 去除第一个数字；
                window.add(countNextS(window.get(28), mu, deltime, sigma));     // 加入最后一个数字；
                if (window.get(29).doubleValue() > 120) windowsCount++;
                if (windowsCount == 20) {
                    /*for (double each : window) {
                        System.out.print(each + " ");

                    }
                    System.out.println();*/
                    sList.add(window.get(29));
                    break;
                }
            }
        }
        return (double) sList.size() / N;
    }

    private double countNextS(double lastS, double mu, double deltatime, double sigma) {
        Z = StandardNormalDistribution();
        if (Z > 100) System.out.print(Z + " ");
        return lastS * Math.exp(mu * deltatime + sigma * Math.sqrt(deltatime) * Z);
    }

    public static double StandardNormalDistribution(){
        java.util.Random random = new java.util.Random();
        return random.nextGaussian();
    }

    public List<List<Double>> historyStock() {
        double s0 = 47.25; // initial_stock_price, to be decided;
        double rf = 0.014;  // risk free rate, to be decided;
        double sigma = 0.17;  // variance
        int N = 10000;       // 循环总次数；
        int deltime = 1;     // 时间间隔 = 1 day
        int numperiods = 30 * 365;      // 我需要每一天的股价；

        double mu = rf - Math.pow(sigma, 2) / 2;

        List<List<Double>> lists = new ArrayList<>();

        // List<Double> sList = new ArrayList<>();        // 满足条件的s，记录下来;

        for (int i = 0; i < 10; i++) {
            /* 对每个世界进行循环扫描 */
            List<Double> list = new ArrayList<>();
            list.add(s0);
            for (int j = 1; j < numperiods; j++) {     // 不断向后进行滑动，每次都去除第一个数并加入新数；
                list.add(countNextS(list.get(list.size() - 1), mu, deltime, sigma));
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        // new scr1().historyStock();
        System.out.println(new scr1().eraseOverlapIntervals());
    }
}