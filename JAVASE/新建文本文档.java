	ArrayList al = new ArrayList();
1，add方法的参数类型是Object。以便于接收任何对象。
2，集合中存储的都是对象的引用（地址）。
------------------------------------------------------------------------
	添加元素：
al.add(obj);//添加一个对象在容器的最后面。
	删除元素：
al.remove(obj);//删除其中obj对象。只删除第一个obj对象！后面有同名，不动！
	查看容器长度：
al.size();//size();是容器的一个方法！不是属性！
	清空集合
al.clear();//清空一个容器的集合。
	查询对象是否存在
al.contains(obj);//查询对象obj是否存在于容器中。
	判断集合是否为空
al.isEmpty();//判断集合是否为空。
	取交集
al.retainAll(al2);//取交集！al中只会保留和al2中相同的元素。如果都不相同！则清空al。
al.removeAll(als);//删除掉al中与al2相同的元素。
------------------------------------------------------------------------
	迭代器
什么是迭代器：
	其实就是集合取出元素的方式。
	把取出方式定义在集合的内部。这样取出方式就可以直接访问集合内部元素。那么取出方式就定义成了内部类。
	而每一个容器的数据结构不同，所以取出的动作细节也不一样！但是都有共性内容-判断和取出！那么可以将共性抽取。
	这些内部类都符合一个规则。该规则是Iterator
	如何获取集合的取出对象呢！。通过一个对外提供的方法！——iterator();
-----------------------------------------------------------------------
Iterator it = al.iterator();
while(it.hasNezt())	//while循环
{
	System.out.println(it.next());
}

for(Iterator it = al.iterator();it.hasNext();)	//for循环
{
	System.out.println(it.next());
}
通过迭代器遍历打印出al中的元素！
两种循环方式的的不同之处在于！while结束后it对象还在内存当中。for循环结束后it对象被释放！
------------------------------------------------------------------------

	
