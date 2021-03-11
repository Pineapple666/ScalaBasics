public class Generals {

    private static final String armsName = "青龙偃月刀";

    public void toWar() {
        // 打仗
        System.out.println("武将拿着" + armsName + ", 上阵杀敌");
    }

    public static void main(String[] args) {
        new Generals().toWar();
    }
}