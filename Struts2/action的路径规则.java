struts2���action������

Http://localhost:8080/a/b/c/d/demo.action


���Ȳ�����û��һ������ /a/b/c/d ��namespace,����������û��һ������action������Ϊdemo��action,����û��,Ȼ��
namespace = "/a/b/c/d"			action��name="demo.action"	û��	�鿴Ĭ�������ռ���û��	û��[404]
namespace = "/a/b/c"	��ȥһ��·��	action��name="demo.action"	û��	�鿴Ĭ�������ռ���û��	û��[404]
namespace = "/a/b"	��ȥһ��·��	action��name="demo.action"	û��	�鿴Ĭ�������ռ���û��	û��[404]
namespace = "/a"	��ȥһ��·��	action��name="demo.action"	û��	�鿴Ĭ�������ռ���û��	û��[404]
namespace = "/"				action��name="demo.action"	û��	�鿴Ĭ�������ռ���û��	û��[404]


---------------> ������������,ֻҪ�ҵ�ͬ���� action ,��ô��ִ��.�����Ҳ�Ͳ���ִ����!


�Ȳ���pacakge��û��?���û�У��ͼ�ȥһ��Ŀ¼!���Ұ�!�������û�м���������ȥ!
����ҵ���package,��ô�Ϳ�������û��action,����У�ִ��!���û��.��ȥĬ�ϵ������ռ��ң�����Ҳ�����ֱ��404��

ʵ�ʿ���,û̫������!����һ��Ҫ֪����

����һ���ǳ���Ҫ����Ϣ,û�˽��ң��Լ���֤�ģ�
��struts.xml��include������������xml�ļ�������Щ������xml�ļ���,����ͬ�İ���,�Լ�Action���ƣ�
ִ�е�˳�����--->  �ĸ�xml�ȱ�struts.xml���ã�˭��ִ��!���仰˵����,˭���ϣ�˭��ִ�У�

--------------------------------------------------------------------------------------------------
����Action���Ƶ�����˳��
1,��������URL,����URL��:http://localhost:8080/path1/path2/path3/demo.action

2,����Ѱ��namespaceΪ:/path1/path2/path3��package.���������package,��ִ�в���3.
  ����������package,�������package��Ѱ������Ϊdemo��action,���ڸ�pacakage���Ҳ���demo���actionʱ,ֱ���ܵ�Ĭ��namesapce��package����ȥѰ��action(Ĭ�������ռ�Ϊ���ַ���""),�����Ĭ��namespace��package���滹�Ҳ���action,��ô���׳��쳣,����!

3,Ѱ��namesapceΪ:/path1/path2��package,������������package,��ִ�в���4.�������,�������package����Ѱ����Ϊdemo��action,����package���Ҳ���action��ʱ��,ֱ�ӵ�Ĭ�ϵ�namespace��package��ȥѰ������Ϊdemo��action,��Ĭ�ϵ�namespace�л��Ҳ���demo���action,�׳��쳣,����

4,Ѱ��namespaceΪ:/path1��package,������������package��ִ�в���5,����������package,�������package����Ѱ��Ϊdemo��action,���ڸ�package���Ҳ���actionʱ,�ͻ�ֱ���ܵ�Ĭ�ϵ�namespace��package����ȥ������Ϊdemo��action,�����namespace��package���滹�Ҳ�����action,�׳��쳣,����

5,Ѱ��namespaceΪ/��package,����������package,�������package��Ѱ������Ϊdemo��action,����package��Ѱ�Ҳ���demp,���actionʱ,����ȥĬ�ϵ�namespace��package����ȥѰ��action,����ô�Ҳ�����,�Ǿ�ֱ���׳��쳣,����!
