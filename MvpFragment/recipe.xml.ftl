<?xml version="1.0"?>
<recipe>



	<!-- instantiate 表示创建文件到指定文件夹	（把需要创建文件的模板放在root文件夹下对应文件夹）	  -->
    <instantiate from="root/res/layout/fragment_layout.xml.ftl" 
					to="${escapeXmlAttribute(resOut)}/layout/fragment_${fragment_layout}.xml" /> //布局
    <instantiate from="root/src/app_package/MvpFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/rerxmvp/view/fragment/${FragmentName}.java" />//Fragment
    <instantiate from="root/src/app_package/MvpContract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/entry/${EntryName}.java" />                     //Entry
     <instantiate from="root/src/app_package/MvpPresenter.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/rerxmvp/presenter/${PresenterName}.java" />     //Presenterimpl

</recipe>
