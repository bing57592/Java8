package com.ysu._12_classload;

/**
 * 单分派, 多分派演示.
 *
 * @Author bing57592
 * @Date 2018-11-09 20:51
 */
public class _05_Dispatch {
    static class QQ {
    }

    static class _360 {
    }


    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
