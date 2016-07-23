package cn.mrxus.mscan.MVP.view;

/**
 * Created by mrxus on 16/7/22.
 */
public interface MainView {
    /**
     * 显示侧滑菜单
     */
    void showMenu();

    /**
     * 隐藏侧滑菜单
     */
    void hideMenu();

    /**
     * 显示设置弹框
     */
    void shouSetting();

    /**
     * 隐藏设置弹框
     */
    void hideSetting();

    /**
     * 显示没有网络提示
     */
    void shouNotNetwork();

    /**
     * 显示progressbar
     */
    void shouProgressBar();

    /**
     * 隐藏progressbar
     */
    void hideProgressBar();

    /**
     * 显示没有数据
     */
    void shouNotHaveData();

    /**
     * 隐藏没有数据
     */
    void hideNotHaveData();

}
