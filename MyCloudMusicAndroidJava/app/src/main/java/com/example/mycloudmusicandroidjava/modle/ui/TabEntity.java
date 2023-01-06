package com.example.mycloudmusicandroidjava.modle.ui;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * 自定义zhi's
 */
public class TabEntity implements CustomTabEntity {
    public String title;//标题
    public int selectedIcon;//选中图标
    public int unSelectedIcon;//未选中图标

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
