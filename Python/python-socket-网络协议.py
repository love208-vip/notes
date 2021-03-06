----------------------------
网络协议入门				|
----------------------------

----------------------------
网络-物理层和链路层			|
----------------------------
	* 以太网协议(ethernet)
		* 一组电信号组成一个数据包,叫做 - 帧
		* 每一帧分为:报头(head)和数据(data)两部分
			 ———————————————————————————————
			|head| data						|
			 ———————————————————————————————
			 * head(固定18个字节)
				* 发送者/源地址		:6个字节
				* 接收者/目标地址	:6个字节
				* 数据类型			:6个字节
			* data(最短64字节,最长1500字节)
				* 数据包的具体内容
			
			* head + data 最大长度就是 1518字节 (1500 +18),超过长度,就分片发送
	
	* mac地址
		* head 中包含的源地址和目标地址的由来.
		* ethernet 规定,接入internet的设备,都必须要具备网卡,发送端和接收端的地址,就是指网卡地址,也就是mac地址
		* 每块网卡出厂时,都被烧录了世界上唯一的mac地址,长度为 48 位 2进制,通常由 12 位 16进制 表示
			 00:16:3e:16:0b:5e
			* 前面6位是厂商编号
			* 后面6位是流水号
		
	
	* 广播
		* 有了mac地址,同一个网络内的两台主机就可以通信了(一台主机通过arp协议获取另一台主机的mac地址)
		* ethernet 采用最原始的方式 - 广播,方式进行通信,通俗点.计算机通信基本靠吼

		IEEE802.1Q
		 ———————————————————————————————————————————————————————————————————————————
		|目标mac地址	|发送源mac地址	|TDIP	|TCI	|类型	|数据部分	|CRC	|
		 ———————————————————————————————————————————————————————————————————————————
		目标mac地址		:6字节					
		发送源mac地址	:6字节
		TDIP			:0x8100
		TCI				:内含12个bit的vlan标识
		类型			:2字节
		数据部分		:46 - 1500 字节
		CRC				:4字节,经过重新计算
