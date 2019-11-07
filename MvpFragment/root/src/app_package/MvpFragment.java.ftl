package ${packageName}.rerxmvp.view.fragment;

import ${packageName}.R;
import ${packageName}.base.BaseFragment;
import ${packageName}.entry.${EntryName};
import ${packageName}.http.ServiceMapParams;
import ${packageName}.rerxmvp.interfaceUtils.interfaceUtilsAll;
import ${packageName}.rerxmvp.presenter.${EntryName}PresenterImpl;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import java.util.List;

/**
 * Created by tushuangxi on 2019/4/3.
 * @author tushuangxi
 *
 *   拷贝到在android studio的D:\android-studio\plugins\android\lib\templates\activities 这个目录下存在着androidstudio新建项目的模板
 */
public class ${FragmentName} extends BaseFragment implements  interfaceUtilsAll.${EntryName}View{


   private interfaceUtilsAll.${EntryName}Presenter m${EntryName}Presenter;

    @Override
    protected int getLayoutId() {
         return R.layout.activity_${fragment_layout};
    }

     @Override
     public void initView(View view, Bundle savedInstanceState) {


    }

    @Override
    public void loadData(Bundle args) {

            m${EntryName}Presenter = new ${EntryName}PresenterImpl(this);
            m${EntryName}Presenter.request${EntryName}List(true,ServiceMapParams.get${EntryName}MapParams());
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
