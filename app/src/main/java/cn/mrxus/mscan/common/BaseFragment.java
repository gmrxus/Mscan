package cn.mrxus.mscan.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.mrxus.mscan.R;

/**
 * Created by mrxus on 16/7/25.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this, rootView);

        init();

        return rootView;

    }

    protected abstract void init();

    protected abstract int getLayoutId();

}
