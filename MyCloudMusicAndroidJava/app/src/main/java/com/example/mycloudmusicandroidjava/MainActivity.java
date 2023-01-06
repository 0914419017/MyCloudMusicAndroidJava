package com.example.mycloudmusicandroidjava;


import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.mycloudmusicandroidjava.activity.BaseTitleActivity;
import com.example.mycloudmusicandroidjava.adapter.MainAdapter;
import com.example.mycloudmusicandroidjava.adapter.OnPageChangeListenerAdapter;
import com.example.mycloudmusicandroidjava.databinding.ActivityMainBinding;
import com.example.mycloudmusicandroidjava.modle.ui.TabEntity;
import com.example.mycloudmusicandroidjava.reflect.toast.SuperToast;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings({"all"})
/*findViewBy里面的控件通过反射机制简化
 * 视图通过泛型机制简化 */
public class MainActivity extends BaseTitleActivity<ActivityMainBinding> {

    /*底部指示器 文本 图标 选中图标*/
    private static final int[] indicatorTitles = new int[]{
            R.string.discovery,
            R.string.feed,
            R.string.me
    };

    private static final int[] indicatorIcons = new int[]{
            R.drawable.ic_baseline_find_in_page_24,
            R.drawable.ic_baseline_feedback_24,
            R.drawable.ic_baseline_assignment_ind_24
    };

    private static final int[] indicatorSelectedIcons = new int[]{
            R.drawable.ic_baseline_find_in_page_24_selected,
            R.drawable.ic_baseline_feedback_24_selected,
            R.drawable.ic_baseline_assignment_ind_24_selected
    };
    private MainAdapter adapter;

    @Override
    protected boolean isShowBackMenu() {
        return false;
    }

    @Override
    protected void initViews() {
        super.initViews();
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.container, FeedFragment.newInstance())
//                .commit();
        //缓存默认数量 默认为一个
        binding.list.setOffscreenPageLimit(3);
        //指示器
        ArrayList<CustomTabEntity> tabs = new ArrayList<>();
        for (int i = 0; i < indicatorIcons.length; i++) {
            tabs.add(new TabEntity(
                    getString(indicatorTitles[i]),
                    indicatorSelectedIcons[i],
                    indicatorIcons[i]
            ));
        }
        binding.indicator.setTabData(tabs);

        //动态tab显示消息提醒
        binding.indicator.showDot(0);

    }


    @Override
    protected void initDatum() {
        super.initDatum();
        //创建adapter
        adapter = new MainAdapter(this, getSupportFragmentManager());

        //设置控件
        binding.list.setAdapter(adapter);

        adapter.setDatum(Arrays.asList(
                0, 1, 2       //这三个数据可以随便写 只是让数据占三个位置
        ));
    }

    //实现fragment页面和状态栏的联动效果
    @Override
    protected void initListeners() {
        super.initListeners();
        //设置指示器切换监听器 也就是点击列表实现联动
        binding.indicator.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {//选中
                binding.list.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        //监听列表 也就是列表左右滑动实现联动
        binding.list.addOnPageChangeListener(new OnPageChangeListenerAdapter() {
            @Override
            public void onPageSelected(int position) {//选中状态
                binding.indicator.setCurrentTab(position);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.discovery, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            SuperToast.show("点击了添加");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}