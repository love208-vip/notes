------------------------
java.util.Map			|
------------------------
	V getOrDefault(Object key,V defaultVlue);
		* ��� key ����,�򷵻� Value,���������,�򷵻� defaultVlue 
	
		
	V compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction) 
		* ��ͨ�� key ȥ���� value,�������ֱ�ӷ���
		* ���value ������,������ remappingFunction Lambda ��ȡ value,���Ҵ��� map,Ȼ�󷵻�
	

------------------------
java.lang.String		|
------------------------
	 public static String join(CharSequence delimiter, CharSequence... elements) ;
		* �Ѷ�� elements �� delimiter ������������,����µ��ַ�������