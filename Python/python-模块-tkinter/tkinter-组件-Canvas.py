----------------------------
Canvas						|
----------------------------
	* HTML5的 Canvas,你感到绝望了吗?
	* 画板
	* 构造函数
		
	
----------------------------
Canvas-属性					|
----------------------------
	width
		* 宽度的像素值
	
	height
		* 高度的像素值
	
----------------------------
Canvas-方法					|
----------------------------
	create_line()
		* 创建横线,返回是一个元件的ID值
		* 参数
			左边距(x)
			上边距(y)
			长度	
			终点上边距(y)
		* 关键字参数
			width	
				* 线条的宽度,像素

	create_rectangle()
		* 创建矩形,返回是一个元件的ID值
		* 参数
			X
			y
			宽
			高
	create_oval()
		* 创建椭圆/圆
		* 参数
	
	create_text()
		* 创建文本
	
	create_polygon()
		* 创建多边形

	coords(id,**(coords))
		* 移动元件
		* id:元件的ID
		* coords:新的坐标

	itemconfig(id,**{config})
		* 设置组件的属性

	delete(id)
		* 删除指定的组件
		* 也可以传递常量ALL,表示删除所有
	
	# 元件的通用属性
		fill	
			* 设置填充颜色
		dash
			* 设置边框为虚线,该值是一个 tuple
			* 第一个参数表示虚线的长度,第二个值表示虚线间隔的长度