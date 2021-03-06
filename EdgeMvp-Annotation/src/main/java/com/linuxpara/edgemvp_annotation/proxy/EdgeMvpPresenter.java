package com.linuxpara.edgemvp_annotation.proxy;

import java.lang.ref.WeakReference;

/**
 * Date: 2018/12/25
 * *************************************************************
 * Auther: 陈占洋
 * *************************************************************
 * Email: zhanyang.chen@gmail.com
 * *************************************************************
 * Description: presenter代理类，的顶级父类
 */
public abstract class EdgeMvpPresenter<V,P> {

    private final WeakReference<P> mWRPresenter;
    private EdgeMvpView<V> mViewProxy;

    public EdgeMvpPresenter(V view, P presenter){
        mViewProxy = createViewProxy(view);
        mWRPresenter = new WeakReference<>(presenter);
    }

    /**
     * 创建view层的代理类
     * @param view
     * @return
     */
    protected abstract EdgeMvpView<V> createViewProxy(V view);

    /**
     * 获取view层的代理类
     * @return
     */
    public EdgeMvpView<V> getViewProxy() {
        return mViewProxy;
    }

    /**
     * 获取persenter
     * @return
     */
    public P getPresenter() throws Exception {
        if (mWRPresenter != null && mWRPresenter.get() != null){
            return mWRPresenter.get();
        }
        throw new Exception("presenter 引用已经被GC回收！");
    }
}
