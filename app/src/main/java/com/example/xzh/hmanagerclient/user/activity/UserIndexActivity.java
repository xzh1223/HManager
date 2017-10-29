package com.example.xzh.hmanagerclient.user.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.KeyEvent;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.base.BaseActivity;
import com.example.xzh.hmanagerclient.general.utils.ToastUtil;
import com.example.xzh.hmanagerclient.user.check.fragment.CheckFragment;
import com.example.xzh.hmanagerclient.user.forum.fragment.ForumFragment;
import com.example.xzh.hmanagerclient.user.work.fragment.WorkFragment;

/**
 * Created by Administrator on 2017/10/28.
 * <p>
 * 用户首页
 */

public class UserIndexActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;
    private FragmentTransaction mTransaction;
    private ForumFragment mForumFragment;
    private Fragment mCurrentFragment;
    private WorkFragment mWorkFragment;
    private CheckFragment mCheckFragment;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bnb_main);

        setBottomAndPage();

    }

    /**
     *  设置底部导航与页面
     */
    private void setBottomAndPage() {

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "展示")
                .setActiveColorResource(R.color.md_blue_400))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "工作")
                        .setActiveColorResource(R.color.md_blue_400))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "签到")
                        .setActiveColorResource(R.color.md_blue_400))
                .setFirstSelectedPosition(0)
                .initialise();

        // 设置默认页
        mTransaction = getSupportFragmentManager().beginTransaction();
        mForumFragment = new ForumFragment();
        mTransaction.add(R.id.frame_content, mForumFragment).commit();
        mCurrentFragment = mForumFragment;

    }

    @Override
    protected void initEvent() {
        mBottomNavigationBar.setTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                if (mForumFragment == null)
                    mForumFragment = new ForumFragment();
                switchFragment(mForumFragment);
                break;

            case 1:
                if (mWorkFragment == null)
                    mWorkFragment = new WorkFragment();
                switchFragment(mWorkFragment);
                break;

            case 2:
                if (mCheckFragment == null)
                    mCheckFragment = new CheckFragment();
                switchFragment(mCheckFragment);
                break;

            default:

                break;
        }
    }

    /**
     *  导航切换
     */
    private void switchFragment(Fragment fragment) {
        if (mCurrentFragment != fragment) {
            mTransaction = getSupportFragmentManager().beginTransaction();
            if (!fragment.isAdded()) {
                mTransaction.hide(mCurrentFragment).add(R.id.frame_content, fragment).commit();
            } else {
                mTransaction.hide(mCurrentFragment).show(fragment).commit();
            }
            mCurrentFragment = fragment;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    // 按两次返回键退出
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtil.toast(this, "再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
