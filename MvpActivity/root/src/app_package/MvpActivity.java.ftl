package ${packageName}.rerxmvp.view.activity;

import ${package}.R;
import ${packageName}.base.BaseActivity;
import ${packageName}.entry.${EntryName};
import ${packageName}.http.ServiceMapParams;
import ${packageName}.rerxmvp.interfaceUtils.interfaceUtilsAll;
import ${packageName}.rerxmvp.presenter.${EntryName}PresenterImpl;

import android.os.Bundle;
import android.view.View;
import java.util.List;


/**
 * Created by tushuangxi on 2019/4/3.
 * @author tushuangxi
 *
 *   拷贝到在android studio的D:\android-studio\plugins\android\lib\templates\activities 这个目录下存在着androidstudio新建项目的模板
 */
public class ${ActivityName} extends BaseActivity implements  interfaceUtilsAll.${EntryName}View{


   private interfaceUtilsAll.${EntryName}Presenter m${EntryName}Presenter;

    @Override
    protected int getLayoutId() {
         return R.layout.activity_${activity_layout};
    }

    @Override
    protected void initView() {


            m${EntryName}Presenter = new ${EntryName}PresenterImpl(this);
            m${EntryName}Presenter.request${EntryName}List(true,ServiceMapParams.get${EntryName}MapParams());
    }

   @Override
    protected View getRootView() {
        return findViewById(R.id.root);
    }


  @Override
    protected void onDestroy() {
        super.onDestroy();
        m${EntryName}Presenter.onDestroy();
    }

    @Override
    public void dismissRefreshView() {

    }

    @Override
    public void update${EntryName}(${EntryName} i${EntryName}json) {

    }

    @Override
    public void update${EntryName}List(List<${EntryName}> newsList) {

    }
}
