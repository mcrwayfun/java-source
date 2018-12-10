package com.mcrwayfun.exercise._25;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/11
 * @description
 */
public class Eating {

    // 私有（当前类）
    private void breakfast() {
        System.out.println("I m eating breakfast");
    }

    // 保护（当前类-子类-包访问）
    protected void lunch() {
        System.out.println("I m having lunch");
    }

    // 包访问（当前-包访问）
    void dinner() {
        System.out.println("I m having dinner");
    }
}
